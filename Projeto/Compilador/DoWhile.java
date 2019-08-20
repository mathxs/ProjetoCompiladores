public class DoWhile extends Comando
{
	private String _doLoop;
	private int _caso;

	public DoWhile(String ler, int caso)
	{
		_doLoop = ler;
		_caso = caso;
	}

	public DoWhile( int caso)
	{
		_caso = caso;
	}

	public void setLeitura(String ler)
	{
		_doLoop = ler;
	}

	public String getLeitura()
	{
		return _doLoop;
	}

	public ComandoTipo getTipo()
	{
		return ComandoTipo.DoWhile;
	}

	public String toJava()
	{
		if (_caso == 2){
			return "\n\n\t\t}while( " + _doLoop + ");\n\n";
		}else if(_caso == 1){
			return toJavaInicial();
		}else{
			return "Ocorreu problema no DoWhile";
		}
	}

	public String toJavaInicial()
	{
		return "\n\t\tdo {\n\n";
	}

}