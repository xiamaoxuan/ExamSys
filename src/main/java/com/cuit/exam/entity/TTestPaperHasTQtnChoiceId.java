package com.cuit.exam.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TTestPaperHasTQtnChoiceId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TTestPaperHasTQtnChoiceId implements java.io.Serializable {

	// Fields

	private Integer TTestPaperId;
	private Integer TQtnChoiceId;

	// Constructors

	/** default constructor */
	public TTestPaperHasTQtnChoiceId() {
	}

	/** full constructor */
	public TTestPaperHasTQtnChoiceId(Integer TTestPaperId, Integer TQtnChoiceId) {
		this.TTestPaperId = TTestPaperId;
		this.TQtnChoiceId = TQtnChoiceId;
	}

	// Property accessors

	@Column(name = "t_test_paper_id", nullable = false)
	public Integer getTTestPaperId() {
		return this.TTestPaperId;
	}

	public void setTTestPaperId(Integer TTestPaperId) {
		this.TTestPaperId = TTestPaperId;
	}

	@Column(name = "t_qtn_choice_id", nullable = false)
	public Integer getTQtnChoiceId() {
		return this.TQtnChoiceId;
	}

	public void setTQtnChoiceId(Integer TQtnChoiceId) {
		this.TQtnChoiceId = TQtnChoiceId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TTestPaperHasTQtnChoiceId))
			return false;
		TTestPaperHasTQtnChoiceId castOther = (TTestPaperHasTQtnChoiceId) other;

		return ((this.getTTestPaperId() == castOther.getTTestPaperId()) || (this
				.getTTestPaperId() != null
				&& castOther.getTTestPaperId() != null && this
				.getTTestPaperId().equals(castOther.getTTestPaperId())))
				&& ((this.getTQtnChoiceId() == castOther.getTQtnChoiceId()) || (this
						.getTQtnChoiceId() != null
						&& castOther.getTQtnChoiceId() != null && this
						.getTQtnChoiceId().equals(castOther.getTQtnChoiceId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTTestPaperId() == null ? 0 : this.getTTestPaperId()
						.hashCode());
		result = 37
				* result
				+ (getTQtnChoiceId() == null ? 0 : this.getTQtnChoiceId()
						.hashCode());
		return result;
	}

}