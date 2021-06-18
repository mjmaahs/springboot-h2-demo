package com.example.demo.dto;

public class BillDTO {

	private double totalBeforeDiscount;
	private double percentageDiscount;
	private double purchaseDiscount;
	private double totalAfterDiscount;

	public BillDTO() {
		super();
	}

	public BillDTO(double totalBeforeDiscount, double percentageDiscount, double purchaseDiscount,
			double totalAfterDiscount) {
		this.totalBeforeDiscount = totalBeforeDiscount;
		this.percentageDiscount = percentageDiscount;
		this.purchaseDiscount = purchaseDiscount;
		this.totalAfterDiscount = totalAfterDiscount;
	}

	public double getTotalBeforeDiscount() {
		return totalBeforeDiscount;
	}

	public void setTotalBeforeDiscount(double totalBeforeDiscount) {
		this.totalBeforeDiscount = totalBeforeDiscount;
	}

	public double getTotalAfterDiscount() {
		return totalAfterDiscount;
	}

	public void setTotalAfterDiscount(double totalAfterDiscount) {
		this.totalAfterDiscount = totalAfterDiscount;
	}

	public double getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(double percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}

	public double getPurchaseDiscount() {
		return purchaseDiscount;
	}

	public void setPurchaseDiscount(double purchaseDiscount) {
		this.purchaseDiscount = purchaseDiscount;
	}

	@Override
	public String toString() {
		return "BillDTO [totalBeforeDiscount=" + totalBeforeDiscount + ", totalAfterDiscount=" + totalAfterDiscount
				+ ", percentageDiscount=" + percentageDiscount + ", purchaseDiscount=" + purchaseDiscount + "]";
	}

}
