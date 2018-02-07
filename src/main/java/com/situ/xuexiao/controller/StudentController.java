package com.situ.xuexiao.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.situ.xuexiao.service.IBanJiService;
import com.situ.xuexiao.service.IStudentService;
import com.situ.xuexiao.vo.FindStudentByCondition;
import com.situ.xuexiao.vo.PageBean;

@Controller
@RequestMapping("/studentIndex")
public class StudentController {
	@Autowired
	private IStudentService studentService;
	@Autowired
	private IBanJiService banjiService;

	@RequestMapping("findAllStudents")
	public String StudentList(Model model, String pageIndexStr, String pageSizeStr) {
		int pageIndex = 1;
		int pageSize = 12;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<Student> pageBean = studentService.findAllStudents(pageIndex, pageSize);
		model.addAttribute("pageBean", pageBean);
		return "student_list";
	}

	@RequestMapping("goAddPage")
	public String goAddPage() {
		return "student_add";
	}
	
	@RequestMapping("findAllBanJi")
	@ResponseBody
	public List<BanJi> findAllBanji(Model model) {
		List<BanJi> banJis = banjiService.findAllBanJi();
		return banJis;
	}

	@RequestMapping("findStudent")
	public String findStudent(Model model, String name, String gender, String pageIndexStr, String pageSizeStr) {
		int pageIndex = 1;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		int pageSize = 12;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		FindStudentByCondition findStudentByCondition = new FindStudentByCondition(name, Integer.parseInt(gender),
				pageIndex, pageSize);
		PageBean<Student> pageBean = studentService.findStudentByCondition(findStudentByCondition);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("findStudentByCondition", findStudentByCondition);
		return "student_list";
	}
	
	@RequestMapping("findOtherBanji")
	public void findOtherBanji(String ID) {
		List<BanJi> banJis = banjiService.findOtherBanji(ID);
	}

	@RequestMapping("findUpdateStudent")
	public String findUpdateStudent(Model model, String ID) {
		Student student = studentService.findUpdateStudent(ID);
		model.addAttribute("student", student);
		if (student.getGender() == 2) {
			model.addAttribute("gender", "男");
			model.addAttribute("oldID", "2");
			model.addAttribute("newgender", "女");
			model.addAttribute("newID", "3");
		} else {
			model.addAttribute("gender", "女");
			model.addAttribute("oldID", "3");
			model.addAttribute("newgender", "男");
			model.addAttribute("newID", "2");
		}
		List<BanJi> banJis = banjiService.findOtherBanji(student.getBanji().getID());
		model.addAttribute("banJis", banJis);
		return "student_update";
	}

	@RequestMapping("updateStudent")
	@ResponseBody
	public SeverResponse<Student> updateStudent(String ID,String name, String age, String gender, String address, String birthday,
			String picture, String banjiID) throws ParseException {
		String newPicture = picture;
		if (picture.length()>28) {
			newPicture = picture.substring(0,picture.length()-1);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date Birthday = simpleDateFormat.parse(birthday);
		BanJi banJi = new BanJi();
		banJi.setSequenceNO(Integer.parseInt(banjiID));
		Student student = new Student(ID,name, Integer.parseInt(age), Integer.parseInt(gender), address, Birthday, newPicture,
				banJi);
		return studentService.updateStudent(student);
	}

	@RequestMapping("deleteStudent")
	@ResponseBody
	public SeverResponse<Student> deleteStudent(String ID) {
		return studentService.deleteStudent(ID);
	}

	@RequestMapping("deleteAll")
	@ResponseBody
	public SeverResponse<Student> deleteAll(String[] selectedIds) {
		return studentService.deleteAll(selectedIds);
	}

	@RequestMapping("addStudent")
	@ResponseBody
	public SeverResponse<Student> addStudent(String name, String age, String gender, String address, String birthday,
			String picture, String banjiID) throws ParseException {
		String ID = UUID.randomUUID().toString().replaceAll("-", "");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date Birthday = simpleDateFormat.parse(birthday);
		BanJi banJi = new BanJi();
		banJi.setSequenceNO(Integer.parseInt(banjiID));
		Student student = new Student(ID, name, Integer.parseInt(age), Integer.parseInt(gender), address, Birthday,
				picture, banJi);
		return studentService.addStudent(student);
	}
	
	@RequestMapping("showStudent")
	public String showStudent(Model model, String ID) {
		Student student = studentService.findUpdateStudent(ID);
		model.addAttribute("student", student);
		if (student.getGender() == 2) {
			model.addAttribute("gender", "男");
		} else {
			model.addAttribute("gender", "女");
		}
		return "student_show";
	}
	
}
