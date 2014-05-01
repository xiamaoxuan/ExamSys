package com.cuit.exam.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TTestPaperHasTQtnAnswerId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TTestPaperHasTQtnAnswerId implements java.io.Serializable {

	// Fields

	private Integer TTestPaperId;
	private Integer TQtnAnswerId;

	// Constructors

	/** default constructor */
	public TTestPaperHasTQtnAnswerId() {
	}

	/** full constructor */
	public TTestPaperHasTQtnAnswerId(Integer TTestPaperId, Integer TQtnAnswerId) {
		this.TTestPaperId = TTestPaperId;
		this.TQtnAnswerId = TQtnAnswerId;
	}

	// Property accessors

	@Column(name = "t_test_paper_id", nullable = false)
	public Integer getTTestPaperId() {
		return this.TTestPaperId;
	}

	public void setTTestPaperId(Integer TTestPaperId) {
		this.TTestPaperId = TTestPaperId;
	}

	@Column(name = "t_qtn_answer_id", nullable = false)
	public Integer getTQtnAnswerId() {
		return this.TQtnAnswerId;
	}

	public void setTQtnAnswerId(Integer TQtnAnswerId) {
		this.TQtnAnswerId = TQtnAnswerId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TTestPaperHasTQtnAnswerId))
			return false;
		TTestPaperHasTQtnAnswerId castOther = (TTestPaperHasTQtnAnswerId) other;

		return ((this.getTTestPaperId() == castOther.getTTestPaperId()) || (this
				.getTTestPaperId() != null
				&& castOther.getTTestPaperId() != null && this
				.getTTestPaperId().equals(castOther.getTTestPaperId())))
				&& ((this.getTQtnAnswerId() == castOther.getTQtnAnswerId()) || (this
						.getTQtnAnswerId() != null
						&& castOther.getTQtnAnswerId() != null && this
						.getTQtnAnswerId().equals(castOther.getTQtnAnswerId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTTestPaperId() == null ? 0 : this.getTTestPaperId()
						.hashCode());
		result = 37
				* result
				+ (getTQtnAnswerId() == null ? 0 : this.getTQtnAnswerId()
						.hashCode());
		return result;
	}

}