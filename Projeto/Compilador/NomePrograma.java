public class NomePrograma
{
	public static void main(String[] args)
	{
		java.util.Scanner scanner_0 = new java.util.Scanner(System.in);
		
		double valor;
		double numero;
		double elevado;

		valor = 0;
		System.out.println("Numero");
		numero = scanner_0.nextDouble();		System.out.println("Elevado");
		elevado = scanner_0.nextDouble();		
		do {

		valor = numero*numero;
		elevado = elevado-1;
		

		}while( elevado < 1);

		System.out.println(valor);
	}
}