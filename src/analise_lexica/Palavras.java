package analise_lexica;

import java.util.ArrayList;

public class Palavras {
	public ArrayList<PalavrasReservadas> get_palavras_reservadas() {
		ArrayList<PalavrasReservadas> all_words = new ArrayList<PalavrasReservadas>();

		// PALAVRAS
		all_words.add(PalavrasReservadas.PROGRAMA);
		all_words.add(PalavrasReservadas.INICIO);
		all_words.add(PalavrasReservadas.FIMPROGRAMA);
		all_words.add(PalavrasReservadas.LEIA);
		all_words.add(PalavrasReservadas.ESCREVA);
		all_words.add(PalavrasReservadas.FUNCAO);

		// CONDICAO
		all_words.add(PalavrasReservadas.SE);
		all_words.add(PalavrasReservadas.ENTAO);
		all_words.add(PalavrasReservadas.SENAO);
		all_words.add(PalavrasReservadas.FIMSE);

		// REPETICAO
		all_words.add(PalavrasReservadas.ENQUANTO);
		all_words.add(PalavrasReservadas.FACA);
		all_words.add(PalavrasReservadas.FIMENQUANTO);

		// CONSTANTES
		all_words.add(PalavrasReservadas.V);
		all_words.add(PalavrasReservadas.F);

		// TIPOS
		all_words.add(PalavrasReservadas.INTEIRO);
		all_words.add(PalavrasReservadas.LOGICO);
		all_words.add(PalavrasReservadas.CARACTER);
		all_words.add(PalavrasReservadas.VETOR);
		all_words.add(PalavrasReservadas.VAZIO);
		
		// OPERADORES
		all_words.add(PalavrasReservadas.DIV);
		all_words.add(PalavrasReservadas.E);
		all_words.add(PalavrasReservadas.OU);
		all_words.add(PalavrasReservadas.NAO);

		return all_words;
	}
}
