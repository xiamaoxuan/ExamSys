package com.cuit.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cuit.exam.entity.TQtnAnswer;
import com.cuit.exam.entity.TQtnChoice;
import com.cuit.exam.entity.TQtnFillBlank;
import com.cuit.exam.entity.TQtnInterpretation;
import com.cuit.exam.entity.TQtnJudge;
import com.cuit.exam.service.ExamService;
import com.cuit.exam.utils.CommonUtil;

/**
 * 
 * @ClassName: ExamController
 * @Description: 考试Controller
 * @author 夏茂轩
 * @date 2014年3月6日 下午2:48:39
 * 
 */
@Controller
@RequestMapping("exam")
public class ExamController {
	@Autowired
	private ExamService examService;
	
	private String[] qtnUrls = { "add_qtn_single_choic", "add_qtn_fill_blank",
			"add_qtn_answer", "add_qtn_interpretation", "add_qtn_judge",
			"add_qtn_over_choice" };
	/**
	 * 
	* @Title: addQtn 
	* @Description: 添加题型完成后返回之前的页面 
	* @param @param request
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/addQtn", method = RequestMethod.GET)
	public String addQtn(HttpServletRequest request) throws Exception {
		request.setAttribute("examId", request.getParameter("id"));
		return qtnUrls[Integer.parseInt(request.getParameter("qtnType"))];
	}
	
	/**
	 * 
	* @Title: addQtnSingleChoiceComplete 
	* @Description: 添加单选题
	* @param @param request
	* @param @param qtnChoice
	* @param @param response
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/addQtnSingleChoiceComplete", method = RequestMethod.GET)
	public void addQtnSingleChoiceComplete(HttpServletRequest request,TQtnChoice qtnChoice,HttpServletResponse response ) throws Exception {
		String[] optionDescriptions=request.getParameterValues("optionDescription");
		String[] isCorrect=request.getParameterValues("isCorrect");
		//可以计算机评阅
		qtnChoice.setIsArtificial((short)1);
		//单选题
		qtnChoice.setIsSingleAnswer((short)1);
		examService.addQtnChoice(qtnChoice, optionDescriptions, isCorrect);
		response.sendRedirect(CommonUtil.getBasePath()+"exam/addQtn?id="+qtnChoice.getTExam().getId()+"&qtnType=0");
	}
	
	/**
	 * 
	* @Title: addQtnFillBlankComplete 
	* @Description: 添加填空题
	* @param @param request
	* @param @param response
	* @param @param qtnFillBlank
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/addQtnFillBlankComplete", method = RequestMethod.GET)
	public void addQtnFillBlankComplete(HttpServletRequest request,HttpServletResponse response,TQtnFillBlank qtnFillBlank) throws Exception {
		//不能计算机评阅
		qtnFillBlank.setIsArtificial((short)0);
		examService.addQtnFillBlank(qtnFillBlank);
		response.sendRedirect(CommonUtil.getBasePath()+"exam/addQtn?id="+qtnFillBlank.getTExam().getId()+"&qtnType=1");
	}
	
	/**
	 * 
	* @Title: addQtnAnswerComplete 
	* @Description: 添加一道问答题
	* @param @param request
	* @param @param response
	* @param @param qtnAnswer
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/addQtnAnswerComplete", method = RequestMethod.GET)
	public void addQtnAnswerComplete(HttpServletRequest request,HttpServletResponse response,TQtnAnswer qtnAnswer) throws Exception {
		//不能计算机评阅
		qtnAnswer.setIsArtificial((short)0);
		examService.addQtnAnswer(qtnAnswer);
		response.sendRedirect(CommonUtil.getBasePath()+"exam/addQtn?id="+qtnAnswer.getTExam().getId()+"&qtnType=2");
	}
	
	/**
	 * 
	* @Title: addQtnInterpretation 
	* @Description: 添加一道名词解释题
	* @param @param request
	* @param @param response
	* @param @param qtnInterpretation
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/addQtnInterpretation", method = RequestMethod.GET)
	public void addQtnInterpretation(HttpServletRequest request,HttpServletResponse response,TQtnInterpretation qtnInterpretation) throws Exception {
		//不能计算机评阅
		qtnInterpretation.setIsArtificial((short)0);
		examService.addQtnInterpretation(qtnInterpretation);
		response.sendRedirect(CommonUtil.getBasePath()+"exam/addQtn?id="+qtnInterpretation.getTExam().getId()+"&qtnType=3");
	}
	/**
	 * 
	* @Title: addQtnJudge 
	* @Description: 添加一道判断题
	* @param @param request
	* @param @param response
	* @param @param qtnJudge
	* @param @throws Exception    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@RequestMapping(value = "/addQtnJudge", method = RequestMethod.GET)
	public void addQtnJudge(HttpServletRequest request,HttpServletResponse response,TQtnJudge qtnJudge) throws Exception {
		//可以计算机评阅
		qtnJudge.setIsArtificial((short)1);
		examService.addTQtnJudge(qtnJudge);
		response.sendRedirect(CommonUtil.getBasePath()+"exam/addQtn?id="+qtnJudge.getTExam().getId()+"&qtnType=4");
	}
	
	@RequestMapping(value = "/addQtnOverChoiceComplete", method = RequestMethod.GET)
	public void addQtnOverChoiceComplete(HttpServletRequest request,TQtnChoice qtnChoice,HttpServletResponse response ) throws Exception {
		String[] optionDescriptions=request.getParameterValues("optionDescription");
		String[] isCorrect=request.getParameterValues("isCorrect");
		//可以计算机评阅
		qtnChoice.setIsArtificial((short)1);
		//单选题
		qtnChoice.setIsSingleAnswer((short)0);
		examService.addQtnChoice(qtnChoice, optionDescriptions, isCorrect);
		response.sendRedirect(CommonUtil.getBasePath()+"exam/addQtn?id="+qtnChoice.getTExam().getId()+"&qtnType=0");
	}
}
