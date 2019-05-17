package teste;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import dados.RepositorioPotes;
import gui.TelaConsulta;
import gui.TelaConsulta;

public class Iniciar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pote pote = null;
		// TODO Auto-generated method stub
		// RepositorioPotes.getInstancia().lerArquivoCSV();
		try {
			RepositorioPotes.getInstancia().lerArquivo();
			// RepositorioPotes.getInstancia().imprimirPotes();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// RepositorioPotes.getInstancia().imprimirPotes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TelaConsulta tela = new TelaConsulta();
		TelaConsulta tela = new TelaConsulta();
		tela.setVisible(true);

	}

}
