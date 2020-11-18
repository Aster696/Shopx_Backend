package com.shopx.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.stereotype.Component;

import com.sun.xml.bind.v2.runtime.Name;

@Entity
@Table(name = "users")
@Component
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Name", unique = true)
	@Size(min = 3,max = 15, message = "Your Name must be min 3 letter and max 15")
	private String username;
	@Column(name = "Email", unique = true)
	@Size(min = 1, max = 225, message = "Enter a proper Email")
	private String email;
	@Column(name = "Contact")
//	@Min(4)
//	@Max(15)
	@Pattern(regexp = "^\\d{10}$", message = "Enter a proper contact number")
	private String contact;
	@Column(name = "Password")
	@NotBlank(message = "Enter a password")
//	@Pattern(regexp = "\\A(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}\\z", message = "password must have "
//			+ "1 number 1 lowercase 1uppercase 1 secial charecter, no spaces and"
//			+ "must be have 8 charecter and less than 20 charecter")
	private String password;
	@Column(name = "Authority")
	private String authority;
	@Column(name = "Status")
	private boolean status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

//	@Override
//	public String toString() {
//		return "UserModel [id="+id+", user_name="+user_name+", email="+email+", contact"+contact+", password="+password+"]";
//	}
	
}
