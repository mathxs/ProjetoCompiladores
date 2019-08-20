public class Condicional extends Comando
{
	private String _condicao;
	private int _caso;

	public Condicional(String condicao, int caso)
	{
		_condicao = condicao;
		_caso = caso;
	}

	public Condicional(int caso)
	{
		_caso = caso;
	}

	public void setLeitura(String condicao)
	{
		_condicao = condicao;
	}

	public String getLeitura()
	{
		return _condicao;
	}

	public ComandoTipo getTipo()
	{
		return ComandoTipo.Condicional;
	}

	public String toJava()
	{
		if (_caso == 1){
			return "\n\t\tif ( "+ _condicao + " ){\n\n";
		}else if(_caso == 2){
			return toJavaFinal();
		}else if (_caso == 3){
			return "else{\n\n";
		}else{
			return "Ocorreu problema no DoWhile";
		}
	}

	public String toJavaFinal()
	{
		return "\n\t\t}\n";
	}
}