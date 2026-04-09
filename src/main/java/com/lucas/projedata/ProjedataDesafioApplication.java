package com.lucas.projedata;

import com.lucas.projedata.model.Funcionario;
import com.lucas.projedata.service.FuncionarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ProjedataDesafioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjedataDesafioApplication.class, args);
	}

	@Override
	public void run(String... args) {

		FuncionarioService service = new FuncionarioService();

		List<Funcionario> funcionarios = service.criarFuncionarios();
		service.removerJoao(funcionarios);
		service.aumentarSalario(funcionarios);
		imprimirFuncionarios(funcionarios);

		System.out.println("\n============================================================");
		System.out.println("Funcionários agrupados por função:");
		Map<String, List<Funcionario>> agrupados = FuncionarioService.agruparPorFuncao(funcionarios);
		imprimirAgrupados(agrupados);

		System.out.println("\nFuncionários aniversariantes (Outubro e Dezembro):");
		List<Funcionario> aniversariantes = service.filtrarAniversariantes(funcionarios);
		imprimirFuncionarios(aniversariantes);

		Funcionario maisVelho = service.encontrarMaisVelho(funcionarios);
		int idade = service.calcularIdade(maisVelho);
		System.out.println("\nFuncionário mais velho:");
		System.out.println("Nome: " + maisVelho.getNome());
		System.out.println("Idade: " + idade);
	}

	private static void imprimirFuncionarios(List<Funcionario> funcionarios) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(',');
		symbols.setGroupingSeparator('.');

		DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

		System.out.printf("%-15s %-12s %-15s %-15s%n",
				"Nome", "Nascimento", "Salário", "Função");

		System.out.println("------------------------------------------------------------");

		for (Funcionario f : funcionarios) {
			System.out.printf("%-15s %-12s %-15s %-15s%n",
					f.getNome(),
					f.getDataNascimento().format(formatter),
					"R$ " + df.format(f.getSalario()),
					f.getFuncao()
			);
		}
	}

	private static void imprimirAgrupados(Map<String, List<Funcionario>> agrupados) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(',');
		symbols.setGroupingSeparator('.');

		DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

		for (Map.Entry<String, List<Funcionario>> entry : agrupados.entrySet()) {

			System.out.println("\nFunção: " + entry.getKey());
			System.out.println("----------------------------------------");

			for (Funcionario f : entry.getValue()) {
				System.out.printf("%-15s %-12s %-15s%n",
						f.getNome(),
						f.getDataNascimento().format(formatter),
						"R$ " + df.format(f.getSalario())
				);
			}
		}
	}

}
