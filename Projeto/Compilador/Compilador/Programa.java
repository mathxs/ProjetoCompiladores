import java.io.*;
import java.nio.*;
import java.util.*;

public class Programa
{
	public final String INPUT = "scanner_0";
	private String _nome;

	List<Declaracao> declaracoes = new ArrayList<Declaracao>();

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

	public void ToFile()
	{

		try (BufferedWriter fs = new BufferedWriter(new FileWriter(_nome + ".java")))
		{
			fs.write("public class " + _nome + "\n{\n");
			fs.write("\tpublic static void main(String[] args)\n\t{\n");

			for(Declaracao decl : declaracoes)
			{
				fs.write("\t\t" + decl.ToJava());
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