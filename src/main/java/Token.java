public class Token {

    private String name;
    private String attribute;
    private int attributeId;
    private int line;

    public Token(String name, String attribute) {
        this.name = name;
        this.attribute = attribute;
    }

    public Token(String name){
        this.name = name;
    }

    public Token(String name, int attribute){
        this.name = name;
        this.attributeId = attribute;
    }

    @Override
    public String toString() {
        return "Token{" +
                "name='" + name + '\'' +
                ", attribute='" + attribute + '\'' +
                ", attributeId=" + attributeId +
                ", line=" + line +
                '}';
    }
}
