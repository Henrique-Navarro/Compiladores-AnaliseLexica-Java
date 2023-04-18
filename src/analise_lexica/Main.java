package analise_lexica;

import java.io.IOException;

import util.Arquivo;

public class Main {
	public static void main(String args[]) throws IOException {
		//String path = "./codes/all_symbols.txt";
		//String path = "./codes/teste.simples";		
		//String path = "./codes/teste01.txt";
		String path = "./codes/avaliacao.simples";
		
		Arquivo arq = new Arquivo(path);
		String data = arq.ler();

		new AnaliseLexica(data);
	}
}
