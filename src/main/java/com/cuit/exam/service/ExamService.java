package com.cuit.exam.service;

import com.cuit.exam.entity.TQtnAnswer;
import com.cuit.exam.entity.TQtnChoice;
import com.cuit.exam.entity.TQtnFillBlank;
import com.cuit.exam.entity.TQtnInterpretation;
import com.cuit.exam.entity.TQtnJudge;
/**
 * 
* @ClassName: ExamService 
* @Description: ExamService
* @author 夏茂轩 
* @date 2014年3月6日 下午8:33:11 
*
 */
public interface ExamService {
	/**
	 * 
	* @Title: addQtnChoice 
	* @Description:为指定的考试添加一道选择题
	* @param @param choice
	* @param @param optionDescriptions
	* @param @param isCorrect    设定文件 
	* @return void    返回类型 
 	* @throws
	 */
	void addQtnChoice(TQtnChoice choice,String[] optionDescriptions,String[] isCorrect);
	/**
	 * 
	* @Title: addQtnFillBlank 
	* @Description:为指定的考试 添加一道填空题
	* @param @param fillBlank    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	void addQtnFillBlank(TQtnFillBlank qtnFillBlank);
	
	/**
	 * 
	* @Title: addQtnAnswer 
	* @Description: 添加一道问答题
	* @param @param qtnAnswer    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	void addQtnAnswer(TQtnAnswer qtnAnswer);
	/**
	 * 
	* @Title: addQtnInterpretation 
	* @Description: 添加一道名词解释题
	* @param @param qtnInterpretation    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	void addQtnInterpretation(TQtnInterpretation qtnInterpretation);
	
	/**
	 * 
	* @Title: addTQtnJudge 
	* @Description: 添加一道判断题
	* @param @param qtnJudge    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	void addTQtnJudge(TQtnJudge qtnJudge);
}
