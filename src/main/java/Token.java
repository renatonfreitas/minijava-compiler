public class Token {

    private String name;
    private String attribute;
    private int attributeId;

    public Token(String name, String attribute) {
        this.name = name;
        this.attribute = attribute;
        this.attributeId = -1;
    }

    public Token(String name){
        this.name = name;
        this.attributeId = -1;
    }

    public Token(String name, int attributeId){
        this.name = name;
        this.attributeId = attributeId;
    }

    @Override
    public String toString() {
        return "Token{" +
                "name='" + name + '\'' +
                ", attribute='" + attribute + '\'' +
                ", attributeId=" + attributeId +
                '}';
    }
}
