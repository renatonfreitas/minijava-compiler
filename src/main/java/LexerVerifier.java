public class LexerVerifier {

    public boolean isSpace(char symbol){
        return ((int) symbol == 32);
    }

    public boolean isAlphanumeric(char symbol){
        return ((int) symbol >= 48 && (int) symbol <= 57) || // digit
                ((int) symbol >= 65 && (int) symbol <= 90) || // upper case
                ((int) symbol >= 97 && (int) symbol <= 122); // lower case
    }

    public boolean isUnderscore(char symbol){
        return ((int) symbol == 95);
    }

    public boolean isReservedWord(String lexeme){
        for (ReservedWordsEnum reserved: ReservedWordsEnum.values()){
            if (reserved.name().equalsIgnoreCase(lexeme)){
                return true;
            }
        }
        return false;
    }

}
