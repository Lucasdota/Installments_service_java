package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		
		System.out.println("Entre com os dados do contrato:");
		System.out.print("Numero: ");
		Integer number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Valor do contrato: ");
		Double value = sc.nextDouble();
		System.out.print("Entre com o numero de parcelas: ");
		Integer installmentsNumber = sc.nextInt();
		
		Contract contract = new Contract(number, date, value,  new PaypalService());
		
		ContractService service = new ContractService();
		
		service.processContract(contract, installmentsNumber);
		
		System.out.println("Parcelas:");
		for (Installment i: contract.getInstallments()) {		
			System.out.println(sdf.format(i.getDueDate()) + " - " + i.getAmount());
		}
		
		sc.close();
	}
}
