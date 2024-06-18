package net.daum.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.MemberService;
import net.daum.service.PostService;
import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;
import net.daum.vo.MemberVO;


@Controller
public class PostmakeController {

	// 사용자 자료실 글쓰기폼으로 이동
	@Autowired
	private PostService postService;
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/postMake")
	public ModelAndView postmake() {

		ModelAndView wm = new ModelAndView();
		wm.setViewName("jsp/postMake");

		return wm;
	}

	// 게시판에 정보 저장
	@PostMapping("/post_make_Ok")
	public String post_make_ok(@RequestParam("uploadFile2") MultipartFile[] files, Community_boardVO b,
			@AuthenticationPrincipal UserDetails userDetails,
			HttpServletRequest request) {

		String uploadFolder = request.getServletContext().getRealPath("upload");
		
		String username=userDetails.getUsername();
		MemberVO m= this.memberService.idCheck(username);
		b.setMemberVO(m);
		
		this.postService.insertboard(b); // 게시판에 들어갈 제목,내용 등 저장
		

		for (MultipartFile file : files) {
			if (!file.isEmpty()) {// 파일 리스트가 비어있지않다면
				String originalFilename = file.getOriginalFilename(); // file 원래 이름
				String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);// 확장자 추출

				Calendar c = Calendar.getInstance();// 현재의 날짜를 담은 calendar 객체 생성
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH) + 1; // +1해주는 이유는 0~11으로 계산되기 떄문에
				int date = c.get(Calendar.DATE);

				String homedir = uploadFolder + "/" + year + "-" + month + "-" + date;
				File path01 = new File(homedir);

				if (!(path01.exists())) {// 오늘 날짜 폴더 경로가 존재하지 않으면
					path01.mkdir();// 오늘 날짜 폴더 생성
				}
				Random r = new Random();
				int random = r.nextInt(100000000);

				String refileName = "cmimg" + year + month + date + random + "." + fileExtension;// 파일명 랜덤값만
				String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;// 데이터 베이스에 저장하기위한
																								// 파일명(전체경로와 파일명)

				try {
					File saveFile = new File(homedir + "/", refileName);
					file.transferTo(saveFile);

					Cm_ImgVO cm = new Cm_ImgVO();

					cm.setUploadFile(fileDBName);

					this.postService.insertboard(cm); // 업로드 된 이미지 저장
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return "redirect:/community_board";
	}

	
	 // 게시물 목록 조회,페이징 검색 전, 검색 후 
	 
	@RequestMapping(value="/community_board", method=RequestMethod.GET) 
	public ModelAndView community_board(
	    @RequestParam(defaultValue = "1") int page,
	    @RequestParam(required=false) String searchInput,
	    @RequestParam(required=false) String searchType) throws Exception {
		
		System.out.println(searchInput);
	  
	    int limit = 7; // Items per page
	    
	    Page<Community_boardVO> postPage;
	    
	    if (searchInput != null && !searchInput.trim().isEmpty()) {
	        Pageable pageable = PageRequest.of(page - 1, limit);
	        
	        if ("title".equals(searchType)) {
	            // Search by title
	            postPage = postService.searchPostsByTitle(searchInput, pageable);
	        } else if ("content".equals(searchType)) {
	            // Search by content
	            postPage = postService.searchPostsByContent(searchInput, pageable);
	        } else {
	            // Default search
	            postPage = postService.searchPosts(searchInput, pageable);
	        }
	    } else {
	        // No search input
	        Pageable pageable = PageRequest.of(page - 1, limit);
	        postPage = postService.getAllPosts(pageable);
	    } 
	    
	    ModelAndView po = new ModelAndView();
	    po.addObject("posts", postPage.getContent());
	    po.addObject("totalPages", postPage.getTotalPages());
	    po.addObject("currentPage", page);
	    po.addObject("searchInput",searchInput);
	    po.addObject("searchType",searchType);
	    po.setViewName("/jsp/main");
	  
	    return po;
	}

	  
	 //게시물 수정폼으로 이동
	 @PostMapping("/post_edit")
	public ModelAndView postedit(@RequestParam("mateno") Long mateno) {
		 //게시글의 등록된 게시물의 정보를 조회하여 가져오는 로직
		 Community_boardVO post=postService.getPostInfo(mateno);
		 
		 ModelAndView am = new ModelAndView(); 
		 	am.addObject("postId",post.getMateno());
		 	am.addObject("mate_title", post.getMate_title());
		 	am.addObject("mate_cont",post.getMate_cont());
		 	am.addObject("mt_hashtag",post.getMt_hashtag());
		 	am.addObject("images",post.getImages());
		 	
			am.setViewName("/jsp/postEdit");
			
				 return am;
	 }
	 
		
		
		  //수정 완료
	  @PostMapping("post_edit_ok")
	    public ModelAndView post_edit_ok(@RequestParam("mateno") Long mateno,
	                                     Community_boardVO cb, @RequestParam("uploadFile") List<MultipartFile> uploadFile,
	                                     @RequestParam(value = "deleteImages", required = false) List<String> deleteImages,
	                                     HttpServletRequest request, HttpServletResponse response) throws Exception {
	        response.setContentType("text/html;charset=UTF-8");

	        String uploadFolder = request.getServletContext().getRealPath("upload");

	        // 게시물 정보 저장
	        this.postService.editBoard(cb);

	        List<String> fileDBNames = new ArrayList<>();
	        for (MultipartFile file : uploadFile) {
	            if (!file.isEmpty()) {
	                String originalFilename = file.getOriginalFilename();
	                String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

	                Calendar c = Calendar.getInstance();
	                int year = c.get(Calendar.YEAR);
	                int month = c.get(Calendar.MONTH) + 1;
	                int date = c.get(Calendar.DATE);

	                String homedir = uploadFolder + "/" + year + "-" + month + "-" + date;
	                File path01 = new File(homedir);

	                if (!path01.exists()) {
	                    path01.mkdir();
	                }
	                Random r = new Random();
	                int random = r.nextInt(100000000);

	                String refileName = "cmimg" + year + month + date + random + "." + fileExtension;
	                String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
	                File saveFile = new File(homedir, refileName);
	                file.transferTo(saveFile);

	                fileDBNames.add(fileDBName);
	            }
	        }

	        // 이미지 정보 저장 및 업데이트
	        postService.editImages(mateno, fileDBNames,deleteImages);

	        ModelAndView an = new ModelAndView();
	        an.setViewName("redirect:/community_board");
	        return an;
	    }
	  //첨부된 기존 이미지 삭제
	  @PostMapping("/delete_image")
	  public @ResponseBody String deleteImage(@RequestParam("uploadFile")String uploadFile,
			  									@RequestParam("mateno")Long mateno,HttpServletRequest request) {
		  try {
			  String uploadFolder=request.getServletContext().getRealPath("upload");
			  File file = new File(uploadFolder + uploadFile);
			  if(file.exists()) {
				  file.delete();
			  }
			  postService.deleteImages(mateno,List.of(uploadFile));
			  return "success";
			  
		  }catch(Exception e) {
			  e.printStackTrace();
			  return "fail";
		  }
	  }
	  
	
	
		  //게시물 삭제 
		  @PostMapping("post_del_ok")
		  public String post_del_ok(@RequestParam("mateno") Long mateno, HttpServletResponse response, HttpServletRequest request) 
		          throws Exception {
		      response.setContentType("text/html;charset=UTF-8");
		      String uploadFolder = request.getServletContext().getRealPath("upload");

		      // mateno를 사용하여 삭제할 게시물을 조회
		      Community_boardVO cb = this.postService.getPostInfo(mateno);

		      if (cb != null) {
		          System.out.println("게시물 찾음: " + cb.toString());

		          // 첨부 파일이 있는 경우 삭제
		          List<Cm_ImgVO> images = cb.getImages();
		          if (images != null && !images.isEmpty()) {
		              System.out.println("이미지 목록: " + images.toString());
		              for (Cm_ImgVO img : images) {
		                  String imagePath = img.getUploadFile();
		                  File delFile = new File(uploadFolder + imagePath);
		                  if (delFile.exists()) {
		                      delFile.delete();
		                  } else {
		                      System.out.println("파일을 찾을 수 없음: " + imagePath);
		                  }
		              }
		          } else {
		              System.out.println("이미지가 없음");
		          }

		          // 게시물 삭제
		          this.postService.delpost(mateno);

		          return "redirect:/community_board";
		      } else {
		          System.out.println("게시물을 찾을 수 없음: " + mateno);
		      }

		      // 게시물을 찾지 못한 경우 경고 메시지를 표시하고 메인 페이지로 리다이렉트
		      response.getWriter().println("<script>alert('삭제할 게시물을 찾을 수 없습니다.');location.href='/community_board';</script>");
		      return null;
		  }
		  
		 
}

