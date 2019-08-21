public class Atribuicao extends Comando
{
	private String _atribuido = "";
	private String _valor = "";
	private String _sinal = "";
	private String _resultado = "";

	public Atribuicao(String id)
	{
		_atribuido = id;
	}

	public Atribuicao()
	{

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
		if (sinal.equals("-") || sinal.equals("+") || sinal.equals("*") || sinal.equals("/"))
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
		return _atribuido + " = " + _resultado + ";\n";
	}

	public String getTipoValido()
	{
		if (_resultado.contains("."))
		{
			return "double";
		}
		else
		{
			return "int";
		}
	}	

	public void juntar()
	{
		_valor = _sinal + _valor;
		_resultado = _resultado + _valor;
	}
}