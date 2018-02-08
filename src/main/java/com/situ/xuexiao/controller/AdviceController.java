package com.situ.xuexiao.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.map.module.SimpleAbstractTypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.pojo.Advice;
import com.situ.xuexiao.pojo.Student;
import com.situ.xuexiao.service.IAdviceService;
import com.situ.xuexiao.vo.FindAdviceByCondition;
import com.situ.xuexiao.vo.PageBean;

@Controller
@RequestMapping("/adviceIndex")
public class AdviceController {

	@Autowired
	private IAdviceService adviceService;
	
	@RequestMapping("goAddPage")
	public String goAddPage() {
		return "advice_add";
	}
	
	@RequestMapping("addAdvice")
	@ResponseBody
	public SeverResponse<Advice> addAdvice(Advice advice) {
		return adviceService.addAdvice(advice);
	}
	
	@RequestMapping("findAllAdvice")
	public String findAllAdvice(Model model,String pageIndexStr,String pageSizeStr) {
		int pageIndex = 1;
		int pageSize = 12;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<Advice> pageBean = adviceService.findAllAdvice(pageIndex, pageSize);
		model.addAttribute("pageBean", pageBean);
		return "advice_list";
	}
	
	@RequestMapping("findAdviceByCondition")
	public String findAdviceByCondition(Model model,String pageIndexStr,String pageSizeStr,String title,String startTime,
			String endTime,String category_id) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		if(startTime != null && !startTime.equals("")) {
			startDate = simpleDateFormat.parse(startTime);
		}
		if(endTime != null && !endTime.equals("")) {
			endDate = simpleDateFormat.parse(endTime);
		}
		FindAdviceByCondition findAdviceByCondition = new FindAdviceByCondition(title, startDate, endDate, Integer.parseInt(category_id));
		System.out.println(findAdviceByCondition);
		int pageIndex = 1;
		int pageSize = 12;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<Advice> pageBean = adviceService.findAdviceByCondition(pageIndex,pageSize,findAdviceByCondition);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("findAdviceByCondition", findAdviceByCondition);
		return "advice_list";
	}
}
