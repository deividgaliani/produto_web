package servlet;

public class ProdutoVO {

	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private Double valor;
	
	private Integer categoria;
	
	private String descricaoCategoria;

	public ProdutoVO() {
		//default constructor
	}
	
	public ProdutoVO(Integer id, String nome, String descricao, Double valor, String descricaoCategoria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.descricaoCategoria = descricaoCategoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	
}
