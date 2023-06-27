sealed class Token {
    object ILLEGAL : Token()
    object EOF : Token()

    data class IDENT(val identifier: String) : Token()
    data class INT(val value: String) : Token()

    object ASSIGN : Token()
    object PLUS : Token()

    object COMMA : Token()
    object SEMICOLON : Token()


    object LPAREN : Token()
    object RPAREN : Token()
    object LBRACE : Token()
    object RBRACE : Token()

    object FUNCTION : Token()
    object LET : Token()
}