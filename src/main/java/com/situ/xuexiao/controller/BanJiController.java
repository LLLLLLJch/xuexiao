package com.situ.xuexiao.controller;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.pojo.BanJi;
import com.situ.xuexiao.pojo.Student;
import com.situ.xuexiao.pojo.Teacher;
import com.situ.xuexiao.service.IBanJiService;
import com.situ.xuexiao.service.IStudentService;
import com.situ.xuexiao.service.ITeacherService;
import com.situ.xuexiao.vo.PageBean;

@Controller
@RequestMapping("/banjiIndex")
public class BanJiController {

	@Autowired
	private IBanJiService banjiService;
	@Autowired
	private IStudentService studentService;
	@Autowired
	private ITeacherService teacherService;
	
	@RequestMapping("goAddPage")
	public String goAddPage() {
		return "banji_add";
	}
	
	@RequestMapping("findAllBanJi")
	public String findAllBanJi(Model model,String pageIndexStr,String pageSizeStr) {
		int pageIndex = 1;
		int pageSize = 12;
		if(pageIndexStr != null && pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		if(pageSizeStr != null && pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<Student> pageBean = banjiService.findBanJiPageBean(pageIndex,pageSize);
		model.addAttribute("pageBean", pageBean);
		return "banji_list";
	}
	
	@RequestMapping("findUpdateBanji")
	public String findUpdateBanji(Model model,String ID) {
		BanJi banji = banjiService.findUpdateBanji(ID);
		Teacher teacher = teacherService.findMajorTeacher(banji.getID());
		List<Teacher> teachers = teacherService.findNotMajorTeacher();
		model.addAttribute("banji", banji);
		model.addAttribute("teacher", teacher);
		model.addAttribute("teachers", teachers);
		return "banji_update";
	}
	
	@RequestMapping("updateBanji")
	@ResponseBody
	public SeverResponse<BanJi> updateBanji(BanJi banJi,String teachername) {
		return banjiService.updateBanji(banJi,teachername);
	}
	
	@RequestMapping("deleteBanji")
	@ResponseBody
	public SeverResponse<BanJi> deleteBanji(String ID) {
		return banjiService.deleteBanji(ID);
	}
	
	@RequestMapping("deleteAll")
	@ResponseBody
	public SeverResponse<BanJi> deleteAll(String[] selectedIds) {
		return banjiService.deleteAll(selectedIds);
	}
	
	@RequestMapping("addBanji")
	@ResponseBody
	public SeverResponse<BanJi> addBanji(BanJi banJi,String teachername) {
		String ID = UUID.randomUUID().toString().replaceAll("-", "");
		banJi.setID(ID);
		return banjiService.addBanji(banJi,teachername);
	}
	
	@RequestMapping("findBanjiByCondition")
	public String findBanjiByCondition(Model model,String name,String pageIndexStr,String pageSizeStr) {
		int pageIndex = 1;
		int pageSize = 12;
		if(pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		if(pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<BanJi> pageBean = banjiService.findBanJiByCondition(name,pageIndex,pageSize);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("name", name);
		return "banji_list";
	}
	
	@RequestMapping("showBanji")
	public String showBanji(Model model,String ID) {
		BanJi banJi = banjiService.findBanjiByID(ID);
		int StudentNumber = studentService.findStudentBanji(banJi.getSequenceNO());
		Teacher teacher = teacherService.findMajorTeacher(ID);
		model.addAttribute("banJi", banJi);
		model.addAttribute("StudentNumber", StudentNumber);
		model.addAttribute("teacher", teacher);
		return "banji_show";
	}
}
