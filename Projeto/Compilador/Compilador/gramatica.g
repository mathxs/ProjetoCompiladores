class MeuParser extends Parser;
{
	Programa prog;

	Declaracao declaracao;
	Atribuicao atribuicao;

	//Expressao expressao;
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
				atribuicao.setValor("10");
		 		prog.addComando(atribuicao);
		 	}
		 	T_eol
		;

body	: cmd | cond | whle | do_w
		;

cmd		: cmd_l | cmd_w | attr
		;

cmd_l	: T_leia T_ap T_id T_fp T_eol
		;

cmd_w	: T_escr T_ap T_id T_fp T_eol
		;

cond 	:  T_se T_ap expr_b T_fp T_ac (cmd)* T_fc (T_senao T_ac (cmd)* T_fc)?
		;

whle 	: T_enqu T_ap expr_b T_fp T_ac (cmd)* T_fc
		;

do_w	: T_do T_ac (cmd)* T_fc T_enqu T_ap expr_b T_fp
		;

expr_b	: expr_c T_bool expr_c
		;

expr 	: expr_c T_eol
        ;

expr_c  : termo ((T_plus  | T_minus) termo)* 
		;
		
termo	: fator ((T_times | T_divi) fator)*
		;
		
fator	: valor | T_ap expr_c T_fp
		;

valor 	: (T_minus | T_pls)? (T_id| T_num)
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