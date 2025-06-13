public class Teste2 {
    public static void main(String[] args) {
        LexerUtils utils = new LexerUtils();
        int x;
        boolean y = true;
        boolean z = true;

        if (y&&z) {
            x = 42;
        } else {
            x = 10;
        }

        System.out.println(x);
    }
}
