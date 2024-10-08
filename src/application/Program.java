package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com os dados do contrato:");
		System.out.print("Numero: ");
		Integer number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		Double value = sc.nextDouble();
		System.out.print("Entre com o numero de parcelas: ");
		Integer installmentsNumber = sc.nextInt();
		
		Contract contract = new Contract(number, date, value);
		
		ContractService service = new ContractService(new PaypalService());
		
		service.processContract(contract, installmentsNumber);
		
		System.out.println("Parcelas:");
		for (Installment i: contract.getInstallments()) {		
			System.out.println(i.getDueDate().format(fmt) + " - " + i.getAmount());
		}
		
		sc.close();
	}
}
