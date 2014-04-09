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
 * TQtnChoiceHasOption entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_qtn_choice_has_option", catalog = "examsys")
public class TQtnChoiceHasOption implements java.io.Serializable {

	// Fields

	private Integer id;
	private TQtnChoice TQtnChoice;
	private String optionDescription;
	private Short isCorrect;

	// Constructors

	/** default constructor */
	public TQtnChoiceHasOption() {
	}

	/** full constructor */
	public TQtnChoiceHasOption(TQtnChoice TQtnChoice, String optionDescription,
			Short isCorrect) {
		this.TQtnChoice = TQtnChoice;
		this.optionDescription = optionDescription;
		this.isCorrect = isCorrect;
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
	@JoinColumn(name = "t_qtn_choice_id")
	public TQtnChoice getTQtnChoice() {
		return this.TQtnChoice;
	}

	public void setTQtnChoice(TQtnChoice TQtnChoice) {
		this.TQtnChoice = TQtnChoice;
	}

	@Column(name = "option_description")
	public String getOptionDescription() {
		return this.optionDescription;
	}

	public void setOptionDescription(String optionDescription) {
		this.optionDescription = optionDescription;
	}

	@Column(name = "is_correct")
	public Short getIsCorrect() {
		return this.isCorrect;
	}

	public void setIsCorrect(Short isCorrect) {
		this.isCorrect = isCorrect;
	}

}