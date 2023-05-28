package ed.t2.listapatrimonios;

import java.math.BigDecimal;

public class Patrimonio implements Comparable<Patrimonio> {
	private String cpf;
	private String descricao;
	private BigDecimal valor;

	public Patrimonio(String cpf, String descricao, BigDecimal valor) {
		super();
		this.cpf = cpf;
		this.descricao = descricao;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Descricao: " + descricao + ", Valor: $" + valor + ", Contribuinte: " + cpf;
	}

	@Override
	public int compareTo(Patrimonio o) {
		return this.valor.compareTo(o.getValor());
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
