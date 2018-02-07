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
import com.situ.xuexiao.pojo.AskLeave;
import com.situ.xuexiao.pojo.BanJi;
import com.situ.xuexiao.pojo.Category;
import com.situ.xuexiao.pojo.Course;
import com.situ.xuexiao.pojo.Teacher;
import com.situ.xuexiao.service.IAskLeaveService;
import com.situ.xuexiao.service.ICourseService;
import com.situ.xuexiao.service.ITeacherService;
import com.situ.xuexiao.vo.FindStudentByCondition;
import com.situ.xuexiao.vo.PageBean;

@Controller
@RequestMapping("/teacherIndex")
public class TeacherController {

	@Autowired
	private ITeacherService teacherService;
	@Autowired
	private ICourseService courseService;
	@Autowired
	private IAskLeaveService askLeaveService;

	@RequestMapping("goAddPage")
	public String goAddPage() {
		return "teacher_add";
	}

	@RequestMapping("findClassTeacher")
	@ResponseBody
	public List<Teacher> findAllTeacher() {
		return teacherService.findClassTeacher();
	}

	@RequestMapping("findAllTeacher")
	public String findAllTeacher(Model model, String pageIndexStr, String pageSizeStr) {
		int pageIndex = 1;
		int pageSize = 12;
		if (pageIndexStr != null && pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		if (pageSizeStr != null && pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<Teacher> pageBean = teacherService.findAllTeacer(pageIndex, pageSize);
		model.addAttribute("pageBean", pageBean);
		return "teacher_list";
	}

	@RequestMapping("showTeacher")
	public String showTeacher(Model model, String ID) {
		Teacher teacher = teacherService.showTeacher(ID);
		System.out.println(teacher);
		model.addAttribute("teacher", teacher);
		return "teacher_show";
	}

	@RequestMapping("findNotMajorTeacher")
	@ResponseBody
	public List<Teacher> findNotMajorTeacher() {
		return teacherService.findNotMajorTeacher();
	}

	@RequestMapping("deleteTeacher")
	@ResponseBody
	public SeverResponse<BanJi> deleteBanji(String ID) {
		return teacherService.deleteTeacher(ID);
	}

	@RequestMapping("findAllCourse")
	@ResponseBody
	public List<Course> findAllCourse() {
		return courseService.findAllCourse();
	}

	@RequestMapping("addTeacher")
	@ResponseBody
	public SeverResponse<Teacher> addTeacher(String name, String age, String gender, String address, String birthday,
			String picture, String coursename) throws ParseException {
		String ID = UUID.randomUUID().toString().replaceAll("-", "");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date Birthday = simpleDateFormat.parse(birthday);
		Course course = new Course();
		course.setSequenceNO(Integer.parseInt(coursename));
		Category category = new Category();
		category.setSequenceNO(5);
		Teacher teacher = new Teacher(ID, name, Integer.parseInt(age), Integer.parseInt(gender), address, Birthday,
				picture, category, course);
		return teacherService.addTeacher(teacher);
	}

	@RequestMapping("findUpdateTeacher")
	public String findUpdateTeacher(Model model, String ID) {
		Teacher teacher = teacherService.showTeacher(ID);
		model.addAttribute("teacher", teacher);
		if (teacher.getGender() == 2) {
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

		Course course = courseService.findCourseByID(teacher.getCourse().getID());
		model.addAttribute("course", course);
		System.out.println(teacher.getCourse().getID());
		System.out.println(teacher);
		System.out.println(course);
		List<Course> courses = courseService.findOtherCourse(teacher.getCourse().getID());
		System.out.println(courses);
		model.addAttribute("courses", courses);
		return "teacher_update";
	}

	public List<Course> findOtherCourse(String ID) {
		return courseService.findOtherCourse(ID);
	}

	@RequestMapping("updateTeacher")
	@ResponseBody
	public SeverResponse<Teacher> updateTeacher(String ID,String name, String age, String gender, String address, String birthday,
			String picture, String coursename) throws ParseException {
		String newPicture = picture;
		if (picture.length() > 28) {
			newPicture = picture.substring(0, picture.length() - 1);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date Birthday = simpleDateFormat.parse(birthday);
		Course course = new Course();
		course.setSequenceNO(Integer.parseInt(coursename));
		Category category = new Category();
		category.setSequenceNO(5);
		Teacher teacher = new Teacher(ID,name, Integer.parseInt(age), Integer.parseInt(gender), address, Birthday,
				picture, category, course);
		return teacherService.updateTeacher(teacher);
	}
	
	@RequestMapping("findTeacherByCondition")
	public String findTeacherByCondition(Model model, String name, String gender, String pageIndexStr, String pageSizeStr) {
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
		PageBean<Teacher> pageBean = teacherService.findTeacherByCondition(findStudentByCondition);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("findStudentByCondition", findStudentByCondition);
		return "teacher_list";
	}
	
	@RequestMapping("deleteAll")
	@ResponseBody
	public SeverResponse<Teacher> deleteAll(String[] selectedIds) {
		return teacherService.deleteAll(selectedIds);
	}
	
	@RequestMapping("findAskLeaveByTeacherID")
	@ResponseBody
	public List<AskLeave> findAskLeaveByTeacherID(String ID) {
		return askLeaveService.findAskLeaveByTeacherID(ID);
	}
}
