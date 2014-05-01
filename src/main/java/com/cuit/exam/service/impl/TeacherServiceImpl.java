package com.cuit.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cuit.exam.dao.TExamDAO;
import com.cuit.exam.dao.TExamHasQtnsDAO;
import com.cuit.exam.dao.TSubjectDAO;
import com.cuit.exam.entity.TExam;
import com.cuit.exam.entity.TExamHasQtns;
import com.cuit.exam.entity.TSubject;
import com.cuit.exam.service.TeacherService;
/**
 * 
* @ClassName: TeacherServiceImpl 
* @Description: teacher业务逻辑层实现
* @author 夏 茂轩  
* @date 2014年2月27日 下午4:32:30 
*
 */
@Component
public class TeacherServiceImpl	implements TeacherService {
	@Autowired
	private TSubjectDAO subjectDAO;

	@Autowired
	private TExamDAO examDAO;
	
	@Autowired
	private TExamHasQtnsDAO examHasQtnsDAO;
	
	@Override
	public List<TSubject>  getAllSubject() {
		List<TSubject> subjects=subjectDAO.findAll();
		return subjects;
	}

	@Override
	public void addOrUpdateTExam(TExam exam) {
		examDAO.merge(exam);
	}

	@Override
	public List<TExam> getAllExam() {
		return examDAO.findAll();
	}

	@Override
	public void delExam(TExam exam) {
		examDAO.delete(exam);
	}

	@Override
	public TExam getExam(Integer id) {
		return examDAO.findById(id);
	}

	@Override
	public void addNewExam(TExam exam, String[] qtnTypeFullScores,
			String[] qtnTypeIds, String[] qtnTypeHards, String[] qtnCounts) {
		
		float fullScores[]=null;
		int qtnTypesIds[]=null;
		int qtnTypesHards[]= null;
		int qtnCountss[]=null;
		examDAO.save(exam);
		
		//总分数转换
		if(qtnTypeFullScores.length>0){
			fullScores=new float[qtnTypeFullScores.length];
			for(int i=0;i<qtnTypeFullScores.length;i++){
				fullScores[i]=Float.parseFloat(qtnTypeFullScores[i]);
			}
		}
		
		//问题类型转换
		if(qtnTypeIds.length>0){
			qtnTypesIds=new int[qtnTypeIds.length];
			for(int i=0;i<qtnTypeIds.length;i++){
				qtnTypesIds[i]=Integer.parseInt(qtnTypeIds[i]);
			}
		}
		//问题难度转换
		if(qtnTypeHards.length>0){
			qtnTypesHards=new int[qtnTypeHards.length];
			for(int i=0;i<qtnTypeHards.length;i++){
				qtnTypesHards[i]=Integer.parseInt(qtnTypeHards[i]);
			}
		}
		//问题数量转换
		if(qtnCounts.length>0){
			qtnCountss=new int[qtnCounts.length];
			for(int i=0;i<qtnCounts.length;i++){
				qtnCountss[i]=Integer.parseInt(qtnCounts[i]);
			}
		}
		for(int i=0;i<qtnCountss.length;i++){
			TExamHasQtns tExamHasQtns=new TExamHasQtns();
			tExamHasQtns.setTExam(exam);
			tExamHasQtns.setFullSocre(fullScores[i]);
			tExamHasQtns.setDifficulty(qtnTypesHards[i]);
			tExamHasQtns.setQtnCount(qtnCountss[i]);
			tExamHasQtns.setQtnType(qtnTypesIds[i]);
			examHasQtnsDAO.save(tExamHasQtns);
		}
	}
	@Override
	public List<TExamHasQtns> getExamHasQtnsByExamId(Integer id) {
		return examHasQtnsDAO.findByProperty("TExam.id", id);
	}

	@Override
	public void delTExamHasQtnsById(TExamHasQtns id) {
			examHasQtnsDAO.delete(id);
	}

	@Override
	public void addTExamHasQtns(TExamHasQtns examHasQtns) {
			examHasQtnsDAO.save(examHasQtns);
	}

}
