package com.reddy.krjs.supportEnd.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	String memberId;
	String password;
	@Transient
	String confirmPassword;
	boolean enable;
	
	String role;
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	String code;

	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	@Override
	public String toString() {
		return "Users [ memberId=" + memberId + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", enable=" + enable + ", role=" + role + "]";
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	
	

}
