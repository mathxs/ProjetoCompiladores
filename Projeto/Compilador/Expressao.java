import java.io.*;
import java.nio.*;
import java.util.*;

public class Expressao extends Programa
{

	public void toFile()
	{
		//inativando este metodo do programa, nao quero que esta classe escreva no arquivo
	}


	public String toString()
	{
		String expressaoEncapsulada = "";
		//expressaoEncapsulada += comandos.get(0).toJavaInicial();

		for (Comando cmd : comandos)
		{
			expressaoEncapsulada += "\t\t" + cmd.toJava();
		}

		//expressaoEncapsulada += comandos.get(0).toJavaFinal();
		return expressaoEncapsulada;
	}
}