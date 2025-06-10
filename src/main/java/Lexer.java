import java.util.ArrayList;

public class Lexer {

    public void readLexeme(String input) {
        ArrayList<String> tokens = new ArrayList<String>();

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

                if (!isLetterOrDigit(chars[c])){

                    // build the previous lexeme (start untiel previous char)
                    // if a non digit or letter folow another non digit ou letter, the start and end pointers will be the same
                    if (start != end){
                        String buildingLexeme = lines[l].substring(start,end); // start is inclusive and end is exclusive
                        tokens.add(buildingLexeme);
                    }

                    // build the current lexeme (current char)
                    if (!isSpace(chars[c])){
                        char currentLexeme = chars[c];
                        tokens.add(String.valueOf(currentLexeme));
                    }

                    start = c+1; // if character is space ou another token, set the initial pointer to the next character
                }
            }
        }
        System.out.println(tokens);
    }

    public boolean isLetterOrDigit(char symbol){
        int[] ascii = {48,49,50,51,52,53,54,55,56,57,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,
        87,88,89,90,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122};

        for (int a: ascii){
            if ((int) symbol == a){
                return true;
            }
        }
        return false;
    }

    public boolean isSpace(char symbol){
        return ((int) symbol) == 32;
    }

    private void isReservedWord(String identifier){

    }

    private void buildToken(String lexeme){

    }

}
