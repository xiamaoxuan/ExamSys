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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TSubject entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_subject", catalog = "examsys")
public class TSubject implements java.io.Serializable {

	// Fields

	private Integer id;
	private String subjectName;
	private Set<TExam> TExams = new HashSet<TExam>(0);

	// Constructors

	/** default constructor */
	public TSubject() {
	}

	/** full constructor */
	public TSubject(String subjectName, Set<TExam> TExams) {
		this.subjectName = subjectName;
		this.TExams = TExams;
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

	@Column(name = "subject_name")
	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TSubject")
	public Set<TExam> getTExams() {
		return this.TExams;
	}

	public void setTExams(Set<TExam> TExams) {
		this.TExams = TExams;
	}

}