package analise_lexica;

public enum TokenName {
	// POSSIVEIS TOKENS
	//PALAVRA RESERVADA
    PALAVRA_RESERVADA(PalavrasReservadas.class),
    
    //OPERADOR
    OPERADOR_MATEMATICO, 
    OPERADOR_COMPARACAO,
	OPERADOR_ATRIBUICAO,
	OPERADOR_NEGACAO, 
	OPERADOR_FINAL_LINHA, 
	ABRE_PARENTESES,
	FECHA_PARENTESES,	
	ABRE_COLCHETES,
	FECHA_COLCHETES,	
	ABRE_CHAVES,
	FECHA_CHAVES,
	
	//ID
	IDENTIFICADOR, 
	
	//NUM
	NUMERO, 
	
	//TIPOS
	TEXTO,
	CARACTER,
	
	//ERRO
	SIMBOLO_INVALIDO,
	TOKEN_MAL_FORMADO, 
	
	//IGNORAR
	ESPACO, 
	COMENTARIO;
	
	private final Class<? extends Enum<?>> enumClass;
    private Enum<?> enumValue;

    TokenName() {
        this.enumClass = null;
    }
    
    TokenName(Class<? extends Enum<?>> enumClass) {
        this.enumClass = enumClass;
    }
    
    public Enum<?> getEnumValue() {
        return enumValue;
    }

    public void setEnumValue(String value) {
        if (enumClass != null) {
            this.enumValue = Enum.valueOf((Class<TokenName>) enumClass, value.toUpperCase());
        }
    }
}
