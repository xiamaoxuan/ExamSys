package com.cuit.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cuit.exam.dao.TQtnAnswerDAO;
import com.cuit.exam.dao.TQtnChoiceDAO;
import com.cuit.exam.dao.TQtnChoiceHasOptionDAO;
import com.cuit.exam.dao.TQtnFillBlankDAO;
import com.cuit.exam.dao.TQtnInterpretationDAO;
import com.cuit.exam.dao.TQtnJudgeDAO;
import com.cuit.exam.entity.TQtnAnswer;
import com.cuit.exam.entity.TQtnChoice;
import com.cuit.exam.entity.TQtnChoiceHasOption;
import com.cuit.exam.entity.TQtnFillBlank;
import com.cuit.exam.entity.TQtnInterpretation;
import com.cuit.exam.entity.TQtnJudge;
import com.cuit.exam.service.ExamService;
/**
 * 
* @ClassName: ExamServiceImpl 
* @Description: Exam业务逻辑层
* @author 夏茂轩 
* @date 2014年3月6日 下午8:37:03 
*
 */
@Component
public class ExamServiceImpl  implements ExamService{
	
	@Autowired
	private TQtnChoiceDAO qtnChoiceDAO;
	
	@Autowired
	private TQtnChoiceHasOptionDAO qtnChoiceHasOptionDAO;
	
	@Autowired
	private TQtnFillBlankDAO qtnFillBlankDAO;
	
	@Autowired
	private TQtnAnswerDAO qtnAnswerDAO;
	
	@Autowired
	private TQtnInterpretationDAO qtnInterpretationDAO;
	
	@Autowired
	private TQtnJudgeDAO qtnJudgeDAO;
	
	@Override
	public void addQtnChoice(TQtnChoice choice, String[] optionDescriptions,
			String[] isCorrect) {
		qtnChoiceDAO.save(choice);
		for(int i=0;i<optionDescriptions.length;i++){
			TQtnChoiceHasOption option=new TQtnChoiceHasOption();
			option.setIsCorrect(Short.parseShort(isCorrect[i]));
			option.setOptionDescription(optionDescriptions[i]);
			option.setTQtnChoice(choice);
			qtnChoiceHasOptionDAO.save(option);
		}
	}

	@Override
	public void addQtnFillBlank(TQtnFillBlank fillBlank) {
		qtnFillBlankDAO.save(fillBlank);
	}

	@Override
	public void addQtnAnswer(TQtnAnswer qtnAnswer) {
		qtnAnswerDAO.save(qtnAnswer);
		
	}

	@Override
	public void addQtnInterpretation(TQtnInterpretation qtnInterpretation) {
		qtnInterpretationDAO.save(qtnInterpretation);
	}

	@Override
	public void addTQtnJudge(TQtnJudge qtnJudge) {
		qtnJudgeDAO.save(qtnJudge);
	}

}
