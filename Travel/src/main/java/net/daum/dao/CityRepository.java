package net.daum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import net.daum.vo.CityVO;

public interface CityRepository extends JpaRepository<CityVO, String> {

	CityVO findByCityCode(String cityCode);

}
