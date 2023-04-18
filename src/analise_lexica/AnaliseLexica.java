package analise_lexica;

import java.util.ArrayList;

public class AnaliseLexica {
	private String data_string;
	private char[] data_char;
	private String lexema;
	private Verify verify;
	private int row, column;
	private char peek;
	private int i;
	private int state;
	private ArrayList<Token> all_tokens;
	// TABELA HASH

	public AnaliseLexica(String data) {
		this.data_string = data;
		this.data_char = string_to_chars(data_string);
		this.all_tokens = new ArrayList<Token>();
		this.verify = new Verify();
		this.lexema = "";
		this.peek = ' ';
		this.column = 0;
		this.state = 0;
		this.row = 0;
		this.i = 0;

		// this.printar_array(data_char);
		scanner();
		//identificar_tokens();
		System.out.println("\nTotal Tokens: "+all_tokens.size());
	}

	public char[] string_to_chars(String data) {
		char[] array_char = new char[data.length() + 1];
		for (int i = 0; i < data.length(); i++) {
			char c = data.charAt(i);
			array_char[i] = c;
		}
		array_char[data.length()] = ' ';
		return array_char;
	}

	public void printar_array(char[] array) {
		for (char c : array)
			System.out.print(c + "");
	}

	public char get_next_char() {
		return i != data_char.length ? data_char[i++] : '\u0000';
	}

	public void scanner() {
		peek = get_next_char();
		while (peek != '\u0000') {
			Token t = get_token();
			peek = get_next_char();

			if (t != null) {
				state = 0;
				all_tokens.add(t);
				System.out.printf(row + "\t");
				t.print_completo();
				lexema = "";
			}
		}
	}

	public void identificar_tokens() {
		int pal_reserv = 0, op = 0, tipos = 0, consts = 0, id = 0, num = 0, count = 0;
		for (Token t : all_tokens) {
			count++;
			
		}
		System.out.println("\ncount: " + count);
	}

