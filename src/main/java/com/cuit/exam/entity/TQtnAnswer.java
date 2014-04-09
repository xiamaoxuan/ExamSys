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
 * TQtnAnswer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_qtn_answer", catalog = "examsys")
public class TQtnAnswer implements java.io.Serializable {

	// Fields

	private Integer id;
	private TExam TExam;
	private Integer difficulty;
	private String questionDescription;
	private Short isArtificial;
	private String answer;
	private Set<TTestPaperHasTQtnAnswer> TTestPaperHasTQtnAnswers = new HashSet<TTestPaperHasTQtnAnswer>(
			0);

	// Constructors

	/** default constructor */
	public TQtnAnswer() {
	}

	/** full constructor */
	public TQtnAnswer(TExam TExam, Integer difficulty,
			String questionDescription, Short isArtificial, String answer,
			Set<TTestPaperHasTQtnAnswer> TTestPaperHasTQtnAnswers) {
		this.TExam = TExam;
		this.difficulty = difficulty;
		this.questionDescription = questionDescription;
		this.isArtificial = isArtificial;
		this.answer = answer;
		this.TTestPaperHasTQtnAnswers = TTestPaperHasTQtnAnswers;
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

	@Column(name = "answer")
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TQtnAnswer")
	public Set<TTestPaperHasTQtnAnswer> getTTestPaperHasTQtnAnswers() {
		return this.TTestPaperHasTQtnAnswers;
	}

	public void setTTestPaperHasTQtnAnswers(
			Set<TTestPaperHasTQtnAnswer> TTestPaperHasTQtnAnswers) {
		this.TTestPaperHasTQtnAnswers = TTestPaperHasTQtnAnswers;
	}

}