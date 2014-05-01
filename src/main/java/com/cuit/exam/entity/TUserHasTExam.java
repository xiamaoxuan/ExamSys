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
 * TUserHasTExam entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user_has_t_exam", catalog = "examsys")
public class TUserHasTExam implements java.io.Serializable {

	// Fields

	private TUserHasTExamId id;
	private TExam TExam;
	private TUser TUser;

	// Constructors

	/** default constructor */
	public TUserHasTExam() {
	}

	/** full constructor */
	public TUserHasTExam(TUserHasTExamId id, TExam TExam, TUser TUser) {
		this.id = id;
		this.TExam = TExam;
		this.TUser = TUser;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "TUserId", column = @Column(name = "t_user_id", nullable = false)),
			@AttributeOverride(name = "TExamId", column = @Column(name = "t_exam_id", nullable = false)) })
	public TUserHasTExamId getId() {
		return this.id;
	}

	public void setId(TUserHasTExamId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_exam_id", nullable = false, insertable = false, updatable = false)
	public TExam getTExam() {
		return this.TExam;
	}

	public void setTExam(TExam TExam) {
		this.TExam = TExam;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_user_id", nullable = false, insertable = false, updatable = false)
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

}