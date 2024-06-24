package net.daum.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.daum.service.AddScheduleService;
import net.daum.service.MemberService;
import net.daum.vo.MemberVO;
import net.daum.vo.NationalVO;

@Controller
public class AddScheduleController {

	@Autowired
	private AddScheduleService addscheduleservice;
	@Autowired 
	private MemberService memberService;
	
	@GetMapping("/addschedule")
	public String getNlist(Model model,@AuthenticationPrincipal UserDetails userDetails,HttpServletResponse response)
	throws Exception{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String username=userDetails.getUsername();
		MemberVO m= this.memberService.idCheck(username);

		if(m.getRole().equals("NOPAIDUSER")) {
			out.println("<script>");
			out.println("alert('결제하셔야 이용 가능합니다');");	
			out.println("window.location.href = '/homepage';");
			out.println("</script>");
			
			return null;
		}else {
			List<NationalVO> nList= this.addscheduleservice.findNname();

			model.addAttribute("Nlist", nList);
			return "jsp/add_schedule";
		}
		
	}
}



