public abstract class Comando
{
	public abstract String toJava();

	public abstract ComandoTipo getTipo();

	public enum ComandoTipo
	{
		Atribuicao,
		Condicional,
		While,
		DoWhile,
		Ler,
		Escrever
	}
}