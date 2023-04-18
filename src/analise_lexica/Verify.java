package analise_lexica;

import java.util.ArrayList;

public class Verify {
	// private PalavrasReservadas palavras_reservadas;

	public boolean is_char(char c) {
		return Character.isLetter(c);
	}

	public boolean is_number(char c) {
		return Character.isDigit(c);
	}

	public boolean is_digit(char c) {
		return Character.isDigit(c);
	}

	public boolean is_another_symbol(char c) {
		return c == '?' || c == '@' || c == '$' || c == '&' || c == '\\';
	}

	public boolean is_single_quote(char c) {
		return c == '\'';
	}

	public boolean is_double_quote(char c) {
		return c == '"';
	}

	public boolean is_open_parenthesis(char c) {
		return c == '(';
	}

	public boolean is_close_parenthesis(char c) {
		return c == ')';
	}

	public boolean is_open_bracket(char c) {
		return c == '[';
	}

	public boolean is_close_bracket(char c) {
		return c == ']';
	}

	public boolean is_open_braces(char c) {
		return c == '{';
	}

	public boolean is_close_braces(char c) {
		return c == '}';
	}

	public boolean is_hash(char c) {
		return c == '#';
	}

	public boolean is_slash(char c) {
		return c == '/';
	}

	public boolean is_semicolon(char c) {
		return c == ';';
	}

	public boolean is_equal(char c) {
		return c == '=';
	}

	public boolean is_not_equal(char c) {
		return c == '!';
	}

	public boolean is_plus(char c) {
		return c == '+';
	}

	public boolean is_minus(char c) {
		return c == '-';
	}

	public boolean is_multiplication(char c) {
		return c == '*';
	}

	public boolean is_math_operator(char c) {
		return c == '*' || c == '/' || c == '^';
	}

	public boolean is_logical_operator(char c) {
		return c == '&' || c == '|';
	}

	public boolean is_greater_comparison(char c) {
		return c == '>';
	}

	public boolean is_lesser_comparison(char c) {
		return c == '<';
	}

	public boolean is_space(char c) {
		return c == ' ' || c == '\t';
	}

	public boolean is_line_break(char c) {
		return c == '\n' || c == '\r';
	}

	public String palavra_resevada() {
		return " ";
	}

	public PalavrasReservadas is_palavra_reservada(String lexema) {
		Palavras palavras = new Palavras();
		ArrayList<PalavrasReservadas> all_words = palavras.get_palavras_reservadas();
		for (PalavrasReservadas s : all_words)
			if (s.toString().toLowerCase().equals(lexema.toLowerCase()))
				return s;
		return null;
	}
}
