package br.ufsc.covid;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(name = "rules_rule")
public class Rule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;

	@Column
	private String message;
	@Column
	private Boolean enabled;
	@OneToMany(mappedBy = "rule", cascade = { CascadeType.PERSIST })
	private Set<Condition> conditions;
	@Column
	private Date created;
	@Column
	private Date modified;
	@Column(name = "\"any\"")
	private Boolean any;
	
	public Set<Condition> getConditions() {
		return conditions;
	}

	

}
