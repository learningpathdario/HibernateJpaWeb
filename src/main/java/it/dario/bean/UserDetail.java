package it.dario.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "USER_DETAILS")
@SequenceGenerator(sequenceName = "USER_DET_SEQ",initialValue=1, allocationSize=1, name = "USER_DET_SEQ")
public class UserDetail {
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_DET_SEQ")
   @Column(name = "USR_DET_ID")
   private long id;

   @Column(name = "FIRST_NAME")
   private String firstName;

   @Column(name = "LAST_NAME")
   private String lastName;

   @Column(name = "EMAIL")
   private String email;

   @Column(name = "DBO")
   private LocalDate dob;
   
   @OneToOne(fetch=FetchType.LAZY)
   @JoinColumn(name = "USR_ID")
   private User user;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public LocalDate getDob() {
	return dob;
}

public void setDob(LocalDate dob) {
	this.dob = dob;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@Override
public String toString() {
	return "UserDetail [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", dob=" + dob + "]";
}
   
   
}