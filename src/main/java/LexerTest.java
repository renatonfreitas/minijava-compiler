public class LexerTest {

    public static void main(String[] args) {
        String code = """
            class Test {
                public static void main(String[] args) {
                    int x = 42;
                    if (x < 100) {
                        x = x + 1;
                    }
                }
            }
        """;

        Lexer lexer = new Lexer();
        lexer.readLexeme(code);

        }




}
