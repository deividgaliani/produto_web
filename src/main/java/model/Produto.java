package model;

public class Produto {

	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private Double valor;
	
	private Integer categoria;
	
	private String imagePath;

	public Produto() {
		//default constructor
	}
	
	public Produto(Integer id, String nome, String descricao, Double valor, Integer categoria, String imagePath) throws RuntimeException{
		setId(id);
		setNome(nome);
		setDescricao(descricao);
		setValor(valor);
		setCategoria(categoria);
		setImagePath(imagePath);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validaValorNulo(nome);
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		validaValorNulo(descricao);
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		validaValorNulo(valor);
		this.valor = valor;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		validaValorNulo(categoria);
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
//		validaValorNulo(imagePath);
		this.imagePath = imagePath;
	}

	private void validaValorNulo(Object valor) throws RuntimeException{
		if(valor == null) {
			throw new RuntimeException("Todos os campos s�o obrigat�rios");
		}
	}
	
}
