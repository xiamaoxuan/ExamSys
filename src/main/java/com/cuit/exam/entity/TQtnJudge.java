package com.cuit.exam.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TQtnJudge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_qtn_judge", catalog = "examsys")
public class TQtnJudge implements java.io.Serializable {

	// Fields

	private Integer id;
	private TExam TExam;
	private Integer difficulty;
	private String questionDescription;
	private Short isArtificial;
	private Short isCorrect;
	private Set<TTestPaperHasTQtnJudge> TTestPaperHasTQtnJudges = new HashSet<TTestPaperHasTQtnJudge>(
			0);

	// Constructors

	/** default constructor */
	public TQtnJudge() {
	}

	/** full constructor */
	public TQtnJudge(TExam TExam, Integer difficulty,
			String questionDescription, Short isArtificial, Short isCorrect,
			Set<TTestPaperHasTQtnJudge> TTestPaperHasTQtnJudges) {
		this.TExam = TExam;
		this.difficulty = difficulty;
		this.questionDescription = questionDescription;
		this.isArtificial = isArtificial;
		this.isCorrect = isCorrect;
		this.TTestPaperHasTQtnJudges = TTestPaperHasTQtnJudges;
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

	@Column(name = "difficulty")
	public Integer getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	@Column(name = "question_description")
	public String getQuestionDescription() {
		return this.questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	@Column(name = "is_artificial")
	public Short getIsArtificial() {
		return this.isArtificial;
	}

	public void setIsArtificial(Short isArtificial) {
		this.isArtificial = isArtificial;
	}

	@Column(name = "is_correct")
	public Short getIsCorrect() {
		return this.isCorrect;
	}

	public void setIsCorrect(Short isCorrect) {
		this.isCorrect = isCorrect;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TQtnJudge")
	public Set<TTestPaperHasTQtnJudge> getTTestPaperHasTQtnJudges() {
		return this.TTestPaperHasTQtnJudges;
	}

	public void setTTestPaperHasTQtnJudges(
			Set<TTestPaperHasTQtnJudge> TTestPaperHasTQtnJudges) {
		this.TTestPaperHasTQtnJudges = TTestPaperHasTQtnJudges;
	}

}