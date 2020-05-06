package br.ufsc.covid;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity()
@Table(name = "rules_logicalcondition")
public class LogicalCondition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "rule_condition_id")
	private Condition condition;
	@Column
	private String attribute;
	@Column
	private String operator;
	@Column
	private String value;
	@Column
	private Date created;
	@Column
	private Date modified;
	public void setCondition(Condition condition) {
		this.condition = condition;
	}

}
