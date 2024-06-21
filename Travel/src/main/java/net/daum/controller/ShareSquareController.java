package net.daum.controller;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.SReplyService;
import net.daum.service.ShareSquareService;
import net.daum.vo.PageVO;
import net.daum.vo.ShareReplyVO;
import net.daum.vo.ShareSquareFileVO;
import net.daum.vo.ShareSquareVO;

@Controller
public class ShareSquareController {
	
	@Autowired
	private ShareSquareService sharesquareService;
	
	@Autowired
	private SReplyService sreplyService;//이거추가
	
	//공유후기 작성 폼 연결
	@GetMapping("/ShareSquare_Write")
	public String ShareSquare_Write(HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		
		return "jsp/ShareSquare_write";
	}//ShareSquare_write()
	
	//공유후기 작성 
	@PostMapping("/ShareSquare_write_ok")
	public String ShareSquare_write_ok(ShareSquareVO s, ShareSquareFileVO sf, 
			HttpServletRequest request) throws Exception{
		
		String uploadFolder = request.getServletContext().getRealPath("upload");
		//첨부파일 업로드 실제 경로
		MultipartFile uploadFile = sf.getUploadFile(); //첨부파일 가져옴
		
		if(!uploadFile.isEmpty()) { //첨부파일이 있는 경우
			
			String fileName= uploadFile.getOriginalFilename(); //첨부원본파일명
			Calendar c = Calendar.getInstance();
			int year=c.get(Calendar.YEAR); //년도
			int month=c.get(Calendar.MONTH)+1; //월값 (1월이 0으로 반환되기 때문에 +1 해야한다.)
			int date=c.get(Calendar.DATE); 
			
			String homedir=uploadFolder+"/"+year+"-"+month+"-"+date;
			//오늘날짜 폴더 경로 저장
			File path01=new File(homedir);
			
			if(!(path01.exists())) { //오늘날짜 폴더경로가 존재하지 않으면
				path01.mkdir(); //오늘날짜 폴더 생성
				}
				Random r = new Random();
				int random = r.nextInt(100000000); //0이상 1억 미만 난수 발생
			
				/*첨부파일 확장자 구하기 */
				int index=fileName.lastIndexOf(".");
			
				String fileExtednsion = fileName.substring(index+1);
				String refileName="s"+year+month+date+random+"."+ fileExtednsion;//새로운 파일명 저장
				String fileDBName = "/"+year+"-"+month+"-"+date+"/"+refileName;
				s.setSboard_file(fileDBName);
			
				File saveFile = new File(homedir + "/", refileName);
			
				try {
					uploadFile.transferTo(saveFile);
				}catch(Exception e) {e.printStackTrace();}
			}else { //파일 미첨부시 실행
				String fileDBName="";
				s.setSboard_file(fileDBName);				
			}

			this.sharesquareService.insertShare(s);//후기 저장
		
			return "redirect:/ShareSquare_plist";			
	}//ShareSquare_write_ok()
	
		
	//공유한 후기 게시판에 띄우기 & 여행 후기 첫 화면
	@GetMapping("/ShareSquare_plist")
	public ModelAndView ShareSquare_plist(ShareSquareVO s,PageVO p, ShareSquareFileVO sf, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		response.setContentType("text/html;charset=UTF-8");

		int page=1;
		int limit=3;
		
		if(request.getParameter("page") != null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		String find_name = request.getParameter("find_name"); //검색어
		String find_field = request.getParameter("find_field"); //검색필드
		p.setFind_field(find_field);
		p.setFind_name("%"+find_name+"%");
		
		int listCount=this.sharesquareService.getListCount(p); //검색전후 게시물수
		
		/* 페이징 */
		p.setStartrow((page-1)*3+1);//시작행 번호
		p.setEndrow(p.getStartrow()+limit-1);//끝행번호
			
		//List<ShareSquareVO> slist = this.sharesquareService.getshareSquareList(p);	
	
		/* 페이징 연산*/		
		int maxpage = (int)((double)listCount/limit+0.95);//총페이지 수
		int startpage = (((int)((double)page/10+0.9))-1)*10+1;//현재 페이지에 보여질 시작 페이지
		int endpage = maxpage;//현재 페이지에 보여질 마지막 페이지
		if(endpage > startpage+10-1) endpage = startpage+10-1;
		
		//리스트 불러오기
		ModelAndView pmav=new ModelAndView();
		//pmav.addObject("share",slist);
		pmav.addObject("listcount", listCount);
		pmav.addObject("page", page);
		pmav.addObject("startpage", startpage);
		pmav.addObject("endpage", endpage);
		pmav.addObject("maxpage", maxpage);
		pmav.addObject("find_field",find_field);
		pmav.addObject("find_name",find_name);
		pmav.setViewName("jsp/ShareSquare_plist");		
		return pmav;
	}//ShareSquare_plist()

	
	//plan_share 내용보기 + 조회수 
	@GetMapping("/plan_share_ccont")
	public ModelAndView plan_share_ccont(int no, String state, HttpServletResponse response, 
			HttpSession session, ShareReplyVO rvo) throws Exception {
		response.setContentType("text/html;charset=UTF-8");

		ShareSquareVO ssc = this.sharesquareService.getshareSquareCont(no);
		String s_content = ssc.getSboard_content().replace("\n", "<br>");
		
		//System.out.println(no);
		
		rvo.setShareSquareVO(ssc); 
		//this.sreplyService.insertaddReply(rvo); //이거추가(댓글) 이거를 sreply컨트롤러로 
		
		
		List<ShareReplyVO> srvo = this.sreplyService.getshareReply(no); //이거추가(댓글)
		
		ModelAndView cm=new ModelAndView();
		cm.addObject("sboard_no",no);
		cm.addObject("ssc", ssc);
		cm.addObject("s_content", s_content);
		cm.addObject("srvo", srvo);//이거추가 (댓글)
		cm.setViewName("jsp/plan_share_cont");	
		return cm;
	}//plan_share_ccont()

}
	

