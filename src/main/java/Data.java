import java.util.ArrayList;

public class Data {

    private ArrayList<Token> tokenList = new ArrayList<Token>();
    private ArrayList<String> symbolTable = new ArrayList<String>();

    public Data(ArrayList<Token> tokenList, ArrayList<String> symbolTable) {
        this.tokenList = tokenList;
        this.symbolTable = symbolTable;
    }

    public ArrayList<Token> getTokenList() {
        return tokenList;
    }

    public ArrayList<String> getSymbolTable() {
        return symbolTable;
    }

    public void addToTokenList(Token token) {
        this.tokenList.add(token);
    }

    public void addToSymbolTable(String lexeme) {
        this.symbolTable.add(lexeme);
    }
}
