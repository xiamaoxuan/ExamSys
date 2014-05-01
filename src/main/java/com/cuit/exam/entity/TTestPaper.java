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
 * TTestPaper entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_test_paper", catalog = "examsys")
public class TTestPaper implements java.io.Serializable {

	// Fields

	private Integer id;
	private TExam TExam;
	private TUser TUser;
	private Integer score;
	private Integer testState;
	private Integer modifyState;
	private Set<TTestPaperHasTQtnAnswer> TTestPaperHasTQtnAnswers = new HashSet<TTestPaperHasTQtnAnswer>(
			0);
	private Set<TTestPaperHasTQtnChoice> TTestPaperHasTQtnChoices = new HashSet<TTestPaperHasTQtnChoice>(
			0);
	private Set<TTestPaperHasTQtnJudge> TTestPaperHasTQtnJudges = new HashSet<TTestPaperHasTQtnJudge>(
			0);
	private Set<TTestPaperHasTQtnFillBlank> TTestPaperHasTQtnFillBlanks = new HashSet<TTestPaperHasTQtnFillBlank>(
			0);
	private Set<TTestPaperHasTQtnInterpretation> TTestPaperHasTQtnInterpretations = new HashSet<TTestPaperHasTQtnInterpretation>(
			0);

	// Constructors

	/** default constructor */
	public TTestPaper() {
	}

	/** full constructor */
	public TTestPaper(
			TExam TExam,
			TUser TUser,
			Integer score,
			Integer testState,
			Integer modifyState,
			Set<TTestPaperHasTQtnAnswer> TTestPaperHasTQtnAnswers,
			Set<TTestPaperHasTQtnChoice> TTestPaperHasTQtnChoices,
			Set<TTestPaperHasTQtnJudge> TTestPaperHasTQtnJudges,
			Set<TTestPaperHasTQtnFillBlank> TTestPaperHasTQtnFillBlanks,
			Set<TTestPaperHasTQtnInterpretation> TTestPaperHasTQtnInterpretations) {
		this.TExam = TExam;
		this.TUser = TUser;
		this.score = score;
		this.testState = testState;
		this.modifyState = modifyState;
		this.TTestPaperHasTQtnAnswers = TTestPaperHasTQtnAnswers;
		this.TTestPaperHasTQtnChoices = TTestPaperHasTQtnChoices;
		this.TTestPaperHasTQtnJudges = TTestPaperHasTQtnJudges;
		this.TTestPaperHasTQtnFillBlanks = TTestPaperHasTQtnFillBlanks;
		this.TTestPaperHasTQtnInterpretations = TTestPaperHasTQtnInterpretations;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_user_id")
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	@Column(name = "score")
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "test_state")
	public Integer getTestState() {
		return this.testState;
	}

	public void setTestState(Integer testState) {
		this.testState = testState;
	}

	@Column(name = "modify_state")
	public Integer getModifyState() {
		return this.modifyState;
	}

	public void setModifyState(Integer modifyState) {
		this.modifyState = modifyState;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTestPaper")
	public Set<TTestPaperHasTQtnAnswer> getTTestPaperHasTQtnAnswers() {
		return this.TTestPaperHasTQtnAnswers;
	}

	public void setTTestPaperHasTQtnAnswers(
			Set<TTestPaperHasTQtnAnswer> TTestPaperHasTQtnAnswers) {
		this.TTestPaperHasTQtnAnswers = TTestPaperHasTQtnAnswers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTestPaper")
	public Set<TTestPaperHasTQtnChoice> getTTestPaperHasTQtnChoices() {
		return this.TTestPaperHasTQtnChoices;
	}

	public void setTTestPaperHasTQtnChoices(
			Set<TTestPaperHasTQtnChoice> TTestPaperHasTQtnChoices) {
		this.TTestPaperHasTQtnChoices = TTestPaperHasTQtnChoices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTestPaper")
	public Set<TTestPaperHasTQtnJudge> getTTestPaperHasTQtnJudges() {
		return this.TTestPaperHasTQtnJudges;
	}

	public void setTTestPaperHasTQtnJudges(
			Set<TTestPaperHasTQtnJudge> TTestPaperHasTQtnJudges) {
		this.TTestPaperHasTQtnJudges = TTestPaperHasTQtnJudges;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTestPaper")
	public Set<TTestPaperHasTQtnFillBlank> getTTestPaperHasTQtnFillBlanks() {
		return this.TTestPaperHasTQtnFillBlanks;
	}

	public void setTTestPaperHasTQtnFillBlanks(
			Set<TTestPaperHasTQtnFillBlank> TTestPaperHasTQtnFillBlanks) {
		this.TTestPaperHasTQtnFillBlanks = TTestPaperHasTQtnFillBlanks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TTestPaper")
	public Set<TTestPaperHasTQtnInterpretation> getTTestPaperHasTQtnInterpretations() {
		return this.TTestPaperHasTQtnInterpretations;
	}

	public void setTTestPaperHasTQtnInterpretations(
			Set<TTestPaperHasTQtnInterpretation> TTestPaperHasTQtnInterpretations) {
		this.TTestPaperHasTQtnInterpretations = TTestPaperHasTQtnInterpretations;
	}

}