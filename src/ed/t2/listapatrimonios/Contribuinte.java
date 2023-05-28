package ed.t2.listapatrimonios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class Contribuinte implements Comparable<Contribuinte> {
	private String cpf;
	private String nome;
	private String sobrenome;
	private String email;
	private BigDecimal rendaAnual;
	private ArrayList<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
	private BigDecimal valorDeclarado;

	public Contribuinte(String cpf, String nome, String sobrenome, String email, BigDecimal rendaAnual) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.rendaAnual = rendaAnual;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " CPF: " + cpf + " Valor Total Declarado: " + valorDeclarado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contribuinte other = (Contribuinte) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public int compareTo(Contribuinte o) {
		return this.valorDeclarado.compareTo(o.getValorDeclarado());
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(BigDecimal rendaAnual) {
		this.rendaAnual = rendaAnual;
	}

	public ArrayList<Patrimonio> getPatrimonios() {
		return patrimonios;
	}

	public void setPatrimonios(ArrayList<Patrimonio> patrimonios) {
		this.patrimonios = patrimonios;
	}

	public BigDecimal getValorDeclarado() {
		return valorDeclarado;
	}

	public void setValorDeclarado(BigDecimal valorDeclarado) {
		this.valorDeclarado = valorDeclarado;
	}

}
