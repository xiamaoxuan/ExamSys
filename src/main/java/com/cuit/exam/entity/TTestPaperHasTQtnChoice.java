package com.cuit.exam.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TTestPaperHasTQtnChoice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_test_paper_has_t_qtn_choice", catalog = "examsys")
public class TTestPaperHasTQtnChoice implements java.io.Serializable {

	// Fields

	private TTestPaperHasTQtnChoiceId id;
	private TTestPaper TTestPaper;
	private TQtnChoice TQtnChoice;
	private Double TUserScore;
	private String TUserAnswer;
	private Short isChecked;

	// Constructors

	/** default constructor */
	public TTestPaperHasTQtnChoice() {
	}

	/** minimal constructor */
	public TTestPaperHasTQtnChoice(TTestPaperHasTQtnChoiceId id,
			TTestPaper TTestPaper, TQtnChoice TQtnChoice) {
		this.id = id;
		this.TTestPaper = TTestPaper;
		this.TQtnChoice = TQtnChoice;
	}

	/** full constructor */
	public TTestPaperHasTQtnChoice(TTestPaperHasTQtnChoiceId id,
			TTestPaper TTestPaper, TQtnChoice TQtnChoice, Double TUserScore,
			String TUserAnswer, Short isChecked) {
		this.id = id;
		this.TTestPaper = TTestPaper;
		this.TQtnChoice = TQtnChoice;
		this.TUserScore = TUserScore;
		this.TUserAnswer = TUserAnswer;
		this.isChecked = isChecked;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "TTestPaperId", column = @Column(name = "t_test_paper_id", nullable = false)),
			@AttributeOverride(name = "TQtnChoiceId", column = @Column(name = "t_qtn_choice_id", nullable = false)) })
	public TTestPaperHasTQtnChoiceId getId() {
		return this.id;
	}

	public void setId(TTestPaperHasTQtnChoiceId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_test_paper_id", nullable = false, insertable = false, updatable = false)
	public TTestPaper getTTestPaper() {
		return this.TTestPaper;
	}

	public void setTTestPaper(TTestPaper TTestPaper) {
		this.TTestPaper = TTestPaper;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_qtn_choice_id", nullable = false, insertable = false, updatable = false)
	public TQtnChoice getTQtnChoice() {
		return this.TQtnChoice;
	}

	public void setTQtnChoice(TQtnChoice TQtnChoice) {
		this.TQtnChoice = TQtnChoice;
	}

	@Column(name = "t_user_score", precision = 4, scale = 0)
	public Double getTUserScore() {
		return this.TUserScore;
	}

	public void setTUserScore(Double TUserScore) {
		this.TUserScore = TUserScore;
	}

	@Column(name = "t_user_answer")
	public String getTUserAnswer() {
		return this.TUserAnswer;
	}

	public void setTUserAnswer(String TUserAnswer) {
		this.TUserAnswer = TUserAnswer;
	}

	@Column(name = "is_checked")
	public Short getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(Short isChecked) {
		this.isChecked = isChecked;
	}

}