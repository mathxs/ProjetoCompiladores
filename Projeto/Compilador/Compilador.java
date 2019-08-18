public class Compilador {

    public static void main(String[] args) {
        try{
            MeuLexer lexer = new MeuLexer(System.in);
            MeuParser parser = new MeuParser(lexer);
            parser.begi();
        }
        catch(Exception ex){
            System.out.println("Erro");
            ex.printStackTrace();
        }
    }

}