package net.daum.service;



import java.util.List;

import net.daum.vo.CityVO;
import net.daum.vo.DestinationVO;
import net.daum.vo.NationalVO;
import net.daum.vo.PlanVO;


public interface PlanService {

	NationalVO findNational(String nationalCode);

	void insertPlan(PlanVO p);

	void insertDestination(DestinationVO d);

	CityVO getCityCode(String cityCode);

	List<PlanVO> allUserPlan();

}
