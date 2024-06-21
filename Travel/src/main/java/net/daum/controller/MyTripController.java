package net.daum.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.MemberService;
import net.daum.service.PlanService;
import net.daum.vo.CityVO;
import net.daum.vo.MemberVO;
import net.daum.vo.NationalVO;
import net.daum.vo.PlanVO;

@Controller
public class MyTripController {// MyTrip Controller
	@Autowired
	private PlanService planservice;
	
	@Autowired
	private MemberService memberService;
	
	public class planComparator implements Comparator<PlanVO>{
		@Override
		public int compare(PlanVO plan1, PlanVO plan2) {
			return Integer.compare(plan1.getPlanNo(), plan2.getPlanNo());
		}
	}
	@GetMapping("/mytrip")
	public ModelAndView myTrip (@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView mv= new ModelAndView("/jsp/my_trip");
		String memberID = userDetails.getUsername();
		MemberVO member = memberService.idCheck(memberID);
		
		//회원의 일정번호 가져오기
		List<PlanVO> myPlan= member.getPlanVO();
		Collections.sort(myPlan, new planComparator());

		List<List<String>> nationalsByPlan= new ArrayList<>();
		List<String> firstCityImages= new ArrayList<>();
		
		for (PlanVO plan: myPlan) {
			List<String> nationals= new ArrayList<>();
			List<CityVO> cities= plan.getCities();
			
			String firstCityImage= null;
			
			for(CityVO city: cities) {
				NationalVO national= city.getNationalCode();
				String nationalName= national.getNationalName();
				if (!nationals.contains(nationalName)) {
	                nationals.add(nationalName);
	            }
				
				if(firstCityImage == null) {
					firstCityImage= city.getCityImage();
				}
			}
			// 리스트로 가져온 나라이름을 해당 일정의 나라이름리스트에 추가한다.
			nationalsByPlan.add(nationals);
			firstCityImages.add(firstCityImage);
		}
		mv.addObject("firstCityImages", firstCityImages);
		mv.addObject("nationalsByPlan", nationalsByPlan);
		mv.addObject("planList", myPlan);
		return mv;
	}
}
