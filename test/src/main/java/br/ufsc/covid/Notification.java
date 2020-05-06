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
@Table(name = "notification_notification")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "rule_id")
	private Rule rule;
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
	@Column
	private Boolean read;
	@Column
	private Boolean delivered;
	@Column
	private Date created;
	@Column
	private Date modified;

}
