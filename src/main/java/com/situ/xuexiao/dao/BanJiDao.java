package com.situ.xuexiao.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.situ.xuexiao.pojo.BanJi;
import com.situ.xuexiao.pojo.Student;

public interface BanJiDao {

	List<BanJi> findAllBanJi();

	int findBanJiCount();

	List<Student> findAllBanJiPageBean(@Param(value="index")int index, @Param(value="pageSize")int pageSize);

	BanJi findUpdateBanji(String ID);

	int updateBanji(BanJi banJi);

	int deleteBanji(String iD);

	int addBanji(BanJi banJi);

	int findBanJiCountByCondition(String name);

	List<BanJi> findBanJiByCondition(Map<String, Object> map);

	BanJi findBanjiByID(String iD);

	List<BanJi> findOtherBanji(String ID);

}
