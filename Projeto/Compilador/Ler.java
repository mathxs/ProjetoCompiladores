public class Ler extends Comando
{
	private String _ler;
	private String _resutlado;

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

	public void SetResultado(String temp){
		_resutlado = _ler + temp;
	}

	public String toJava()
	{
		return _resutlado;
	}

}