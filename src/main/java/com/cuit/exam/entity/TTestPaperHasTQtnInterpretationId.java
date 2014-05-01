package com.cuit.exam.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TTestPaperHasTQtnInterpretationId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TTestPaperHasTQtnInterpretationId implements java.io.Serializable {

	// Fields

	private Integer TTestPaperId;
	private Integer TQtnInterpretationId;

	// Constructors

	/** default constructor */
	public TTestPaperHasTQtnInterpretationId() {
	}

	/** full constructor */
	public TTestPaperHasTQtnInterpretationId(Integer TTestPaperId,
			Integer TQtnInterpretationId) {
		this.TTestPaperId = TTestPaperId;
		this.TQtnInterpretationId = TQtnInterpretationId;
	}

	// Property accessors

	@Column(name = "t_test_paper_id", nullable = false)
	public Integer getTTestPaperId() {
		return this.TTestPaperId;
	}

	public void setTTestPaperId(Integer TTestPaperId) {
		this.TTestPaperId = TTestPaperId;
	}

	@Column(name = "t_qtn_interpretation_id", nullable = false)
	public Integer getTQtnInterpretationId() {
		return this.TQtnInterpretationId;
	}

	public void setTQtnInterpretationId(Integer TQtnInterpretationId) {
		this.TQtnInterpretationId = TQtnInterpretationId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TTestPaperHasTQtnInterpretationId))
			return false;
		TTestPaperHasTQtnInterpretationId castOther = (TTestPaperHasTQtnInterpretationId) other;

		return ((this.getTTestPaperId() == castOther.getTTestPaperId()) || (this
				.getTTestPaperId() != null
				&& castOther.getTTestPaperId() != null && this
				.getTTestPaperId().equals(castOther.getTTestPaperId())))
				&& ((this.getTQtnInterpretationId() == castOther
						.getTQtnInterpretationId()) || (this
						.getTQtnInterpretationId() != null
						&& castOther.getTQtnInterpretationId() != null && this
						.getTQtnInterpretationId().equals(
								castOther.getTQtnInterpretationId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTTestPaperId() == null ? 0 : this.getTTestPaperId()
						.hashCode());
		result = 37
				* result
				+ (getTQtnInterpretationId() == null ? 0 : this
						.getTQtnInterpretationId().hashCode());
		return result;
	}

}