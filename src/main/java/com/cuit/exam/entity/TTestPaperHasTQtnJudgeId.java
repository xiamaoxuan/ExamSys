package com.cuit.exam.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TTestPaperHasTQtnJudgeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TTestPaperHasTQtnJudgeId implements java.io.Serializable {

	// Fields

	private Integer TTestPaperId;
	private Integer TQtnJudgeId;

	// Constructors

	/** default constructor */
	public TTestPaperHasTQtnJudgeId() {
	}

	/** full constructor */
	public TTestPaperHasTQtnJudgeId(Integer TTestPaperId, Integer TQtnJudgeId) {
		this.TTestPaperId = TTestPaperId;
		this.TQtnJudgeId = TQtnJudgeId;
	}

	// Property accessors

	@Column(name = "t_test_paper_id", nullable = false)
	public Integer getTTestPaperId() {
		return this.TTestPaperId;
	}

	public void setTTestPaperId(Integer TTestPaperId) {
		this.TTestPaperId = TTestPaperId;
	}

	@Column(name = "t_qtn_judge_id", nullable = false)
	public Integer getTQtnJudgeId() {
		return this.TQtnJudgeId;
	}

	public void setTQtnJudgeId(Integer TQtnJudgeId) {
		this.TQtnJudgeId = TQtnJudgeId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TTestPaperHasTQtnJudgeId))
			return false;
		TTestPaperHasTQtnJudgeId castOther = (TTestPaperHasTQtnJudgeId) other;

		return ((this.getTTestPaperId() == castOther.getTTestPaperId()) || (this
				.getTTestPaperId() != null
				&& castOther.getTTestPaperId() != null && this
				.getTTestPaperId().equals(castOther.getTTestPaperId())))
				&& ((this.getTQtnJudgeId() == castOther.getTQtnJudgeId()) || (this
						.getTQtnJudgeId() != null
						&& castOther.getTQtnJudgeId() != null && this
						.getTQtnJudgeId().equals(castOther.getTQtnJudgeId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTTestPaperId() == null ? 0 : this.getTTestPaperId()
						.hashCode());
		result = 37
				* result
				+ (getTQtnJudgeId() == null ? 0 : this.getTQtnJudgeId()
						.hashCode());
		return result;
	}

}