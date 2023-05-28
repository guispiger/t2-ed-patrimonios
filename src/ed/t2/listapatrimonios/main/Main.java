package ed.t2.listapatrimonios.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import ed.t2.listapatrimonios.Contribuinte;
import ed.t2.listapatrimonios.Impressora;
import ed.t2.listapatrimonios.Patrimonio;
import ed.t2.listapatrimonios.Processador;
import ed.t2.listapatrimonios.leitorcsv.LeitorCSV;

public class Main {
	public static void main(String[] args) {
		LeitorCSV leitor = new LeitorCSV();
		Processador processador = new Processador();
		Impressora impressora = new Impressora();

		// Importa dados dos aquivos externos
		HashSet<Contribuinte> contribuintes = leitor.lerContribuintes();
		ArrayList<Patrimonio> patrimonios = leitor.lerPatrimonios();

		// Cadastra patrimonios e calcula o valor total a ser declarado
		Iterator<Contribuinte> iterador = contribuintes.iterator();
		while (iterador.hasNext()) {
			Contribuinte contribuinte = iterador.next();
			processador.cadastrarPatrimonios(contribuinte, patrimonios);
			processador.calcularValorDeclarado(contribuinte);
		}

		// imprime 10 contribuintes de menor e maior valor declarado
		System.out.println("\n-----------------------------------------");
		ArrayList<Contribuinte> contribuintesOrdenadosMenorValor = processador
				.extrairContribuintesPeloValorDeclarado(contribuintes, 10, 1);
		System.out.println("Contribuintes de Menor valor declarado:\n");
		impressora.imprimirContribuintes(contribuintesOrdenadosMenorValor);
		System.out.println("=========================================");
		System.out.println("Contribuintes de Maior Valor declarado:\n");
		ArrayList<Contribuinte> contribuintesOrdenadosMaiorValor = processador
				.extrairContribuintesPeloValorDeclarado(contribuintes, 10, -1);
		impressora.imprimirContribuintes(contribuintesOrdenadosMaiorValor);

		// Imprime os tres patrimonios de maior valor
		System.out.println("\n-----------------------------------");
		System.out.println("Patrimônios de maior valor: ");
		processador.ordenaPatrimoniosMaiorValor(patrimonios);
		impressora.imprimePatrimonios(patrimonios, 3);

	}
}
