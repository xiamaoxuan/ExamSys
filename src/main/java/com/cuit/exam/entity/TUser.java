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
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user", catalog = "examsys")
public class TUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private TRole TRole;
	private String userName;
	private String password;
	private String userNo;
	private Set<TUserHasTExam> TUserHasTExams = new HashSet<TUserHasTExam>(0);
	private Set<TTestPaper> TTestPapers = new HashSet<TTestPaper>(0);
	private Set<TUserHasScore> TUserHasScores = new HashSet<TUserHasScore>(0);

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** full constructor */
	public TUser(TRole TRole, String userName, String password, String userNo,
			Set<TUserHasTExam> TUserHasTExams, Set<TTestPaper> TTestPapers,
			Set<TUserHasScore> TUserHasScores) {
		this.TRole = TRole;
		this.userName = userName;
		this.password = password;
		this.userNo = userNo;
		this.TUserHasTExams = TUserHasTExams;
		this.TTestPapers = TTestPapers;
		this.TUserHasScores = TUserHasScores;
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
	@JoinColumn(name = "t_role_id")
	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "user_no")
	public String getUserNo() {
		return this.userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	public Set<TUserHasTExam> getTUserHasTExams() {
		return this.TUserHasTExams;
	}

	public void setTUserHasTExams(Set<TUserHasTExam> TUserHasTExams) {
		this.TUserHasTExams = TUserHasTExams;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	public Set<TTestPaper> getTTestPapers() {
		return this.TTestPapers;
	}

	public void setTTestPapers(Set<TTestPaper> TTestPapers) {
		this.TTestPapers = TTestPapers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	public Set<TUserHasScore> getTUserHasScores() {
		return this.TUserHasScores;
	}

	public void setTUserHasScores(Set<TUserHasScore> TUserHasScores) {
		this.TUserHasScores = TUserHasScores;
	}

}