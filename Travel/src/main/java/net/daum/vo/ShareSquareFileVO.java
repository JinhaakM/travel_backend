package net.daum.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShareSquareFileVO {

	private MultipartFile uploadFile; //실제 업로드 할 파일정보 저장, 


}
