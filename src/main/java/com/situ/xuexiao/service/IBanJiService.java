package com.situ.xuexiao.service;

import java.util.List;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.pojo.BanJi;
import com.situ.xuexiao.pojo.Student;
import com.situ.xuexiao.vo.PageBean;

public interface IBanJiService {

	List<BanJi> findAllBanJi();

	PageBean<Student> findBanJiPageBean(int pageIndex, int pageSize);

	BanJi findUpdateBanji(String ID);

	SeverResponse<BanJi> updateBanji(BanJi banJi, String teachername);

	SeverResponse<BanJi> deleteBanji(String ID);

	SeverResponse<BanJi> deleteAll(String[] selectedIds);

	SeverResponse<BanJi> addBanji(BanJi banJi, String teachername);

	PageBean<BanJi> findBanJiByCondition(String name, int pageIndex, int pageSize);

	BanJi findBanjiByID(String iD);

	List<BanJi> findOtherBanji(String ID);

}
