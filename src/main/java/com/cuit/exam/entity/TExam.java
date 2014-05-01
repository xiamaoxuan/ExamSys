package com.cuit.exam.entity;

import java.sql.Timestamp;
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
 * TExam entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_exam", catalog = "examsys")
public class TExam implements java.io.Serializable {

	// Fields

	private Integer id;
	private TSubject TSubject;
	private String title;
	private Timestamp startTime;
	private Timestamp endTime;
	private Float fullScore;
	private Set<TTestPaper> TTestPapers = new HashSet<TTestPaper>(0);
	private Set<TQtnInterpretation> TQtnInterpretations = new HashSet<TQtnInterpretation>(
			0);
	private Set<TExamHasQtns> TExamHasQtnses = new HashSet<TExamHasQtns>(0);
	private Set<TQtnAnswer> TQtnAnswers = new HashSet<TQtnAnswer>(0);
	private Set<TQtnFillBlank> TQtnFillBlanks = new HashSet<TQtnFillBlank>(0);
	private Set<TUserHasTExam> TUserHasTExams = new HashSet<TUserHasTExam>(0);
	private Set<TQtnChoice> TQtnChoices = new HashSet<TQtnChoice>(0);
	private Set<TUserHasScore> TUserHasScores = new HashSet<TUserHasScore>(0);
	private Set<TQtnJudge> TQtnJudges = new HashSet<TQtnJudge>(0);

	// Constructors

	/** default constructor */
	public TExam() {
	}

	/** full constructor */
	public TExam(TSubject TSubject, String title, Timestamp startTime,
			Timestamp endTime, Float fullScore, Set<TTestPaper> TTestPapers,
			Set<TQtnInterpretation> TQtnInterpretations,
			Set<TExamHasQtns> TExamHasQtnses, Set<TQtnAnswer> TQtnAnswers,
			Set<TQtnFillBlank> TQtnFillBlanks,
			Set<TUserHasTExam> TUserHasTExams, Set<TQtnChoice> TQtnChoices,
			Set<TUserHasScore> TUserHasScores, Set<TQtnJudge> TQtnJudges) {
		this.TSubject = TSubject;
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.fullScore = fullScore;
		this.TTestPapers = TTestPapers;
		this.TQtnInterpretations = TQtnInterpretations;
		this.TExamHasQtnses = TExamHasQtnses;
		this.TQtnAnswers = TQtnAnswers;
		this.TQtnFillBlanks = TQtnFillBlanks;
		this.TUserHasTExams = TUserHasTExams;
		this.TQtnChoices = TQtnChoices;
		this.TUserHasScores = TUserHasScores;
		this.TQtnJudges = TQtnJudges;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "t_subject_id")
	public TSubject getTSubject() {
		return this.TSubject;
	}

	public void setTSubject(TSubject TSubject) {
		this.TSubject = TSubject;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "start_time", length = 19)
	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time", length = 19)
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Column(name = "full_score", precision = 12, scale = 0)
	public Float getFullScore() {
		return this.fullScore;
	}

	public void setFullScore(Float fullScore) {
		this.fullScore = fullScore;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExam")
	public Set<TTestPaper> getTTestPapers() {
		return this.TTestPapers;
	}

	public void setTTestPapers(Set<TTestPaper> TTestPapers) {
		this.TTestPapers = TTestPapers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExam")
	public Set<TQtnInterpretation> getTQtnInterpretations() {
		return this.TQtnInterpretations;
	}

	public void setTQtnInterpretations(
			Set<TQtnInterpretation> TQtnInterpretations) {
		this.TQtnInterpretations = TQtnInterpretations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExam")
	public Set<TExamHasQtns> getTExamHasQtnses() {
		return this.TExamHasQtnses;
	}

	public void setTExamHasQtnses(Set<TExamHasQtns> TExamHasQtnses) {
		this.TExamHasQtnses = TExamHasQtnses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExam")
	public Set<TQtnAnswer> getTQtnAnswers() {
		return this.TQtnAnswers;
	}

	public void setTQtnAnswers(Set<TQtnAnswer> TQtnAnswers) {
		this.TQtnAnswers = TQtnAnswers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExam")
	public Set<TQtnFillBlank> getTQtnFillBlanks() {
		return this.TQtnFillBlanks;
	}

	public void setTQtnFillBlanks(Set<TQtnFillBlank> TQtnFillBlanks) {
		this.TQtnFillBlanks = TQtnFillBlanks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExam")
	public Set<TUserHasTExam> getTUserHasTExams() {
		return this.TUserHasTExams;
	}

	public void setTUserHasTExams(Set<TUserHasTExam> TUserHasTExams) {
		this.TUserHasTExams = TUserHasTExams;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExam")
	public Set<TQtnChoice> getTQtnChoices() {
		return this.TQtnChoices;
	}

	public void setTQtnChoices(Set<TQtnChoice> TQtnChoices) {
		this.TQtnChoices = TQtnChoices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExam")
	public Set<TUserHasScore> getTUserHasScores() {
		return this.TUserHasScores;
	}

	public void setTUserHasScores(Set<TUserHasScore> TUserHasScores) {
		this.TUserHasScores = TUserHasScores;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TExam")
	public Set<TQtnJudge> getTQtnJudges() {
		return this.TQtnJudges;
	}

	public void setTQtnJudges(Set<TQtnJudge> TQtnJudges) {
		this.TQtnJudges = TQtnJudges;
	}

}