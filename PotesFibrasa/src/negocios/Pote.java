package negocios;

public class Pote {

	private String descricao;
	private String codigo;
	private String imagem;

	public Pote(String descricao, String codigo, String imagem) {

		this.descricao = descricao;
		this.codigo = codigo;
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
