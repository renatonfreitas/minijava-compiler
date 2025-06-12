import java.util.ArrayList;

public class Lexer {

    public void readLexeme(String input) {
        LexerUtils utils = new LexerUtils();
        ArrayList<Token> tokensList = new ArrayList<Token>();
        ArrayList<String> symbolTable = new ArrayList<String>();

        String[] lines = input.split("\n"); // store each line of the code as an element
        for (int i = 0; i < lines.length; i++){ // format each line removing unnecessary spaces
            lines[i] = lines[i].strip();
        }

        for (int l = 0; l < lines.length; l++){ // iterating each line of the code
            char[] chars = lines[l].toCharArray(); // convert the current line into a char array
            int startLexeme = 0;
            int endLexeme = 0;

            for (int c = 0; c < chars.length; c++) { // for each character of the line
                endLexeme = c;
                char currentChar = chars[c];

                if (!utils.isLetter(currentChar) && !utils.isDigit(currentChar)){ // the current char is a non identifier

                    // build the previous lexeme (startLexeme untiel previous char)
                    // if a non digit or letter folow another non digit ou letter, the startLexeme and endLexeme pointers will be the same
                    if (startLexeme != endLexeme){

                        if (!utils.isDoubleSymbol(currentChar) || ((utils.isLetter(chars[c-1]) && utils.isDoubleSymbol(currentChar)))){
                            String buildingLexeme = lines[l].substring(startLexeme, endLexeme); // startLexeme is inclusive and endLexeme is exclusive
                            String name; // stores the name of token

                            if (!utils.startsWithNumeric(buildingLexeme) && utils.isLetter(buildingLexeme.charAt(0))){ // if it does not start with a number it will be an identifier
                                name = TokenNames.IDENTIFIER.name();

                                if (!utils.isReservedWord(buildingLexeme)){
                                    if (!symbolTable.contains(buildingLexeme)){
                                        symbolTable.add(buildingLexeme);
                                    }
                                    Token tokenIdentifier = new Token(name, symbolTable.indexOf(buildingLexeme));
                                    tokensList.add(tokenIdentifier);

                                } else {
                                    name = buildingLexeme.toUpperCase();
                                    Token tokenReservedWord = new Token(name);
                                    tokensList.add(tokenReservedWord);
                                }
                            } else { // if it starts with a number it can be either an int literal or a token with bad formation

                                if (utils.isIntLiteral(buildingLexeme)){
                                    name = TokenNames.INTLITERAL.name();
                                    Token tokenIntLiteral = new Token(name, buildingLexeme);
                                    tokensList.add(tokenIntLiteral);
                                } else if (utils.isNonIdentifier(buildingLexeme)) {
                                    name = utils.getName(buildingLexeme);
                                    Token tokenNonIdentifier = new Token(name, buildingLexeme);
                                    tokensList.add(tokenNonIdentifier);
                                } else {
                                    // TODO save the line of bad tokens
                                    name = TokenNames.ERROR.name();
                                    throw new LexicalErrorException("Lexical error at line " + (l+1) + ": \"" + buildingLexeme + "\"");
                                }
                            }
                        }

                    }

                    if (utils.isSpace(currentChar)){
                        startLexeme = c+1;
                        continue;

                    } else {
                        if (!utils.isDoubleSymbol(currentChar) || ((utils.isLetter(chars[c-1]) && utils.isDoubleSymbol(currentChar)))){
                            startLexeme = c;
                        }

                        if (c == (chars.length-1) && utils.isEndSymbol(currentChar)){
                            String endLine = lines[l].substring(startLexeme, endLexeme+1);
                            String name = utils.getName(endLine);
                            Token tokenEndLine = new Token(name, endLine);
                            tokensList.add(tokenEndLine);

                        }
                    }

                } else {
                    // cover a letter or digit immediately after a non letter and digit
                    if (((endLexeme - startLexeme) > 0) && !utils.isDigit(chars[startLexeme]) && !utils.isLetter(chars[startLexeme])){
                        String previousLexeme = lines[l].substring(startLexeme, endLexeme);
                        String name = utils.getName(previousLexeme);
                        Token tokenNonIdentifier = new Token(name, previousLexeme);
                        tokensList.add(tokenNonIdentifier);

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
        System.out.println(symbolTable);
        for (Token token: tokensList){
            System.out.println(token.toString());
        }
//        System.out.println(tokensList);
    }

    private void buildToken(String lexeme){

    }

}
