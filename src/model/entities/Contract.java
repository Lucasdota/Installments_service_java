package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.services.OnlinePaymentService;

public class Contract {
	
	private Integer number;
	private Date date;
	private Double totalValue;
	List<Installment> installments = new ArrayList<>();
	private OnlinePaymentService onlinePaymentService;
	
	public Contract() {
		
	}

	public Contract(Integer number, Date date, Double totalValue, OnlinePaymentService onlinePaymentService) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
		this.onlinePaymentService = onlinePaymentService;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}

	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}

	public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
}
