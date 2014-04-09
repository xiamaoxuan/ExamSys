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
 * TQtnFillBlank entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_qtn_fill_blank", catalog = "examsys")
public class TQtnFillBlank implements java.io.Serializable {

	// Fields

	private Integer id;
	private TExam TExam;
	private Integer difficulty;
	private Short isArtificial;
	private String answer;
	private String questionDescription;
	private Set<TTestPaperHasTQtnFillBlank> TTestPaperHasTQtnFillBlanks = new HashSet<TTestPaperHasTQtnFillBlank>(
			0);

	// Constructors

	/** default constructor */
	public TQtnFillBlank() {
	}

	/** full constructor */
	public TQtnFillBlank(TExam TExam, Integer difficulty, Short isArtificial,
			String answer, String questionDescription,
			Set<TTestPaperHasTQtnFillBlank> TTestPaperHasTQtnFillBlanks) {
		this.TExam = TExam;
		this.difficulty = difficulty;
		this.isArtificial = isArtificial;
		this.answer = answer;
		this.questionDescription = questionDescription;
		this.TTestPaperHasTQtnFillBlanks = TTestPaperHasTQtnFillBlanks;
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

	@Column(name = "question_description")
	public String getQuestionDescription() {
		return this.questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TQtnFillBlank")
	public Set<TTestPaperHasTQtnFillBlank> getTTestPaperHasTQtnFillBlanks() {
		return this.TTestPaperHasTQtnFillBlanks;
	}

	public void setTTestPaperHasTQtnFillBlanks(
			Set<TTestPaperHasTQtnFillBlank> TTestPaperHasTQtnFillBlanks) {
		this.TTestPaperHasTQtnFillBlanks = TTestPaperHasTQtnFillBlanks;
	}

}