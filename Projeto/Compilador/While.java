public class While extends Comando
{
	private String _loop;
	private int _caso;

	public While(String loop, int caso)
	{
		_loop = loop;
		_caso = caso;
	}

	public While( int caso)
	{
		_caso = caso;
	}

	public void setLoop(String loop)
	{
		_loop = loop;
	}

	public String getLoop()
	{
		return _loop;
	}

	public ComandoTipo getTipo()
	{
		return ComandoTipo.While;
	}

	public String toJava()
	{
		if (_caso == 1){
			return "\n\t\twhile ( "+ _loop + " ){\n\n";
		}else if(_caso == 2){
			return toJavaFinal();
		}else{
			return "Ocorreu problema no While";
		}
	}

	public String toJavaFinal()
	{
		return "\n\t\t}\n\n";
	}

}