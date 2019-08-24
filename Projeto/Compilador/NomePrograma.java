public class NomePrograma
{
	public static void main(String[] args)
	{
		java.util.Scanner scanner_0 = new java.util.Scanner(System.in);
		
		double resultado;
		double numero;

		resultado = 1;
		System.out.println("Fatorial3");
		numero = scanner_0.nextDouble();
		System.out.println("Numero");
		
		do {

		resultado = resultado*numero;
		numero = numero-1;
		

		}while( numero >= 1);

		System.out.println(resultado);
	}
}