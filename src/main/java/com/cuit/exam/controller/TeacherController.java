package com.cuit.exam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cuit.exam.entity.TExam;
import com.cuit.exam.entity.TExamHasQtns;
import com.cuit.exam.entity.TSubject;
import com.cuit.exam.service.TeacherService;
import com.cuit.exam.utils.CommonUtil;

/**
 * 
 * @ClassName: TeacherController
 * @Description: 老师Controller
 * @author 夏 茂轩
 * @date 2014年2月26日 下午3:32:25
 * 
 */
@Component
@RequestMapping("teacher")
public class TeacherController {

	protected static Logger logger = Logger.getLogger("TeacherController");
	@Autowired
	private TeacherService teacherService;

	/**
	 * 
	 * @Title: teacherHome
	 * @Description: 主页面跳转
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String teacherHome() {
		logger.debug("Received request to show common page");
		return "teacher_home";
	}

	/**
	 * 
	 * @Title: addExam
	 * @Description: 添加exam页面
	 * @param @param request
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/addExam", method = RequestMethod.GET)
	public String addExam(HttpServletRequest request) {
		List<TSubject> subjects = teacherService.getAllSubject();
		request.setAttribute("subjects", subjects);
		return "add_exam";
	}

	/**
	 * 
	 * @Title: addExamComplete
	 * @Description: 添加Exam完成
	 * @param @param request
	 * @param @param model
	 * @param @param exam
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/addExamComplete", method = RequestMethod.GET)
	@ResponseBody
	public String addOrUpdateExamComplete(HttpServletRequest request, TExam exam) {
		String[] qtnTypeFullScores = request
				.getParameterValues("qtnTypeFullScores");
		String[] qtnTypeIds = request.getParameterValues("qtnTypeIds");
		String[] qtnTypeHards = request.getParameterValues("qtnTypeHards");
		String[] qtnCounts = request.getParameterValues("qtnCounts");
		teacherService.addNewExam(exam, qtnTypeFullScores, qtnTypeIds,
				qtnTypeHards, qtnCounts);
		return "添加或编辑考试" + exam.getTitle()
				+ exam.getTSubject().getSubjectName() + "成功！";
	}

	/**
	 * 
	 * @Title: editQtnHome
	 * @Description: 获取所有的exams
	 * @param @param request
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editQtnHome", method = RequestMethod.GET)
	public String editQtnHome(HttpServletRequest request) {
		request.setAttribute("exams", teacherService.getAllExam());
		return "edit_qtn_home";
	}

	/**
	 * 
	 * @Title: removeExam
	 * @Description: 删除Exam
	 * @param @param request
	 * @param @param exam
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/removeExam", method = RequestMethod.GET)
	public void removeExam(HttpServletRequest request, TExam exam,
			HttpServletResponse response) {
		teacherService.delExam(exam);
		try {
			response.sendRedirect(CommonUtil.getBasePath()
					+ "teacher/editQtnHome");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: editExam
	 * @Description: 编辑考试
	 * @param @param request
	 * @param @param exam
	 * @param @param response
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/editExam", method = RequestMethod.GET)
	public String editExam(HttpServletRequest request, TExam exam,
			HttpServletResponse response) {
		List<TSubject> subjects = teacherService.getAllSubject();
		request.setAttribute("subjects", subjects);
		request.setAttribute("exam", teacherService.getExam(exam.getId()));
		return "edit_exam";
	}

	/**
	 * 
	 * @Title: getExamQtnType
	 * @Description: 获取Exam的QtnType
	 * @param @param request
	 * @param @param exam
	 * @param @param response
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/getExamQtnType", method = RequestMethod.GET)
	public String getExamQtnType(HttpServletRequest request, TExam exam,
			HttpServletResponse response) {
		List<TExamHasQtns> examHasQtns = teacherService
				.getExamHasQtnsByExamId(exam.getId());
		request.setAttribute("examHasQtns", examHasQtns);
		request.setAttribute("examId", exam.getId());
		return "edit_exam_qtn_type";
	}

	/**
	 * 
	 * @Title: delExamHasQtns
	 * @Description: 删除考试所包含的题型
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/delExamHasQtns", method = RequestMethod.GET)
	public void delExamHasQtns(HttpServletResponse response,HttpServletRequest request,TExamHasQtns examHasQtns){
		Integer examId=Integer.parseInt(request.getParameter("examId"));
		teacherService.delTExamHasQtnsById(examHasQtns);
		try {
			response.sendRedirect(CommonUtil.getBasePath()+"teacher/getExamQtnType?id="+examId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	* @Title: addExamHasQtnsToExam 
	* @Description: 编辑考试时为考试添加题型 
	* @param @param response
	* @param @param request
	* @param @param examHasQtns    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/addExamHasQtnsToExam", method = RequestMethod.GET)
	public  void addExamHasQtnsToExam(HttpServletResponse response,HttpServletRequest request,TExamHasQtns examHasQtns){
		teacherService.addTExamHasQtns(examHasQtns);
		try {
			response.sendRedirect(CommonUtil.getBasePath()+"teacher/getExamQtnType?id="+examHasQtns.getTExam().getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	* @Title: addQtnPage 
	* @Description: 获取所有的Exam用来添加试题
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/addQtnPage", method = RequestMethod.GET)
	public String addQtnPage(HttpServletRequest request){
		request.setAttribute("exams", teacherService.getAllExam());
		return "add_qtn_page";
	}
}
