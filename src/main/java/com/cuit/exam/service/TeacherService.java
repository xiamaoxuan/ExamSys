package com.cuit.exam.service;

import java.util.List;

import com.cuit.exam.entity.TExam;
import com.cuit.exam.entity.TExamHasQtns;
import com.cuit.exam.entity.TSubject;

/**
 * 
* @ClassName: TeacherService 
* @Description: teacher业务逻辑层
* @author 夏 茂轩  
* @date 2014年2月27日 下午4:33:12 
*
 */
public interface TeacherService {
	/**
	 * 
	* @Title: getAllSubject 
	* @Description: 获取所有的Subject的Map
	* @param @return    设定文件 
	* @return List<TSubject>    返回类型 
	* @throws
	 */
	List<TSubject> getAllSubject();
	
	/**
	 * 
	* @Title: addTExam 
	* @Description: 把获得的exam添加进数据库
	* @param @param exam    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	void addOrUpdateTExam(TExam exam);
	
	/**
	 * 
	* @Title: getAllExam 
	* @Description: 获取所有的考试
	* @param @return    设定文件 
	* @return List<TExam>    返回类型 
	* @throws
	 */
	List<TExam> getAllExam();
	
	/**
	 * 
	* @Title: delExam 
	* @Description:删除Exam
	* @param @param exam    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	void delExam(TExam exam);
	/**
	 * 
	* @Title: getExam 
	* @Description: 根据ID获取Exam
	* @param @param id    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	TExam getExam(Integer id);
	
	/**
	 * 添加考试，包括题型
	 * @param exam
	 * @param qtnTypeFullScores
	 * @param qtnTypeIds
	 * @param qtnTypeHards
	 * @param qtnCounts
	 */
	void addNewExam(TExam exam,String[] qtnTypeFullScores,String[] qtnTypeIds,String[] qtnTypeHards,String[] qtnCounts);
	
	/**
	 * 
	* @Title: getExamHasQtnsByExamId 
	* @Description: 获取试卷的题型 
	* @param @param id
	* @param @return    设定文件 
	* @return List<TExamHasQtns>    返回类型 
	* @throws
	 */
	List<TExamHasQtns> getExamHasQtnsByExamId(Integer id);
	/**
	 * 
	* @Title: delTExamHasQtnsById 
	* @Description: 根据Id来删除考试的题型
	* @param @param id    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	void delTExamHasQtnsById(TExamHasQtns id);
	
	/**
	 * 
	* @Title: addTExamHasQtns 
	* @Description: 为考试添加题型
	* @param @param examHasQtns  设定文件 
	* @return void    返回类型 
	* @throws
	 */
	void addTExamHasQtns(TExamHasQtns examHasQtns);
	
}
