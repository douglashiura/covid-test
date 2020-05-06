package br.ufsc.covid;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Users_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String email;
	private String password;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "is_active")
	private Boolean isActive;
	@Column(name = "is_staff")
	private Boolean isStaff;
	@Column(name = "is_superuser")
	private Boolean isSuperuser;
	@Column(name = "date_joined")
	private Date dateJoined;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
