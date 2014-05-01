package com.cuit.exam.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TTestPaperHasTQtnFillBlankId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TTestPaperHasTQtnFillBlankId implements java.io.Serializable {

	// Fields

	private Integer TTestPaperId;
	private Integer TQtnFillBlankId;

	// Constructors

	/** default constructor */
	public TTestPaperHasTQtnFillBlankId() {
	}

	/** full constructor */
	public TTestPaperHasTQtnFillBlankId(Integer TTestPaperId,
			Integer TQtnFillBlankId) {
		this.TTestPaperId = TTestPaperId;
		this.TQtnFillBlankId = TQtnFillBlankId;
	}

	// Property accessors

	@Column(name = "t_test_paper_id", nullable = false)
	public Integer getTTestPaperId() {
		return this.TTestPaperId;
	}

	public void setTTestPaperId(Integer TTestPaperId) {
		this.TTestPaperId = TTestPaperId;
	}

	@Column(name = "t_qtn_fill_blank_id", nullable = false)
	public Integer getTQtnFillBlankId() {
		return this.TQtnFillBlankId;
	}

	public void setTQtnFillBlankId(Integer TQtnFillBlankId) {
		this.TQtnFillBlankId = TQtnFillBlankId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TTestPaperHasTQtnFillBlankId))
			return false;
		TTestPaperHasTQtnFillBlankId castOther = (TTestPaperHasTQtnFillBlankId) other;

		return ((this.getTTestPaperId() == castOther.getTTestPaperId()) || (this
				.getTTestPaperId() != null
				&& castOther.getTTestPaperId() != null && this
				.getTTestPaperId().equals(castOther.getTTestPaperId())))
				&& ((this.getTQtnFillBlankId() == castOther
						.getTQtnFillBlankId()) || (this.getTQtnFillBlankId() != null
						&& castOther.getTQtnFillBlankId() != null && this
						.getTQtnFillBlankId().equals(
								castOther.getTQtnFillBlankId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTTestPaperId() == null ? 0 : this.getTTestPaperId()
						.hashCode());
		result = 37
				* result
				+ (getTQtnFillBlankId() == null ? 0 : this.getTQtnFillBlankId()
						.hashCode());
		return result;
	}

}