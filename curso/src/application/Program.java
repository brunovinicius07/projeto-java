package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.Nivel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner leia = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("ss/MM/yyyy");
		
		System.out.print("Informe o nome do departamento: ");
		String nomeDepartamento = leia.nextLine();
		System.out.println("Insira os dados do trabalhador:");
		System.out.print("Nome: ");
		String nomeTrab = leia.nextLine();
		System.out.print("Nivel: ");
		String nivelTrab = leia.nextLine();
		System.out.print("Sal�rio base: ");
		double salarioBase = leia.nextDouble();
		Trabalhador trabalhador = new Trabalhador(nomeTrab, Nivel.valueOf(nivelTrab),salarioBase, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos para este trabalhador?");
		int n = leia.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Insira os dados do contrato n�" + i + " : ");
			System.out.print("Data (DD/MM/AAAA): ");
			Date dataContrato = sdf.parse(leia.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = leia.nextDouble();
			System.out.print("Dura��o (horas): ");
			int horas = leia.nextInt();
			ContratoHora contrato = new ContratoHora(dataContrato, valorPorHora, horas);
			trabalhador.addContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Insira o m�s e o ano para calcular a renda (MM/AAAA): ");
		String mesAno = leia.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Depatarmento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda para " + mesAno + ": " + String.format("%.2f", trabalhador.renda(ano, mes)));
		
		
		leia.close();

	}

}
