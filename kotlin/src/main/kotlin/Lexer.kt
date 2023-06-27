class Lexer(private val input: String) {

    private var position: Int = 0
    private var readPosition: Int = 0
    private var ch: Char = '\u0000'

    init {
        readChar()
    }

    private fun readChar() {
        ch = if (readPosition >= input.length) {
            '\u0000'
        } else {
            input[readPosition]
        }
        position = readPosition
        readPosition += 1
    }

    fun nextToken(): Token {
        skipWhitespace()
        val token = when(ch) {
            '=' -> Token.ASSIGN
            ';' -> Token.SEMICOLON
            '(' -> Token.LPAREN
            ')' -> Token.RPAREN
            ',' -> Token.COMMA
            '+' -> Token.PLUS
            '{' -> Token.LBRACE
            '}' -> Token.RBRACE
            '\u0000' -> Token.EOF
            else -> if (ch.isLetter()) {
                return when (val ident = readIdentifier()) {
                    "fn" -> Token.FUNCTION
                    "let" -> Token.LET
                    else -> Token.IDENT(ident)
                }
            } else if (ch.isDigit()) {
                return Token.INT(readNumber())
            } else {
                Token.ILLEGAL
            }
        }
        readChar()
        return token
    }

    private fun readIdentifier(): String {
        val startingPos = position
        while (ch.isLetter()) {
            readChar()
        }
        return input.substring(startingPos until position)
    }

    private fun readNumber(): String {
        val startingPos = position
        while (ch.isDigit()) {
            readChar()
        }
        return input.substring(startingPos until position)
    }

    private fun skipWhitespace() {
        while (ch.isWhitespace()) {
            readChar()
        }
    }
}