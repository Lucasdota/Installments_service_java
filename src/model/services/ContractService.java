package model.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	public void processContract(Contract contract, Integer months) throws ParseException {
		List<Installment> installments = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(contract.getDate());
		Double dividedValue = contract.getTotalValue() / months;
		
		for (int i= 1; i<=months; i++) {
			calendar.add(Calendar.DAY_OF_MONTH, 30);
			Double interest = contract.getOnlinePaymentService().interest(dividedValue, i);
			Double paymentFee = contract.getOnlinePaymentService().paymentFee(dividedValue+interest);
			Double value = dividedValue + interest + paymentFee;
			Installment installment = new Installment(calendar.getTime(), value);
		    installments.add(installment);
		}
		
		contract.setInstallments(installments);
	}
}
