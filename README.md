# Analisador Léxico

---

## Visão geral

O analisador léxico lê os caracteres do código-fonte ao mesmo tempo que agrupa caracteres em lexemas e os categoriza
como tokens de acordo com suas categorias.

### `Lexer`

A classe `Lexer` representa o analisador Léxico do compilador e possui um único método implementado chamado `readLexeme()`.
O método recebe uma `String` como argumento representando o código-fonte e não possui um retorno.

O objetivo de `readLexeme()` é identificar os tokens do código-fonte.

`readLexeme()` realiza a **leitura em linha** e armazena:

1. os tokens reconhecidos na lista de tokens, representada como um `ArrayList<Token>` chamado `tokenList`.
2. os identificadores na tabela de símbolos, representada como um `ArrayList<String>` chamado `symbolTable`.
3. a lista de tokens e a tabela de símbolos no objeto `Data`.

Quando `readLexeme()` encontra um token mal formado ele para a execução do programa e lança uma exceção `LexicalErrorException`
informando do erro e a linha do lexema mal formado.

### `Data`
A classe modelo `Data` recebe a lista de tokens e a tabela de símbolos e as define como atributos para disponibilizar
essas duas estruturas de dados para as outras etapas da análise.

### `Token`
A classe modelo `Token` representa os tokens encontrados durante a leitura do código.

Na teoria, um token é representado por um nome e um atributo. O nome representa o tipo do token e o atributo pode ser o
próprio lexema, a posição do lexema na tabela de símbolos, caso seja um identificador, e até mesmo não ter um atributo,
em caso de palavra reservada.

Para representar os componentes de um token foram definidos três atributos: `name`, `attribute` e `attributeID` que
representam, respectivamente, o nome, o atributo e a posição na tabela de símbolos. Também foram definidos três
construtores: um para identificadores que recebe o nome e a posição na tabela de símbolos, um para palavras reservadas
que recebe apenas o nome e um para o restante dos tokens possíveis que recebe um nome e o atributo.

### `LexerUtils`
A classe `Lexer` utiliza métodos auxiliares para verificações definidos na classe `LexerUtils`.

### `ReservedWords`
As palavras reservadas foram definidas como constantes em um Enum chamado `ReservedWords`.

### `TokenNames`
Os nomes possíveis dos tokens forma definidos como constantes em um `Enum` chamado `TokenNames`.

### `LexicalErrorException`
`Exception` lançada quando um lexeme mal formado é encontrado na leitura do código. Um lexema é mal formado quando o primeiro
símbolo é um número e é seguido por letras.

### `LexerTest`
É a classe destinada para o teste do analisador léxico.

--- 

## Lógica

O `Lexer` divide o código em linhas e percorre o caractere de cada uma utilizando de ponteiros para identificar lexemas.

À medida que ele percorre os caracteres ele verifica se o caractere atual é uma letra ou número, se não for ele salva o lexema construído até então, se não estiver vazio, e gera seu token, verificando se é uma palavra reservada ou simplesmente
um identificador.

Quando uma letra/número/outro segue um não identificador (não é letra e nem numero), o lexema anterior é salvo e gerado o
token dele.

Lexemas que possuem mais de um caractere ("&&", por exemplo) possuem condições especificas para seu reconhecimento.  
Lexemas que finalizam uma linha também possuem condições específicas para seu reconhecimento.

Espaços em branco são ignorados na identificação de lexemas, mas possuem seu papel na movimentação dos ponteiros.

O `Lexer` também consegue realizar a identificação de lexemas mesmo quando alguns caracteres não possuem espaço entre si.

--- 

## Observações

- Nem todos os tokens estão representados no estado atual do projeto.
- O caso do `.length` não foi considerado ainda e pode ter comportamentos inesperados no estado atual no projeto
- `System.out.print` é uma palavra reservada no MiniJava, mas no estado atual do projeto ele é representado pelo lexema `Print`
- O caso de comentários e caracteres unicode ainda não foram considerados.

---

## Exemplos de códigos livres de comportamentos inesperados

```java
class Test {
    public static void main(String[] args) {
        int x = 42;
        if (x < 100) {
            Print(x);
        }
    }
}
```

```java
class Test {
    public static void main(String[] args) {
        int x;
        boolean y = true;
        boolean z = true;
        if (x && y) {
            x = 42;
        }
    }
}
```

```java
class Test {
    public static void main(String[] args) {
        int x = 42;
        if (x < 100) {
            x = x + 1;
        }
    }
}
```