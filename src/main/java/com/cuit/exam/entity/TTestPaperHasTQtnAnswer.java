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
 * TTestPaperHasTQtnAnswer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_test_paper_has_t_qtn_answer", catalog = "examsys")
public class TTestPaperHasTQtnAnswer implements java.io.Serializable {

	// Fields

	private TTestPaperHasTQtnAnswerId id;
	private TQtnAnswer TQtnAnswer;
	private TTestPaper TTestPaper;
	private Double TUserScore;
	private String TUserAnswer;
	private Short isChecked;

	// Constructors

	/** default constructor */
	public TTestPaperHasTQtnAnswer() {
	}

	/** minimal constructor */
	public TTestPaperHasTQtnAnswer(TTestPaperHasTQtnAnswerId id,
			TQtnAnswer TQtnAnswer, TTestPaper TTestPaper) {
		this.id = id;
		this.TQtnAnswer = TQtnAnswer;
		this.TTestPaper = TTestPaper;
	}

	/** full constructor */
	public TTestPaperHasTQtnAnswer(TTestPaperHasTQtnAnswerId id,
			TQtnAnswer TQtnAnswer, TTestPaper TTestPaper, Double TUserScore,
			String TUserAnswer, Short isChecked) {
		this.id = id;
		this.TQtnAnswer = TQtnAnswer;
		this.TTestPaper = TTestPaper;
		this.TUserScore = TUserScore;
		this.TUserAnswer = TUserAnswer;
		this.isChecked = isChecked;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "TTestPaperId", column = @Column(name = "t_test_paper_id", nullable = false)),
			@AttributeOverride(name = "TQtnAnswerId", column = @Column(name = "t_qtn_answer_id", nullable = false)) })
	public TTestPaperHasTQtnAnswerId getId() {
		return this.id;
	}

	public void setId(TTestPaperHasTQtnAnswerId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_qtn_answer_id", nullable = false, insertable = false, updatable = false)
	public TQtnAnswer getTQtnAnswer() {
		return this.TQtnAnswer;
	}

	public void setTQtnAnswer(TQtnAnswer TQtnAnswer) {
		this.TQtnAnswer = TQtnAnswer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_test_paper_id", nullable = false, insertable = false, updatable = false)
	public TTestPaper getTTestPaper() {
		return this.TTestPaper;
	}

	public void setTTestPaper(TTestPaper TTestPaper) {
		this.TTestPaper = TTestPaper;
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