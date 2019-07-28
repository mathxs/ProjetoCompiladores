class MeuParser extends Parser;
{
    System.out.printl("Parse está compilando");
}

expr        :   expr_C T_EOF
            ;

expr_C      :   T_mais
            ;



class MeuLexer extends Lexer;
{
    System.out.printl("Lexer está compilando");
}

T_EOF       :   ';'
            ;

T_mais      :   '+'
            ;