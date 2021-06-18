package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "segment_discount")
public class SegmentDiscount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "segment_id")
	private int segmentId;
	@Column(name = "percentage_discount")
	private int percentageDiscount;

	public SegmentDiscount() {
		super();
	}

	public SegmentDiscount(int segmentId, int percentageDiscount) {
		this.segmentId = segmentId;
		this.percentageDiscount = percentageDiscount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(int segmentId) {
		this.segmentId = segmentId;
	}

	public int getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(int percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}

	@Override
	public String toString() {
		return "SegmentDiscount [id=" + id + ", segmentId=" + segmentId + ", percentageDiscount=" + percentageDiscount
				+ "]";
	}

}
