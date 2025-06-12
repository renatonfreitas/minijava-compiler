public class LexerTest {

    public static void main(String[] args) {
        String code = """
            class Test {
                public static void main(String[] args) {
                    int x;
                    boolean y = true;
                    boolean z = true;
                        if (x && y) {
                            x = 42;
                        }
                }
            }
        """;

        Lexer lexer = new Lexer();
        lexer.readLexeme(code);

        }
}
