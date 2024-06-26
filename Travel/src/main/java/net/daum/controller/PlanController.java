package net.daum.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.PlanService;
import net.daum.vo.CityVO;
import net.daum.vo.NationalVO;


@Controller
@RequestMapping("/planning/*")
public class PlanController {

	@Autowired
	private PlanService planservice;
	
	//일정 메인 페이지

	@GetMapping("/main")
	public String getNlist(Model model){
		return "jsp/plan";
	}
	
	//국가 선택시 일정 페이지
	@GetMapping("/{nationalCode}")
	public ModelAndView planning(@PathVariable("nationalCode") String nationalCode) {
		NationalVO nv= this.planservice.findNational(nationalCode);
		List<CityVO> cityList = nv.getCity(); // 해당 국가에 속한 도시 목록 가져오기
		
		List<CityVO> capitalCityList = new ArrayList<>();
		// capitalCity가 'Y'인 도시만 필터링하여 리스트에 추가
	    for (CityVO city : cityList) {
	        if ("Y".equals(city.getCapitalCity())) {
	            capitalCityList.add(city);
	        }
	    }
	    // capitalCity가 'Y'인 도시의 latitude와 longitude를 가져와서 모델에 추가
	    List<Double> latitudes = new ArrayList<>();
	    List<Double> longitudes = new ArrayList<>();
	    for (CityVO capitalCity : capitalCityList) {
	        if ("Y".equals(capitalCity.getCapitalCity())) {
	            latitudes.add(capitalCity.getLatitude());
	            longitudes.add(capitalCity.getLongitude());
	        }
	    }
			ModelAndView mv= new ModelAndView();
			mv.addObject("nationalName", nv.getNationalName());
			mv.addObject("timeDifference", nv.getTimeDifference());
			mv.addObject("flagPath", nv.getFlagPath());
			mv.addObject("cityList", cityList);
		    mv.addObject("capitalCityLatitudes", latitudes);
		    mv.addObject("capitalCityLongitudes", longitudes);
			mv.setViewName("jsp/plan");
			return mv;
	}
	

}