	public Token get_token() {
		// System.out.println("peek: "+peek);
		// System.out.println("state: " + state);
		// System.out.println("lexema: " + lexema);

		// TODO: TOKEN MAL FORMADO
		// TODO: LINHA E COLUNA
		switch (state) {
		case 0:
			// TODOS OS POSSIVEIS ESTADOS PARTINDO DO ESTADO 0
			if (verify.is_space(peek)) {
				state = 0;
				column++;

			} else if (verify.is_line_break(peek)) {
				state = 0;
				row++;

			} else if (verify.is_char(peek)) {
				state = 1;
				lexema = lexema + peek;

			} else if (verify.is_lesser_comparison(peek)) {
				state = 3;
				lexema = lexema + peek;

			} else if (verify.is_greater_comparison(peek)) {
				state = 4;
				lexema = lexema + peek;

			} else if (verify.is_equal(peek)) {
				state = 5;
				lexema = lexema + peek;

			} else if (verify.is_plus(peek)) {
				state = 7;
				lexema = lexema + peek;

			} else if (verify.is_minus(peek)) {
				state = 8;
				lexema = lexema + peek;

			} else if (verify.is_multiplication(peek)) {
				state = 9;
				lexema = lexema + peek;

			} else if (verify.is_number(peek)) {
				state = 11;
				lexema = lexema + peek;

			} else if (verify.is_semicolon(peek)) {
				state = 12;
				lexema = lexema + peek;

			} else if (verify.is_slash(peek)) {
				state = 13;
				lexema = lexema + peek;

			} else if (verify.is_hash(peek)) {
				state = 16;
				lexema = lexema + peek;

			} else if (verify.is_single_quote(peek)) {
				state = 18;
				lexema = lexema + peek;

			} else if (verify.is_double_quote(peek)) {
				state = 21;
				lexema = lexema + peek;

			} else if (verify.is_open_parenthesis(peek)) {
				state = 24;
				lexema = lexema + peek;

			} else if (verify.is_close_parenthesis(peek)) {
				state = 25;
				lexema = lexema + peek;

			} else if (verify.is_open_bracket(peek)) {
				state = 26;
				lexema = lexema + peek;

			} else if (verify.is_close_bracket(peek)) {
				state = 27;
				lexema = lexema + peek;

			} else if (verify.is_open_braces(peek)) {
				state = 28;
				lexema = lexema + peek;

			} else if (verify.is_close_braces(peek)) {
				state = 29;
				lexema = lexema + peek;

			} else {
				state = 99;
				lexema = lexema + peek;

			}
			break;

		case 1:
			if (verify.is_char(peek) || verify.is_number(peek))
				lexema = lexema + peek;

			else if (!verify.is_char(peek) || !verify.is_number(peek))
				state = 2;

			break;

		case 2:
			back();
			back();
			if (verify.is_palavra_reservada(lexema) != null) {
				if (lexema.toLowerCase().equals("div"))
					return new Token(lexema, TokenName.OPERADOR_MATEMATICO);

				PalavrasReservadas palavraReservada = verify.is_palavra_reservada(lexema);
				return new Token(lexema, TokenName.PALAVRA_RESERVADA, palavraReservada);
			} else
				return new Token(lexema, TokenName.IDENTIFICADOR);

		case 3:
			if (verify.is_minus(peek)) {
				lexema = lexema + peek;
				return new Token(lexema, TokenName.OPERADOR_ATRIBUICAO);

			} else
				state = 6;

			break;

		case 4:
			if (!verify.is_greater_comparison(peek))
				state = 6;
			break;

		case 5:
			if (verify.is_equal(peek)) {
				lexema = lexema + peek;
				return new Token(lexema, TokenName.OPERADOR_COMPARACAO);
			}
			break;

		case 6:
			back();
			back();
			return new Token(lexema, TokenName.OPERADOR_COMPARACAO);

		case 7:
			state = 10;
			break;

		case 8:
			state = 10;
			break;

		case 9:
			state = 10;
			break;

		case 10:
			back();
			back();
			return new Token(lexema, TokenName.OPERADOR_MATEMATICO);

		case 11:
			if (verify.is_number(peek))
				lexema = lexema + peek;

			else if (verify.is_char(peek)) {
				lexema = lexema + peek;
				state = 30;
			}

			else {
				back();
				return new Token(lexema, TokenName.NUMERO);
			}

			break;

		case 12:
			back();
			return new Token(lexema, TokenName.OPERADOR_FINAL_LINHA);

		case 13:
			if (verify.is_slash(peek)) {
				lexema = lexema + peek;
				state = 16;
			}

			else if (verify.is_multiplication(peek)) {
				lexema = lexema + peek;
				state = 14;
			}
			break;

		case 14:
			if (verify.is_line_break(peek))
				row++;
			if (verify.is_multiplication(peek)) {
				lexema = lexema + peek;
				state = 15;
			} else
				lexema = lexema + peek;
			break;

		case 15:
			if (verify.is_line_break(peek))
				row++;
			if (verify.is_slash(peek)) {
				lexema = lexema + peek;
				state = 17;
			}

			else
				lexema = lexema + peek;

			break;

		case 16:
			if (verify.is_line_break(peek)) {
				row++;
				state = 17;
			} else
				lexema = lexema + peek;
			break;

		case 17:
			back();
			return new Token(lexema, TokenName.COMENTARIO);

		case 18:
			if (!verify.is_single_quote(peek)) {
				lexema = lexema + peek;
				state = 19;
			}
			break;

		case 19:
			if (verify.is_single_quote(peek)) {
				lexema = lexema + peek;
				return new Token(lexema, TokenName.CARACTER);
				
			} else
				return new Token(lexema, TokenName.TOKEN_MAL_FORMADO);

		case 21:
			lexema = lexema + peek;
			if (verify.is_line_break(peek))
				return new Token(lexema, TokenName.TOKEN_MAL_FORMADO);

			if (verify.is_double_quote(peek))
				return new Token(lexema, TokenName.TEXTO);

			break;

		case 24:
			back();
			return new Token(lexema, TokenName.ABRE_PARENTESES);
		case 25:
			back();
			return new Token(lexema, TokenName.FECHA_PARENTESES);
		case 26:
			back();
			return new Token(lexema, TokenName.ABRE_COLCHETES);
		case 27:
			back();
			return new Token(lexema, TokenName.FECHA_COLCHETES);
		case 28:
			back();
			return new Token(lexema, TokenName.ABRE_CHAVES);
		case 29:
			back();
			return new Token(lexema, TokenName.FECHA_CHAVES);

		case 30:
			if (verify.is_line_break(peek) || verify.is_space(peek)) {
				back();
				return new Token(lexema, TokenName.TOKEN_MAL_FORMADO);

			} else
				lexema = lexema + peek;
			break;

		case 99:
			back();
			return new Token(lexema, TokenName.SIMBOLO_INVALIDO);
		}

		return null;
	}

	public void back() {
		i--;
	}
}
