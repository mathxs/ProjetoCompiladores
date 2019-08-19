public class Escrever extends Comando
{
	private String _escrita;

	public Escrever(String escrita)
	{
		_escrita = escrita;
	}

	public void setEscrita(String escrita)
	{
		_escrita = escrita;
	}

	public String getEscrita()
	{
		return _escrita;
	}

	public ComandoTipo getTipo()
	{
		return ComandoTipo.Escrever;
	}

	public String toJava()
	{
		return "System.out.println(" + _escrita + ");\n";
	}
}