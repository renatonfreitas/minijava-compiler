import java.util.ArrayList;

public class Lexer2 {

    public void readLexeme(String code){
        LexerUtils utils = new LexerUtils();
        ArrayList<Token> tokenList = new ArrayList<Token>();
        ArrayList<String> symbolTable = new ArrayList<String>();

        String[] lines = code.split("\n");
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].strip();
        }

        for (int l = 0; l < lines.length; l++) {
            char[] chars = lines[l].toCharArray();
            int startLexeme = 0;
            int endLexeme = 0;

            for (int c = 0; c < chars.length; c++) {
                endLexeme = c;
                char currentChar = chars[c];

                if (!utils.isLetter(currentChar) && !utils.isDigit(currentChar)){ // non identifier


                    // prevents empty lexemes that can be formed when a non identifier follows a non identifier
                    if (startLexeme != endLexeme){

                        if (!utils.isDoubleSymbol(currentChar) || ((utils.isLetter(chars[c-1]) && utils.isDoubleSymbol(currentChar)))){
                            String previousLexeme = lines[l].substring(startLexeme, endLexeme); // end is exclusive
                            System.out.println(previousLexeme);
                        }
                    }

                    // if the non identifier is space, skip it
                    if (utils.isSpace(currentChar)){
                        startLexeme = c+1;
                        continue;

                        // if the non identifier is not a space, look the current char
                    } else {
                        if (!utils.isDoubleSymbol(currentChar) || ( (utils.isLetter(chars[c-1])) && (utils.isDoubleSymbol(currentChar)) )){
                            startLexeme = c;
                        }

                        // handles symbols in the end of line
                        if ((c == (chars.length-1)) && utils.isEndSymbol(currentChar)){
                            String endLine = lines[l].substring(startLexeme, endLexeme+1);
                            System.out.println(endLine);
                        }

                    }

                    // handles letters or digits
                } else {

                    // cover a letter or digit immediately after a non letter and digit
                    if (((endLexeme - startLexeme) > 0) && !utils.isDigit(chars[startLexeme]) && !utils.isLetter(chars[startLexeme])){
                        String previousLexeme = lines[l].substring(startLexeme, endLexeme);
                        System.out.println(previousLexeme);

                        // if the letter or digit
                        if (utils.isSpace(currentChar)){
                            startLexeme = c+1;
                            continue;
                        } else {
                            startLexeme = c;
                        }
                    }
                }

            }
        }
    }
}
