package analise_lexica;

public class Token {
	private TokenName token_name;
	private String lexema;
	private PalavrasReservadas palavra_reservada;
	private String classificacao;

	public Token(String lexema, TokenName token_name) {
		this.token_name = token_name;
		this.lexema = lexema;
		this.palavra_reservada = null;
	}

	public Token(String lexema, TokenName token_name, PalavrasReservadas palavra_reservada) {
		this.token_name = token_name;
		this.lexema = lexema;
		this.palavra_reservada = palavra_reservada;
	}

	public String get_classificacao() {
		String name = get_token_name();

		// PALAVRA RESERVADA
		if (palavra_reservada != null) {
			if (name.contains("V") || name.contains("F"))
				return "CONSTANTE";

			if (name.contains("DIV") || name.contains("E") || name.contains("NAO") || name.contains("OU"))
				return "OPERADOR";
			
			
			return "PALAVRA_RESERVADA";
		}

		// OPERADOR
		if (name.contains("OPERADOR") || name.contains("ABRE") || name.contains("FECHA"))
			return "OPERADOR";

		// IDENTIFICADOR
		if (name.contains("IDENTIFICADOR"))
			return name;

		// NÚMERO
		if (name.contains("NÚMERO"))
			return name;

		// CONSTANTE
		if (name.contains("CONSTANTE"))
			return name;

		// MAL_FORMADO
		if (name.contains("MAL_FORMADO"))
			return name;

		// TIPO
		if (name.contains("TEXTO") || name.contains("CARACTER"))
			return "TIPO";

		// ERRO
		if (name.contains("SIMBOLO_INVALIDO") || name.contains("TOKEN_MAL_FORMADO"))
			return "ERRO";

		return "";
	}

	public String get_token_name() {
		return palavra_reservada == null ? token_name.toString() : palavra_reservada.toString();
	}

	public void print() {
		if (palavra_reservada == null)
			System.out.println("[" + lexema + "] \t" + token_name.toString());
		else
			System.out.println("[" + lexema + "] \t " + palavra_reservada.toString());
	}

	public void print_completo() {
		if (palavra_reservada == null)
			System.out.println("[" + lexema + "] \t" + token_name.toString());
		else
			System.out.println("[" + lexema + "] \t" + token_name.toString() + "_" + palavra_reservada.toString());
	}
}
