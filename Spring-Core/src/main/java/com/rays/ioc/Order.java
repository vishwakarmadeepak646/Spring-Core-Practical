package com.rays.ioc;

public class Order {

	private Inventory invt;
	private Payment pmt;

	public void setInvt(Inventory invt) {
		this.invt = invt;
	}

	public void setPmt(Payment pmt) {
		this.pmt = pmt;
	}

	public void order(int item) {

		int peritem = 10;
		int totalAmt = peritem * item;
		int remainingAmt = pmt.pay(totalAmt);
		int remainingBooks = invt.sold(peritem);

		System.out.println("amount paid: " + totalAmt);
		System.out.println("book ordered: " + item);
		System.out.println("remaining amt: " + remainingAmt);
		System.out.println("remaining book: " + remainingBooks);

	}

}
