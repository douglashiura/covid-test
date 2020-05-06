package br.ufsc.covid;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(name = "rules_rulecondition")
public class Condition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "rule_id")
	private Rule rule;

	@OneToMany(mappedBy = "condition", cascade = {CascadeType.PERSIST})
	private List<LogicalCondition> logicals;
	@Column
	private Date created;
	@Column
	private Date modified;

	public List<LogicalCondition> getLogicals() {
		return logicals;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

}