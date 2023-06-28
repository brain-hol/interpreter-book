sealed class Token {
    object ILLEGAL : Token()
    object EOF : Token()

    data class IDENT(val identifier: String) : Token()
    data class INT(val value: String) : Token()

    object ASSIGN : Token()
    object PLUS : Token()
    object MINUS : Token()
    object BANG : Token()
    object ASTERISK : Token()
    object SLASH : Token()

    object LT : Token()
    object GT : Token()

    object COMMA : Token()
    object SEMICOLON : Token()

    object LPAREN : Token()
    object RPAREN : Token()
    object LBRACE : Token()
    object RBRACE : Token()

    object FUNCTION : Token()
    object LET : Token()
    object TRUE : Token()
    object FALSE : Token()
    object IF : Token()
    object ELSE : Token()
    object RETURN : Token()
}