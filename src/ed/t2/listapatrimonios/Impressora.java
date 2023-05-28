package ed.t2.listapatrimonios;

import java.util.ArrayList;

public class Impressora {

	public void imprimePatrimonios(ArrayList<Patrimonio> patrimonios, int posicoes) {
		for (int i = 0; i < posicoes; i++) {
			System.out.println(patrimonios.get(i));
		}
	}

	public void imprimirContribuintes(ArrayList<Contribuinte> contribuintes) {
		for (Contribuinte contribuinte : contribuintes) {
			System.out.println(contribuinte);
		}
	}
}
