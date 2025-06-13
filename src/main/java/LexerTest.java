public class LexerTest {

    public static void main(String[] args) {
        String code = """
            class Test {
                public static void main(String[] args) {
                    int x = 42;
                    if (x < 100) {
                        Print(x);
                    }
                }
            }
        """;

        Lexer lexer = new Lexer();
        lexer.readLexeme(code);
        System.out.println(lexer.data.getSymbolTable());
        for (Token token: lexer.data.getTokenList()) {
            System.out.println(token);
        }
        }
}
