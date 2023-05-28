package ed.t2.listapatrimonios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Processador {
	public void cadastrarPatrimonios(Contribuinte contribuinte, ArrayList<Patrimonio> patrimonios) {
		for (Patrimonio patrimonio : patrimonios) {
			if (patrimonio != null) {
				if (patrimonio.getCpf().equals(contribuinte.getCpf())) {
					contribuinte.getPatrimonios().add(patrimonio);
				}
			}
		}
	}

	public void calcularValorDeclarado(Contribuinte c) {
		BigDecimal valorPatrimonios = new BigDecimal("0");
		for (Patrimonio patrimonio : c.getPatrimonios()) {
			valorPatrimonios = valorPatrimonios.add(patrimonio.getValor());
		}

		BigDecimal valorDeclaradoAtualizado = c.getRendaAnual().add(valorPatrimonios);
		c.setValorDeclarado(valorDeclaradoAtualizado);
	}

	public ArrayList<Contribuinte> extrairContribuintesPeloValorDeclarado(HashSet<Contribuinte> contribuintes,
			int posicoes, int ordem) {
		ArrayList<Contribuinte> contribuintesList = new ArrayList<Contribuinte>(contribuintes);
		ArrayList<Contribuinte> contribuintesOrdenados = new ArrayList<Contribuinte>();

		if (ordem > 0) {
			Collections.sort(contribuintesList);
		} else {
			Collections.sort(contribuintesList, Collections.reverseOrder());
		}

		for (int i = 0; i < posicoes; i++) {
			contribuintesOrdenados.add(contribuintesList.get(i));
		}

		return contribuintesOrdenados;
	}

	public void ordenaPatrimoniosMaiorValor(ArrayList<Patrimonio> patrimonios) {
		Collections.sort(patrimonios, Collections.reverseOrder());

	}
}
