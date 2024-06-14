package net.daum.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.CityVO;
import net.daum.vo.NationalVO;

@Repository
public class AddScheduleDAOImpl implements AddScheduleDAO {

	
	@Autowired
	private NationalRepository nationalRepo;
	
	@Autowired
	private CityRepository cityRepo;

	@Override
	public List<NationalVO> findNname() {
		return this.nationalRepo.findAll();
	}

}
