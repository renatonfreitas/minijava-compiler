public class LexerUtils {

    public boolean isSpace(char symbol){
        return ((int) symbol == 32);
    }

    public boolean isAlphanumeric(char symbol){
        return ((int) symbol >= 48 && (int) symbol <= 57) || // digit
                ((int) symbol >= 65 && (int) symbol <= 90) || // upper case
                ((int) symbol >= 97 && (int) symbol <= 122) || // lower case
                ((int) symbol == 95); // underscore
    }

    public boolean isDigit(char symbol) {
        return ((int) symbol >= 48 && (int) symbol <= 57);
    }

    public boolean isLetter(char symbol){
        return ((int) symbol >= 65 && (int) symbol <= 90) || // upper case
                ((int) symbol >= 97 && (int) symbol <= 122) || // lower case
                ((int) symbol == 95); // underscore
    }

    public boolean isReservedWord(String lexeme){
        for (ReservedWords reserved: ReservedWords.values()){
            if (reserved.name().equalsIgnoreCase(lexeme)){
                return true;
            }
        }
        return false;
    }

    public boolean startsWithNumeric(String lexeme){
        return isDigit(lexeme.charAt(0));
    }

    public boolean isIntLiteral(String lexeme){
        try {
            Integer.parseInt(lexeme);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getName(String identifier){
        String name;
        switch (identifier){
            case "class":
                name = ReservedWords.CLASS.name();
                break;
            case "extends":
                name = ReservedWords.EXTENDS.name();
                break;
            case "public":
                name = ReservedWords.PUBLIC.name();
                break;
            case "static":
                name = ReservedWords.STATIC.name();
                break;
            case "void":
                name = ReservedWords.VOID.name();
                break;
            case "main":
                name = ReservedWords.MAIN.name();
                break;
            case "String":
                name = ReservedWords.STRING.name();
                break;
            case "int":
                name = ReservedWords.INT.name();
                break;
            case "null":
                name = ReservedWords.NULL.name();
                break;
            case "this":
                name = ReservedWords.THIS.name();
                break;
            case "new":
                name = ReservedWords.NEW.name();
                break;
            case "return":
                name = ReservedWords.RETURN.name();
                break;
            case "if":
                name = ReservedWords.IF.name();
                break;
            case "else":
                name = ReservedWords.ELSE.name();
                break;
            case "while":
                name = ReservedWords.WHILE.name();
                break;
            case "Print": // SYSTEM.OUT.PRINT
                name = ReservedWords.PRINT.name();
                break;
            case "length":
                name = ReservedWords.LENGTH.name();
                break;
            case "true":
                name = ReservedWords.TRUE.name();
                break;
            case "false":
                name = ReservedWords.FALSE.name();
                break;
            case "(":
                name = TokenNames.LPAREN.name();
                break;
            case ")":
                name = TokenNames.RPAREN.name();
                break;
            case "[":
                name = TokenNames.LSQBRACKET.name();
                break;
            case "]":
                name = TokenNames.RSQBRACKET.name();
                break;
            case "{":
                name = TokenNames.LCUBRACKET.name();
                break;
            case "}":
                name = TokenNames.RCUBRACKET.name();
                break;
            case ";":
                name = TokenNames.SEMICOLON.name();
                break;
            case ",":
                name = TokenNames.COMMA.name();
                break;
            case ".":
                name = TokenNames.DOT.name();
                break;
            case "=":
                name = TokenNames.ASSIGN.name();
                break;
            case "<":
                name = TokenNames.LESS.name();
                break;
            case "+":
                name = TokenNames.PLUS.name();
                break;
            case "-":
                name = TokenNames.MINUS.name();
                break;
            case "*":
                name = TokenNames.TIMES.name();
                break;
            case "&&":
                name = TokenNames.AND.name();
                break;
            case "!":
                name = TokenNames.NOT.name();
                break;
            default:
                name = TokenNames.ERROR.name();
        }
        return name;
    }

    public boolean isDoubleSymbol(char symbol){
        return ((int) symbol == 38);
    }

    public boolean isEndSymbol(char symbol){
        return ((int) symbol == 59) ||
                ((int) symbol == 123) ||
                ((int) symbol == 125);
    }

    public boolean isNonIdentifier(String lexeme){
        return (lexeme.equals("(")) || (lexeme.equals(")")) ||
                (lexeme.equals("[")) || (lexeme.equals("]")) ||
                (lexeme.equals("{")) || (lexeme.equals("}")) ||
                (lexeme.equals(";")) || (lexeme.equals(",")) ||
                (lexeme.equals(".")) || (lexeme.equals("=")) ||
                (lexeme.equals("<")) || (lexeme.equals("+")) ||
                (lexeme.equals("-")) || (lexeme.equals("*")) ||
                (lexeme.equals("&&")) || (lexeme.equals("!"));
    }
}
