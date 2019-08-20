public class Ler extends Comando
{
	private String _ler;

	public Ler(String ler)
	{
		_ler = ler;
	}

	public void setLeitura(String ler)
	{
		_ler = ler;
	}

	public String getLeitura()
	{
		return _ler;
	}

	public ComandoTipo getTipo()
	{
		return ComandoTipo.Ler;
	}

	public String toJava()
	{
		return _ler + " = scanner_0.nextInt();\n";
	}

}