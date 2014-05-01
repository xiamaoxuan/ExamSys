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
 * TUserHasScore entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user_has_score", catalog = "examsys")
public class TUserHasScore implements java.io.Serializable {

	// Fields

	private TUserHasScoreId id;
	private TExam TExam;
	private TUser TUser;
	private Double score;

	// Constructors

	/** default constructor */
	public TUserHasScore() {
	}

	/** minimal constructor */
	public TUserHasScore(TUserHasScoreId id, TExam TExam, TUser TUser) {
		this.id = id;
		this.TExam = TExam;
		this.TUser = TUser;
	}

	/** full constructor */
	public TUserHasScore(TUserHasScoreId id, TExam TExam, TUser TUser,
			Double score) {
		this.id = id;
		this.TExam = TExam;
		this.TUser = TUser;
		this.score = score;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "TUserId", column = @Column(name = "t_user_id", nullable = false)),
			@AttributeOverride(name = "TExamId", column = @Column(name = "t_exam_id", nullable = false)) })
	public TUserHasScoreId getId() {
		return this.id;
	}

	public void setId(TUserHasScoreId id) {
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

	@Column(name = "score", precision = 22, scale = 0)
	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}