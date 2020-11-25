package com.revature.p0.model;

public class BudgetMonthly {
	
	public BudgetMonthly(int expenseId, int userId, double housing, double utilites, double internet, double grocery,
			double entertainment, double transportation, double savings) {
		super();
		this.expenseId = expenseId;
		this.userId = userId;
		this.housing = housing;
		this.utilites = utilites;
		this.internet = internet;
		this.grocery = grocery;
		this.entertainment = entertainment;
		this.transportation = transportation;
		this.savings = savings;
	}
	private int expenseId;
	private int userId;
	private double housing;
	private double utilites;
	private double internet;
	private double grocery;
	private double entertainment;
	private double transportation; 
	private double savings;
	
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getHousing() {
		return housing;
	}
	public void setHousing(double housing) {
		this.housing = housing;
	}
	public double getUtilites() {
		return utilites;
	}
	public void setUtilites(double utilites) {
		this.utilites = utilites;
	}
	public double getInternet() {
		return internet;
	}
	public void setInternet(double internet) {
		this.internet = internet;
	}
	public double getGrocery() {
		return grocery;
	}
	public void setGrocery(double grocery) {
		this.grocery = grocery;
	}
	public double getEntertainment() {
		return entertainment;
	}
	public void setEntertainment(double entertainment) {
		this.entertainment = entertainment;
	}
	public double getTransportation() {
		return transportation;
	}
	public void setTransportation(double transportation) {
		this.transportation = transportation;
	}
	public double getSavings() {
		return savings;
	}
	public void setSavings(double savings) {
		this.savings = savings;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(entertainment);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + expenseId;
		temp = Double.doubleToLongBits(grocery);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(housing);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(internet);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(savings);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(transportation);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userId;
		temp = Double.doubleToLongBits(utilites);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BudgetMonthly other = (BudgetMonthly) obj;
		if (Double.doubleToLongBits(entertainment) != Double.doubleToLongBits(other.entertainment))
			return false;
		if (expenseId != other.expenseId)
			return false;
		if (Double.doubleToLongBits(grocery) != Double.doubleToLongBits(other.grocery))
			return false;
		if (Double.doubleToLongBits(housing) != Double.doubleToLongBits(other.housing))
			return false;
		if (Double.doubleToLongBits(internet) != Double.doubleToLongBits(other.internet))
			return false;
		if (Double.doubleToLongBits(savings) != Double.doubleToLongBits(other.savings))
			return false;
		if (Double.doubleToLongBits(transportation) != Double.doubleToLongBits(other.transportation))
			return false;
		if (userId != other.userId)
			return false;
		if (Double.doubleToLongBits(utilites) != Double.doubleToLongBits(other.utilites))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BudgetMonthly [expenseId=" + expenseId + ", userId=" + userId + ", housing=" + housing + ", utilites="
				+ utilites + ", internet=" + internet + ", grocery=" + grocery + ", entertainment=" + entertainment
				+ ", transportation=" + transportation + ", savings=" + savings + "]";
	}
	
	
	
}
