package servlet;

import java.util.ArrayList;
import java.util.List;

public class ResultadoOperacao<T> {

	private Boolean sucesso;
	
	private List<T> dados;
	
	private String mensagem;

	public Boolean getSucesso() {
		return sucesso;
	}

	public void setSucesso(Boolean sucesso) {
		this.sucesso = sucesso;
	}

	public List<T> getDados() {
		if (dados == null) {
			dados = new ArrayList<T>();
		}
		return dados;
	}

	public void setDados(List<T> dados) {
		this.dados = dados;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
