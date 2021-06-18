package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "segment")
public class Segment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name_en")
	private String nameEn;
	@Column(name = "name_ar")
	private String nameAr;

	public Segment() {
		super();
	}

	public Segment(String nameEn, String nameAr) {
		this.nameEn = nameEn;
		this.nameAr = nameAr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameAr() {
		return nameAr;
	}

	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}

	@Override
	public String toString() {
		return "Segment [id=" + id + ", nameEn=" + nameEn + ", nameAr=" + nameAr + "]";
	}

}
