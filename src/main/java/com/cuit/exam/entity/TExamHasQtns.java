package com.cuit.exam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TExamHasQtns entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_exam_has_qtns", catalog = "examsys")
public class TExamHasQtns implements java.io.Serializable {

	// Fields

	private Integer id;
	private TExam TExam;
	private Integer qtnType;
	private Float fullSocre;
	private Integer difficulty;
	private Integer qtnCount;

	// Constructors

	/** default constructor */
	public TExamHasQtns() {
	}

	/** full constructor */
	public TExamHasQtns(TExam TExam, Integer qtnType, Float fullSocre,
			Integer difficulty, Integer qtnCount) {
		this.TExam = TExam;
		this.qtnType = qtnType;
		this.fullSocre = fullSocre;
		this.difficulty = difficulty;
		this.qtnCount = qtnCount;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_exam_id")
	public TExam getTExam() {
		return this.TExam;
	}

	public void setTExam(TExam TExam) {
		this.TExam = TExam;
	}

	@Column(name = "qtn_type")
	public Integer getQtnType() {
		return this.qtnType;
	}

	public void setQtnType(Integer qtnType) {
		this.qtnType = qtnType;
	}

	@Column(name = "full_socre", precision = 11, scale = 0)
	public Float getFullSocre() {
		return this.fullSocre;
	}

	public void setFullSocre(Float fullSocre) {
		this.fullSocre = fullSocre;
	}

	@Column(name = "difficulty")
	public Integer getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	@Column(name = "qtn_count")
	public Integer getQtnCount() {
		return this.qtnCount;
	}

	public void setQtnCount(Integer qtnCount) {
		this.qtnCount = qtnCount;
	}

}