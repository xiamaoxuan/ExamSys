package com.cuit.exam.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TUserHasScoreId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TUserHasScoreId implements java.io.Serializable {

	// Fields

	private Integer TUserId;
	private Integer TExamId;

	// Constructors

	/** default constructor */
	public TUserHasScoreId() {
	}

	/** full constructor */
	public TUserHasScoreId(Integer TUserId, Integer TExamId) {
		this.TUserId = TUserId;
		this.TExamId = TExamId;
	}

	// Property accessors

	@Column(name = "t_user_id", nullable = false)
	public Integer getTUserId() {
		return this.TUserId;
	}

	public void setTUserId(Integer TUserId) {
		this.TUserId = TUserId;
	}

	@Column(name = "t_exam_id", nullable = false)
	public Integer getTExamId() {
		return this.TExamId;
	}

	public void setTExamId(Integer TExamId) {
		this.TExamId = TExamId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TUserHasScoreId))
			return false;
		TUserHasScoreId castOther = (TUserHasScoreId) other;

		return ((this.getTUserId() == castOther.getTUserId()) || (this
				.getTUserId() != null && castOther.getTUserId() != null && this
				.getTUserId().equals(castOther.getTUserId())))
				&& ((this.getTExamId() == castOther.getTExamId()) || (this
						.getTExamId() != null && castOther.getTExamId() != null && this
						.getTExamId().equals(castOther.getTExamId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTUserId() == null ? 0 : this.getTUserId().hashCode());
		result = 37 * result
				+ (getTExamId() == null ? 0 : this.getTExamId().hashCode());
		return result;
	}

}