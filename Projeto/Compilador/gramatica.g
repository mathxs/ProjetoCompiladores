class MeuParser extends Parser;
{
	//Programa
	Programa prog;

	//Inicio
	Declaracao declaracao;// = new Declaracao();

	Atribuicao atribuicao;
	
	//comandos basicos
	Ler leitura;
	Escrever escrita;

	//comandos complexos
	While loop;
	DoWhile doLoop;
	Condicional condicional;

	//auxiliares para comandos complexos
	String ex1;
	String atri;
	String ex2;

}

begi	: 	T_inicio T_id
			{
				prog = new Programa(LT(0).getText());
			}
			(decl)* (body)*
			T_fim
			{
				prog.toFile();
			}
		; 

decl	:	T_decl
			{
				declaracao = new Declaracao(LT(0).getText());
				//declaracao.setTipo(LT(0).getText());
			}
			T_id
			{
				declaracao.setNome(LT(0).getText());
				prog.addVariavel(declaracao);
			}
			T_eol
		;

attr	:	T_id
			{
				atribuicao = new Atribuicao(LT(0).getText());
			}
		 	T_attr expr_c
		 	{
				//atribuicao.setValor(LT(0).getText());
				//atribuicao.juntar();				
		 		prog.addComando(atribuicao);
				atribuicao = new Atribuicao();

		 	}
		 	T_eol
		;

body	: cmd | cond | whle | do_w
		;

cmd		: cmd_l | cmd_w | attr
		;

cmd_l	: 	T_leia T_ap T_id
			{
				leitura = new Ler(LT(0).getText());
				prog.addComando(leitura);
			}
			T_fp T_eol
		;

cmd_w	: 	T_escr T_ap T_id
			{
				escrita = new Escrever(LT(0).getText());
				prog.addComando(escrita);
			}
			T_fp T_eol
		;

cond 	:  	T_se T_ap expr_b
			{
				condicional = new Condicional(ex1 + " " + atri + " " + ex2,1);
				prog.addComando(condicional);
			}
			T_fp T_ac (cmd)* 
			{
				condicional = new Condicional(2);
				prog.addComando(condicional);
			} 
			T_fc (T_senao
			{
				condicional = new Condicional(3);
				prog.addComando(condicional);
			}
			T_ac (cmd)*
			{
				condicional = new Condicional(2);
				prog.addComando(condicional);
			}
			T_fc)?
		;

whle 	: 	T_enqu T_ap expr_b
			{
				loop = new While(ex1 + " " + atri + " " + ex2,1);
				prog.addComando(loop);
 			}
			T_fp T_ac (cmd)* 
			{
				loop = new While(2);
				prog.addComando(loop);
 			}
			T_fc
		;

do_w	: 	T_do
			{
				doLoop = new DoWhile(1);
				prog.addComando(doLoop);
			}
			T_ac (cmd)* T_fc T_enqu T_ap expr_b
			{
				doLoop = new DoWhile(ex1 + " " + atri + " " + ex2,2);
				prog.addComando(doLoop);
			} 
			T_fp
		;

expr_b	: 	expr_c
			{
				ex1 = LT(0).getText();
			}
			T_bool
			{
				atri = LT(0).getText();
			}
			expr_c
			{
				ex2 = LT(0).getText();
			}
		;

expr 	: expr_c T_eol
        ;

expr_c  : 	termo	((T_plus  | T_minus)
			{	
				atribuicao.setSinal(LT(0).getText());
				//System.out.println("sinal: " + LT(0).getText());						
			}
			termo)*
				
		;
		
termo	: fator	((T_times | T_divi)
			{	
				atribuicao.setSinal(LT(0).getText());
				//System.out.println("sinal: " + LT(0).getText());						
			}
			fator)*
		;
		
fator	: 	valor
			{
				atribuicao.setValor(LT(0).getText());
				declaracao.setValor(LT(0).getText());
				atribuicao.juntar();
 			}
			| T_ap expr_c T_fp
		;

valor 	: 	(T_minus | T_pls)?
			{	
				atribuicao.setSinal(LT(0).getText());
				//System.out.println("sinal: " + LT(0).getText());						
			}
			(T_id| T_num)
		;


class MeuLexer extends Lexer;
options
{
	k = 6;
}

T_id    : ('a'..'z'|'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9')*
		;		

T_num	: ('0'..'9')+ ('.' ('0'..'9')+)?
		;

T_plus  : '+'
		;
		
T_minus : '-'
		;
		
T_times : '*'
		;
		
T_divi  : '/'
		;

T_bool	: "==" | "!=" | '>' | '<' | ">=" | "<="
		;

T_attr	: ":="
		;

T_ap	: '('
		;
		
T_eol   : ';'
		;
		
T_fp	: ')'
		;

T_ac	: '{'
		;

T_fc	: '}'
		;

T_inicio : "_progInicio"
		;

T_fim 	: "_progFim"
		;

T_decl	: "_int" | "_dec"
		;

T_leia	: "_leia"
		;

T_escr	: "_escreva"
		;

T_se 	: "_se"
		;

T_senao	: "_senao"
		;

T_enqu	: "_enquanto"
		;

T_do	: "_faca"
		;

T_blank	: (' ' | '\n' {newline();} | '\r' | '\t' ) {_ttype=Token.SKIP;}
		;