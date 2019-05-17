package negocios;

public class User {

	private String login;
	private String senha;
	private boolean adm;

	public User(String login, String senha, boolean b) {
		// TODO Auto-generated constructor stub
		this.login = login;
		this.senha = senha;
		this.adm = b;

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdm() {
		return adm;
	}

	public void setAdm(boolean adm) {
		this.adm = adm;
	}

}
