/**
 * 
 */
   // 객체 초기화
var IMP = window.IMP;
IMP.init("imp87501644");

function requestPay() {
  // 결제창 호출      
  var random_uid = Math.random().toString(36).substring(2) + (new Date()).getTime().toString(36);

  IMP.request_pay(
    {
      // 파라미터 값 설정 
      pg: "kakaopay",
      pay_method: "kakaopay",
      merchant_uid: random_uid, // 상점 고유 주문번호. 계속 변경되어야 함.
      name: "travel 구독",
      amount: 9900,
      buyer_email: $("#mail").val(),
      buyer_name: $("#name").val(),
      buyer_tel: $("#phone").val(),
      buyer_addr: $("#addr").val(),
      buyer_postcode: $("#post").val(),
    },
    async requestPayResponse => {
      const { success, error_msg } = requestPayResponse;
      if (!success) {
        alert(`결제 실패. 에러 내용: ${error_msg}`);
        return;
      } else {
        alert(`결제 성공`);
        window.location.href = "/successPay"; // 이동할 페이지의 경로
      }
    }
  );
}