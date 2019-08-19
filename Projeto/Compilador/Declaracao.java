class Declaracao
{
	private String _tipo;
	private String _nome;

	Declaracao()
	{

	}

	Declaracao(String tipo)
	{
		if (tipo.equals("_int"))
		{
			_tipo = "int";
		}
		else if (tipo.equals("_dec"))
		{
			_tipo = "double";
		}
		else 
		{
			throw new RuntimeException("Tipo de variável não suportada " + tipo);
		}
	}

	public String getNome()
	{
		return _nome;
	}

	public void setNome(String nome)
	{
		_nome = nome;	
	}

	public String toJava()
	{
		return _tipo + " " + _nome + ";\n";
	}
}