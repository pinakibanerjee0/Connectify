package com.pinaki.connectify.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cId;
	private String forName;
	private String surName;
	private String work;
	private String email;
	private String phone;
	private String image;
	@Column(length = 1000)
	private String description;
	@ManyToOne
	private User user;

	public Contact() {
	}

	
	public Contact(long cId, String forName, String surName, String work, String email, String phone, String image,
			String description, User user) {
		super();
		this.cId = cId;
		this.forName = forName;
		this.surName = surName;
		this.work = work;
		this.email = email;
		this.phone = phone;
		this.image = image;
		this.description = description;
		this.user = user;
	}


	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", forName=" + forName + ", surName=" + surName + ", work=" + work + ", email="
				+ email + ", phone=" + phone + ", image=" + image + ", description=" + description + "]";
	}

	public long getcId() {
		return cId;
	}

	public void setcId(long cId) {
		this.cId = cId;
	}

	public String getForName() {
		return forName;
	}

	public void setForName(String forName) {
		this.forName = forName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
