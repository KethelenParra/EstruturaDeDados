
public class AtividadeRecursividade {

	public int soma(int n) {
		if(n <= 1) return 1;
		else {
			return n + soma(n - 1);
		}
	}
	public static void main(String[] args) {
		AtividadeRecursividade r = new AtividadeRecursividade();
		
		int resultSoma = r.soma(5);
		System.out.println("Soma: " + resultSoma);
	}

}
