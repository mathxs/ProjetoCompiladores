public class NomePrograma
{
	public static void main(String[] args)
	{
		java.util.Scanner scanner_0 = new java.util.Scanner(System.in);
		
		double aluno1;

		aluno1 = 0;
		
		while ( 1 == 1 ){

		System.out.println("Nota");
		if(scanner_0.hasNextInt()){aluno1 = scanner_0.nextInt();}
		else if (scanner_0.hasNextDouble()){aluno1 = scanner_0.nextDouble();}
		
		if ( aluno1 < 5 ){

		System.out.println("Reprovado");
		
		}
		else{

		System.out.println("Aprovado");
		
		}
		
		}

	}
}