package model.services;

import java.text.ParseException;
import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) throws ParseException {
		Double dividedValue = contract.getTotalValue() / months;
		
		for (int i= 1; i<=months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			Double interest = onlinePaymentService.interest(dividedValue, i);
			Double paymentFee = onlinePaymentService.paymentFee(dividedValue+interest);
			Double value = dividedValue + interest + paymentFee;
			Installment installment = new Installment(dueDate, value);		
		    contract.getInstallments().add(installment);
		}
	}
}
