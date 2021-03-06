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
 * TTestPaperHasTQtnFillBlank entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_test_paper_has_t_qtn_fill_blank", catalog = "examsys")
public class TTestPaperHasTQtnFillBlank implements java.io.Serializable {

	// Fields

	private TTestPaperHasTQtnFillBlankId id;
	private TQtnFillBlank TQtnFillBlank;
	private TTestPaper TTestPaper;
	private Double TUserScore;
	private String TUserAnswer;
	private Short isChecked;

	// Constructors

	/** default constructor */
	public TTestPaperHasTQtnFillBlank() {
	}

	/** minimal constructor */
	public TTestPaperHasTQtnFillBlank(TTestPaperHasTQtnFillBlankId id,
			TQtnFillBlank TQtnFillBlank, TTestPaper TTestPaper) {
		this.id = id;
		this.TQtnFillBlank = TQtnFillBlank;
		this.TTestPaper = TTestPaper;
	}

	/** full constructor */
	public TTestPaperHasTQtnFillBlank(TTestPaperHasTQtnFillBlankId id,
			TQtnFillBlank TQtnFillBlank, TTestPaper TTestPaper,
			Double TUserScore, String TUserAnswer, Short isChecked) {
		this.id = id;
		this.TQtnFillBlank = TQtnFillBlank;
		this.TTestPaper = TTestPaper;
		this.TUserScore = TUserScore;
		this.TUserAnswer = TUserAnswer;
		this.isChecked = isChecked;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "TTestPaperId", column = @Column(name = "t_test_paper_id", nullable = false)),
			@AttributeOverride(name = "TQtnFillBlankId", column = @Column(name = "t_qtn_fill_blank_id", nullable = false)) })
	public TTestPaperHasTQtnFillBlankId getId() {
		return this.id;
	}

	public void setId(TTestPaperHasTQtnFillBlankId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_qtn_fill_blank_id", nullable = false, insertable = false, updatable = false)
	public TQtnFillBlank getTQtnFillBlank() {
		return this.TQtnFillBlank;
	}

	public void setTQtnFillBlank(TQtnFillBlank TQtnFillBlank) {
		this.TQtnFillBlank = TQtnFillBlank;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_test_paper_id", nullable = false, insertable = false, updatable = false)
	public TTestPaper getTTestPaper() {
		return this.TTestPaper;
	}

	public void setTTestPaper(TTestPaper TTestPaper) {
		this.TTestPaper = TTestPaper;
	}

	@Column(name = "t_user_score", precision = 22, scale = 0)
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