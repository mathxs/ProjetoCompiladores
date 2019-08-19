public class Atribuicao extends Comando
{
	private String _atribuido;
	private String _valor;
	private String _sinal = "";

	public Atribuicao(String id)
	{
		_atribuido = id;
	}

	public void setValor(String valor)
	{
		_valor = valor;
	}

	public String getAtribuido()
	{
		return _atribuido;
	}

	public void setSinal(String sinal)
	{	
		if (sinal.equals("-") || sinal.equals("+"))
		{
			_sinal = sinal;
		}else
		{
			_sinal = "";
		}
		
	}

	public String getSinal()
	{
		return _sinal;
	}

	public ComandoTipo getTipo()
	{
		return ComandoTipo.Atribuicao;
	}

	public String toJava()
	{
		return _atribuido + " = " + _sinal + "" + _valor + ";\n";
	}
}