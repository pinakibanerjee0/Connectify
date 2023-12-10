package com.pinaki.connectify.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotBlank(message = "Name is required !")
	@Size(min = 2 , max = 25 , message = "name should be between 2 to 25 length")
	private String name;
	@NotBlank(message = "Phone No is required !")
	@Size(max=10 , message = "Phone no should be length of 10 digit")
	private String phoneNo;
	@Column(unique = true)
	private String email;
	private String password;
	private String role;
	private boolean enabled;
	private String imageUrl;
	@Column(length = 500)
	private String about;
	@OneToMany(cascade = CascadeType.ALL,
			   fetch = FetchType.LAZY,
			   mappedBy= "user")
	private List<Contact> contacts;

	public User() {
	}

	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", phoneNo=");
		builder.append(phoneNo);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", role=");
		builder.append(role);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", about=");
		builder.append(about);
		builder.append(", contacts=");
		builder.append(contacts);
		builder.append("]");
		return builder.toString();
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
