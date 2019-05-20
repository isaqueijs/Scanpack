package dados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import excecoes.CodigoInexIstenteException;

import negocios.Pote;

public class RepositorioPotes {
	private static RepositorioPotes instancia;
	private ArrayList<Pote> listaPotes = new ArrayList<Pote>();

	public static RepositorioPotes getInstancia() throws Exception {
		if (instancia == null) {
			instancia = new RepositorioPotes();
		}
		return instancia;
	}

	public ArrayList<Pote> getListaPotes() {
		return listaPotes;
	}

	public void setListaPotes(ArrayList<Pote> listaPotes) {
		this.listaPotes = listaPotes;
	}

	public void cadastrarPote(Pote pote) {
		listaPotes.add(pote);
	}

	public Pote recuperarPote(String codigo) throws CodigoInexIstenteException {

		Pote achado = null;
		for (Pote p : listaPotes) {
			if (p.getCodigo().equals(codigo)) {
				achado = p;
				break;
			}
		}
		/*
		 * if(achado == null) { throw new
		 * CodigoInexIstenteException("Codigo inexistente!"); }
		 */return achado;

	}

	public void imprimirPotes() {

		for (int i = 0; i < listaPotes.size(); i++) {

			// System.out.println("\nCodigo: " + listaPotes.get(i).getCodigo() + "
			// Descrição: " + listaPotes.get(i).getDescricao() + "Imagem :" +
			// listaPotes.get(i).getImagem());
			JOptionPane.showMessageDialog(null, listaPotes.get(i).getDescricao());
		}

	}

	public void atualizarArquivo() {

		InputStream arquivo = getClass().getClassLoader().getResourceAsStream("dados/base.txt");
	}

	public void lerArquivo() throws FileNotFoundException, URISyntaxException {

		System.out.println("");
		Pote pote;
		String coluna[] = null;
		String linhasDoArquivo = null;
		String descricao, codigo, imagem;

		/* ----- Versão para abrir arquivo no Windows ------- */
		// InputStream arquivo = new FileInputStream("C:\\Scanpack\\base.csv");

		/* ----- Versão para abrir arquivo no Linux ------- */
		InputStream arquivo = new FileInputStream("/home/tifib/Documentos/Scanpack/base.csv");

		Scanner scnr = new Scanner(arquivo);

		while (scnr.hasNext()) {
			linhasDoArquivo = scnr.nextLine();
			coluna = linhasDoArquivo.split(";");
			descricao = coluna[0];
			codigo = coluna[1];
			imagem = coluna[2];

			// JOptionPane.showMessageDialog(null, linhasDoArquivo);
			pote = new Pote(descricao, codigo, imagem);
			cadastrarPote(pote);
		}
		scnr.close();

	}

}
