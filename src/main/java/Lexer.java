import java.util.ArrayList;

public class Lexer {

    public void readLexeme(String input) {

        LexerVerifier verif = new LexerVerifier();

        ArrayList<Token> tokensList = new ArrayList<Token>();
        ArrayList<String> symbolTable = new ArrayList<String>();

        String[] lines = input.split("\n"); // store each line of the code as an element
        for (int i = 0; i < lines.length; i++){ // format each line removing unnecessary spaces
            lines[i] = lines[i].strip();
        }

        for (int l = 0; l < lines.length; l++){ // iterating each line of the code

            char[] chars = lines[l].toCharArray(); // convert the current line into a char array
            int start = 0;
            int end = 0;

            for (int c = 0; c < chars.length; c++) { // for each character of the line

                end = c;

                if (!verif.isAlphanumeric(chars[c]) && !verif.isUnderscore(chars[c])){

                    // build the previous lexeme (start untiel previous char)
                    // if a non digit or letter folow another non digit ou letter, the start and end pointers will be the same
                    if (start != end){
                        String buildingLexeme = lines[l].substring(start,end); // start is inclusive and end is exclusive
                        String name = TokenNames.IDENTIFIER.name();

                        if (!verif.isReservedWord(buildingLexeme)){
                            symbolTable.add(buildingLexeme);
                            Token tokenIdentifier = new Token(name, symbolTable.indexOf(buildingLexeme));
                            tokensList.add(tokenIdentifier);
                        }

//                        tokensList.add(buildingLexeme);
                    }

                    // build the current lexeme (current char)
                    if (!verif.isSpace(chars[c])){
                        char currentLexeme = chars[c];
//                        tokensList.add(String.valueOf(currentLexeme));
                    }

                    start = c+1; // if character is space ou another token, set the initial pointer to the next character
                }
            }
        }
        System.out.println(symbolTable);
        for (Token token: tokensList){
            System.out.println(token.toString());
        }
//        System.out.println(tokensList);
    }

    private void buildToken(String lexeme){

    }

}
