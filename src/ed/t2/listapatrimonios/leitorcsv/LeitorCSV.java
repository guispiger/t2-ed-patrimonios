package ed.t2.listapatrimonios.leitorcsv;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import ed.t2.listapatrimonios.Contribuinte;
import ed.t2.listapatrimonios.Patrimonio;

public class LeitorCSV {
	public HashSet<Contribuinte> lerContribuintes() {
		HashSet<Contribuinte> contribuintes = new HashSet<Contribuinte>();
		int registros = 0;

		try {
			FileReader arquivoContribuintes = new FileReader("contribuintes.csv");
			CSVFormat configuracao = CSVFormat.Builder.create().setHeader("cpf", "nome", "sobrenome", "email", "rendaAnual").setSkipHeaderRecord(true).build();
			List<CSVRecord> registro = configuracao.parse(arquivoContribuintes).getRecords();
			for (CSVRecord csvRecord : registro) {
				String cpf = csvRecord.get("cpf");
				String nome = csvRecord.get("nome");
				String sobrenome = csvRecord.get("sobrenome");
				String email = csvRecord.get("email");
				BigDecimal rendaAnual = new BigDecimal(csvRecord.get("rendaAnual"));
				registros++;

				Contribuinte c = new Contribuinte(cpf, nome, sobrenome, email, rendaAnual);

				contribuintes.add(c);			

			}

		} catch (IOException e) {
			System.out.println("Não foi possivel ler o arquivo!!");
		}

		System.out.format("Registros de contribuintes lidos: %s \n", registros);
		System.out.format("Contribuintes unicos lidos: %s \n", contribuintes.size());
		
		return contribuintes;
		
	}
	
	
	public ArrayList<Patrimonio> lerPatrimonios(){
		ArrayList<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
		int registros = 0;
		
		try {
			FileReader arquivoContribuintes = new FileReader("patrimonios.csv");
			CSVFormat configuracao = CSVFormat.Builder.create().setHeader("cpf", "descricao", "valor").setSkipHeaderRecord(true).build();
			List<CSVRecord> registro = configuracao.parse(arquivoContribuintes).getRecords();
			for (CSVRecord csvRecord : registro) {
				String cpf = csvRecord.get("cpf");
				String descricao = csvRecord.get("descricao");
				BigDecimal valor = new BigDecimal(csvRecord.get("valor"));
				registros++;
			
				Patrimonio p = new Patrimonio(cpf, descricao, valor);
				
				patrimonios.add(p);

			}

		} catch (IOException e) {
			System.out.println("Não foi possivel ler o arquivo!!");
		}
		
		System.out.format("Patrimonios lidos: %s \n", registros);
		
		return patrimonios;
	}
	
	
	
	
	
	
	
}
