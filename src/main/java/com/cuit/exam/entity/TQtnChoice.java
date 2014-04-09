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
 * TQtnChoice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_qtn_choice", catalog = "examsys")
public class TQtnChoice implements java.io.Serializable {

	// Fields

	private Integer id;
	private TExam TExam;
	private Integer difficulty;
	private String questionDescription;
	private Short isArtificial;
	private Short isSingleAnswer;
	private Set<TTestPaperHasTQtnChoice> TTestPaperHasTQtnChoices = new HashSet<TTestPaperHasTQtnChoice>(
			0);
	private Set<TQtnChoiceHasOption> TQtnChoiceHasOptions = new HashSet<TQtnChoiceHasOption>(
			0);

	// Constructors

	/** default constructor */
	public TQtnChoice() {
	}

	/** full constructor */
	public TQtnChoice(TExam TExam, Integer difficulty,
			String questionDescription, Short isArtificial,
			Short isSingleAnswer,
			Set<TTestPaperHasTQtnChoice> TTestPaperHasTQtnChoices,
			Set<TQtnChoiceHasOption> TQtnChoiceHasOptions) {
		this.TExam = TExam;
		this.difficulty = difficulty;
		this.questionDescription = questionDescription;
		this.isArtificial = isArtificial;
		this.isSingleAnswer = isSingleAnswer;
		this.TTestPaperHasTQtnChoices = TTestPaperHasTQtnChoices;
		this.TQtnChoiceHasOptions = TQtnChoiceHasOptions;
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

	@Column(name = "is_single_answer")
	public Short getIsSingleAnswer() {
		return this.isSingleAnswer;
	}

	public void setIsSingleAnswer(Short isSingleAnswer) {
		this.isSingleAnswer = isSingleAnswer;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TQtnChoice")
	public Set<TTestPaperHasTQtnChoice> getTTestPaperHasTQtnChoices() {
		return this.TTestPaperHasTQtnChoices;
	}

	public void setTTestPaperHasTQtnChoices(
			Set<TTestPaperHasTQtnChoice> TTestPaperHasTQtnChoices) {
		this.TTestPaperHasTQtnChoices = TTestPaperHasTQtnChoices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TQtnChoice")
	public Set<TQtnChoiceHasOption> getTQtnChoiceHasOptions() {
		return this.TQtnChoiceHasOptions;
	}

	public void setTQtnChoiceHasOptions(
			Set<TQtnChoiceHasOption> TQtnChoiceHasOptions) {
		this.TQtnChoiceHasOptions = TQtnChoiceHasOptions;
	}

}