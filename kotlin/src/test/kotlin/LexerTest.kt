import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class LexerTest {

    @Test
    fun testNextToken() {
        val input = """
            let five = 5;
            let ten = 10;

            let add = fn(x, y) {
              x + y;
            };

            let result = add(five, ten);
            !-/*5;
            5 < 10 > 5;
            
            if (5 < 10) {
                return true;
            } else {
                return false;
            }
            """.trimIndent()

        val expected = listOf(
            Token.LET,
            Token.IDENT("five"),
            Token.ASSIGN,
            Token.INT("5"),
            Token.SEMICOLON,
            Token.LET,
            Token.IDENT("ten"),
            Token.ASSIGN,
            Token.INT("10"),
            Token.SEMICOLON,
            Token.LET,
            Token.IDENT("add"),
            Token.ASSIGN,
            Token.FUNCTION,
            Token.LPAREN,
            Token.IDENT("x"),
            Token.COMMA,
            Token.IDENT("y"),
            Token.RPAREN,
            Token.LBRACE,
            Token.IDENT("x"),
            Token.PLUS,
            Token.IDENT("y"),
            Token.SEMICOLON,
            Token.RBRACE,
            Token.SEMICOLON,
            Token.LET,
            Token.IDENT("result"),
            Token.ASSIGN,
            Token.IDENT("add"),
            Token.LPAREN,
            Token.IDENT("five"),
            Token.COMMA,
            Token.IDENT("ten"),
            Token.RPAREN,
            Token.SEMICOLON,
            Token.BANG,
            Token.MINUS,
            Token.SLASH,
            Token.ASTERISK,
            Token.INT("5"),
            Token.SEMICOLON,
            Token.INT("5"),
            Token.LT,
            Token.INT("10"),
            Token.GT,
            Token.INT("5"),
            Token.SEMICOLON,
            Token.IF,
            Token.LPAREN,
            Token.INT("5"),
            Token.LT,
            Token.INT("10"),
            Token.RPAREN,
            Token.LBRACE,
            Token.RETURN,
            Token.TRUE,
            Token.SEMICOLON,
            Token.RBRACE,
            Token.ELSE,
            Token.LBRACE,
            Token.RETURN,
            Token.FALSE,
            Token.RBRACE,
            Token.EOF,
        )

        val lexer = Lexer(input)

        for (expectedToken in expected) {
            val token = lexer.nextToken()
            assertEquals(expectedToken, token)
        }
    }
}
