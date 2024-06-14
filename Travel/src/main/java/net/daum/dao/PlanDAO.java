package net.daum.dao;




import net.daum.vo.CityVO;
import net.daum.vo.DestinationVO;
import net.daum.vo.NationalVO;
import net.daum.vo.PlanVO;


public interface PlanDAO {

	NationalVO findNational(String nationalCode);

	void insertPlan(PlanVO p);

	void insertDestination(DestinationVO d);

	CityVO getCityCode(String cityCode);
}
