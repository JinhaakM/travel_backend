package net.daum.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
public class ImportApiController {

    private IamportClient api;

    public ImportApiController(@Value("${iamport.api.key}") String apiKey, @Value("${iamport.api.secret}") String apiSecret) {
    	
    		    this.api = new IamportClient(apiKey, apiSecret);
    }

    @PostMapping("/webendpoint")
    @ResponseBody
    public String handleWebhook(@RequestBody MyPayment payload) {
    	
    	System.out.println(payload.getimp_uid());
    	System.out.println(payload.getmerchant_uid());
    	System.out.println(payload.getStatus());
    	
        System.out.println("웹훅 수신이 정상적으로 완료됨");
        return null;
    }
 
    @GetMapping("/getPaymentAmount")
    @ResponseBody
    public ResponseEntity<Map<String, Integer>> getPaymentAmount() {
        Map<String, Integer> response = new HashMap<>();
        response.put("amount", 9900); 
        return ResponseEntity.ok(response);
    }

    @PostMapping("/verifyIamport/{imp_uid}")
    @ResponseBody
    public ResponseEntity<Map<String, String>> paymentByImpUid(
            @PathVariable(value = "imp_uid") String imp_uid,
            @RequestParam("merchant_uid") String merchant_uid,
            @RequestParam("amount") int amount) throws IamportResponseException, IOException {

        IamportResponse<Payment> response = api.paymentByImpUid(imp_uid);
        
        Payment payment = response.getResponse();
        if (payment == null) {
            Map<String, String> errorResult = new HashMap<>();
            errorResult.put("result", "fail");
            errorResult.put("message", "결제 정보를 찾을 수 없습니다.");
            return ResponseEntity.badRequest().body(errorResult);
        }

        Map<String, String> result = new HashMap<>();
        int expectedAmount = 9900; 
        if (payment.getAmount().intValue() == expectedAmount && payment.getMerchantUid().equals(merchant_uid)) {
            result.put("result", "success");
            return ResponseEntity.ok(result);
        } else {  
            CancelData cancelData = new CancelData(imp_uid, true);
            api.cancelPaymentByImpUid(cancelData);

            result.put("result", "fail");
            result.put("message", "결제 금액 불일치 또는 상점 주문번호 불일치. 결제가 취소되었습니다.");
            return ResponseEntity.badRequest().body(result);
        }
    }
}
