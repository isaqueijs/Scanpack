package negocios;

import javax.swing.JOptionPane;

import dados.RepositorioPotes;
import excecoes.CodigoInexIstenteException;

public class Fachada {
	private static Fachada instancia;
	private User admin = new User("ti.nordeste", "4RRUD3I3!", true);

	// private RepositorioPotes basePotes = new RepositorioPotes();

	public static Fachada getInstancia() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}

	public Pote buscarPote(String codigo) {
		Pote pote = null;
		try {
			pote = RepositorioPotes.getInstancia().recuperarPote(codigo);
		} catch (CodigoInexIstenteException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Codigo inexistente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Codigo inexistente");
		}

		return pote;

	}

	public User loginAdmin(String login, String senha) {

		return admin;
	}

}
