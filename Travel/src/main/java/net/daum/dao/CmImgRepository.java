package net.daum.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import net.daum.vo.Cm_ImgVO;

public interface CmImgRepository extends JpaRepository<Cm_ImgVO, Long> {

	void deleteByuploadFileAndMateno2(String fileDBName, Long mateno);

	

	

	

}
