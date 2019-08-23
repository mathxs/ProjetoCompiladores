public class NomePrograma
{
	public static void main(String[] args)
	{
		java.util.Scanner scanner_0 = new java.util.Scanner(System.in);
		
		double aluno1;
		double aluno2;
		double media;

		aluno1 = scanner_0.nextInt();
		aluno2 = scanner_0.nextInt();
		media = aluno1+aluno2;
		media = media/2;
		System.out.println(media);
	}
}