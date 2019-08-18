public class Atribuicao extends Comando
{
	private String _atribuido;
	private String _valor;

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

	public ComandoTipo getTipo()
	{
		return ComandoTipo.Atribuicao;
	}

	public String toJava()
	{
		return _atribuido + " = " + _valor + ";\n";
	}
}