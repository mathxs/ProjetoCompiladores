import java.io.*;
import java.nio.*;
import java.util.*;

public class Programa
{
	public final String INPUT = "scanner_0";
	private String _nome;

	List<Declaracao> declaracoes = new ArrayList<Declaracao>();
	List<Comando> comandos = new ArrayList<Comando>();

	Programa()
	{
		_nome = "NotSet";
	}

	Programa(String nome)
	{
		_nome = nome;
	}

	public void addVariavel(Declaracao decl)
	{
		declaracoes.add(decl);
	}

	public void addComando(Comando cmd)
	{
		if (cmd.getTipo() == Comando.ComandoTipo.Atribuicao)
		{
			String atribuido = ((Atribuicao)cmd).getAtribuido();
			boolean existe = false;

			for (Declaracao decl : declaracoes)
			{
				if (decl.getNome().equals(atribuido))
				{
					existe = true;
					break;
				}
			}

			if (!existe)
			{
				throw new RuntimeException("Variável não declarada " + ((Atribuicao)cmd).getAtribuido());
			}
		}
		comandos.add(cmd);
	}

	public void toFile()
	{

		try (BufferedWriter fs = new BufferedWriter(new FileWriter(_nome + ".java")))
		{
			fs.write("public class " + _nome + "\n{\n");
			fs.write("\tpublic static void main(String[] args)\n\t{\n");
			fs.write("\t\tjava.util.Scanner " + INPUT + " = new java.util.Scanner(System.in);\n");
			fs.write("\t\t\n");

			for (Declaracao decl : declaracoes)
			{
				fs.write("\t\t" + decl.toJava());
			}

			for (Comando cmd : comandos)
			{
				fs.write("\t\t" + cmd.toJava());
			}

			fs.write("\t}\n}");
			fs.flush();
			fs.close();
		}
		catch (Exception ex)
		{
			System.err.println("Erro");
			ex.printStackTrace();
		}
	}
}