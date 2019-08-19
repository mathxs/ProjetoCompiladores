// $ANTLR 2.7.6 (2005-12-22): "gramatica.g" -> "MeuParser.java"$

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class MeuParser extends antlr.LLkParser       implements MeuParserTokenTypes
 {

	Programa prog;

	Declaracao declaracao;
	Atribuicao atribuicao;

	//Expressao expressao;

protected MeuParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public MeuParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected MeuParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public MeuParser(TokenStream lexer) {
  this(lexer,1);
}

public MeuParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final void begi() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(T_inicio);
			match(T_id);
			
							prog = new Programa(LT(0).getText());
						
			{
			_loop3:
			do {
				if ((LA(1)==T_decl)) {
					decl();
				}
				else {
					break _loop3;
				}
				
			} while (true);
			}
			{
			_loop5:
			do {
				if ((_tokenSet_0.member(LA(1)))) {
					body();
				}
				else {
					break _loop5;
				}
				
			} while (true);
			}
			match(T_fim);
			
							prog.toFile();
						
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
	}
	
	public final void decl() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(T_decl);
			
							declaracao = new Declaracao(LT(0).getText());
						
			match(T_id);
			
							declaracao.setNome(LT(0).getText());
							prog.addVariavel(declaracao);
						
			match(T_eol);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
	}
	
	public final void body() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case T_id:
			case T_leia:
			case T_escr:
			{
				cmd();
				break;
			}
			case T_se:
			{
				cond();
				break;
			}
			case T_enqu:
			{
				whle();
				break;
			}
			case T_do:
			{
				do_w();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void attr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(T_id);
			
							atribuicao = new Atribuicao(LT(0).getText());
							//System.out.println("ID:" + LT(0).getText());
						
			match(T_attr);
			expr_c();
			
							atribuicao.setValor(LT(0).getText());
					 		prog.addComando(atribuicao);
							System.out.println("expr_c: " + LT(0).getText());
			
					 	
			match(T_eol);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void expr_c() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			termo();
			{
			_loop29:
			do {
				if ((LA(1)==T_plus||LA(1)==T_minus)) {
					{
					switch ( LA(1)) {
					case T_plus:
					{
						match(T_plus);
						break;
					}
					case T_minus:
					{
						match(T_minus);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					termo();
				}
				else {
					break _loop29;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
	}
	
	public final void cmd() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case T_leia:
			{
				cmd_l();
				break;
			}
			case T_escr:
			{
				cmd_w();
				break;
			}
			case T_id:
			{
				attr();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void cond() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(T_se);
			match(T_ap);
			expr_b();
			match(T_fp);
			match(T_ac);
			{
			_loop14:
			do {
				if ((LA(1)==T_id||LA(1)==T_leia||LA(1)==T_escr)) {
					cmd();
				}
				else {
					break _loop14;
				}
				
			} while (true);
			}
			match(T_fc);
			{
			switch ( LA(1)) {
			case T_senao:
			{
				match(T_senao);
				match(T_ac);
				{
				_loop17:
				do {
					if ((LA(1)==T_id||LA(1)==T_leia||LA(1)==T_escr)) {
						cmd();
					}
					else {
						break _loop17;
					}
					
				} while (true);
				}
				match(T_fc);
				break;
			}
			case T_id:
			case T_fim:
			case T_leia:
			case T_escr:
			case T_se:
			case T_enqu:
			case T_do:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void whle() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(T_enqu);
			match(T_ap);
			expr_b();
			match(T_fp);
			match(T_ac);
			{
			_loop20:
			do {
				if ((LA(1)==T_id||LA(1)==T_leia||LA(1)==T_escr)) {
					cmd();
				}
				else {
					break _loop20;
				}
				
			} while (true);
			}
			match(T_fc);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void do_w() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(T_do);
			match(T_ac);
			{
			_loop23:
			do {
				if ((LA(1)==T_id||LA(1)==T_leia||LA(1)==T_escr)) {
					cmd();
				}
				else {
					break _loop23;
				}
				
			} while (true);
			}
			match(T_fc);
			match(T_enqu);
			match(T_ap);
			expr_b();
			match(T_fp);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void cmd_l() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(T_leia);
			match(T_ap);
			match(T_id);
			match(T_fp);
			match(T_eol);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void cmd_w() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(T_escr);
			match(T_ap);
			match(T_id);
			match(T_fp);
			match(T_eol);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void expr_b() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			expr_c();
			match(T_bool);
			expr_c();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_6);
		}
	}
	
	public final void expr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			expr_c();
			match(T_eol);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
	}
	
	public final void termo() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			fator();
			{
			_loop33:
			do {
				if ((LA(1)==T_times||LA(1)==T_divi)) {
					{
					switch ( LA(1)) {
					case T_times:
					{
						match(T_times);
						break;
					}
					case T_divi:
					{
						match(T_divi);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					fator();
				}
				else {
					break _loop33;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
	}
	
	public final void fator() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case T_id:
			case T_minus:
			case T_pls:
			case T_num:
			{
				valor();
				break;
			}
			case T_ap:
			{
				match(T_ap);
				expr_c();
				match(T_fp);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_8);
		}
	}
	
	public final void valor() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case T_minus:
			{
				match(T_minus);
				break;
			}
			case T_pls:
			{
				match(T_pls);
				break;
			}
			case T_id:
			case T_num:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
				
							atribuicao.setSinal(LT(0).getText());	
							System.out.println("sinal: " + LT(0).getText());						
						
			{
			switch ( LA(1)) {
			case T_id:
			{
				match(T_id);
				break;
			}
			case T_num:
			{
				match(T_num);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_8);
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"T_inicio",
		"T_id",
		"T_fim",
		"T_decl",
		"T_eol",
		"T_attr",
		"T_leia",
		"T_ap",
		"T_fp",
		"T_escr",
		"T_se",
		"T_ac",
		"T_fc",
		"T_senao",
		"T_enqu",
		"T_do",
		"T_bool",
		"T_plus",
		"T_minus",
		"T_times",
		"T_divi",
		"T_pls",
		"T_num",
		"T_blank"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 812064L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 812256L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 812128L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 877664L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 1052928L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 4096L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 7344384L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 32510208L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	
	}
