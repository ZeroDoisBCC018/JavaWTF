package Principal;

public class RolaDados {
	private int numDados;
	private Dado[] dados;
	
	// Define os dados que serão usados
	public RolaDados(int n) throws InterruptedException {
		this.numDados = n;
		this.dados = new Dado[numDados];
		
		// Instancia dados com diferentes sementes
		for(int i = 0; i < numDados; i++) {
			dados[i] = new Dado();
			dados[i].setSeed((int) System.currentTimeMillis());
			Thread.sleep(500);
		}
	}
	
	// Rola todos os dados
	public int[] rolar() {
		int[] rolagens = new int[numDados];
		
		for (int i = 0; i < numDados; i++) {
			rolagens[i] = dados[i].rolar();
		}
		
		return rolagens;
	}
	
	// Rola alguns dados com vetor booleano
	public int[] rolar(boolean[] quais) {
		int[] rolagens = new int[numDados];
		
		for (int i = 0; i < numDados; i++) {
			if(quais[i] == true) {
				this.dados[i].rolar();
			}
			rolagens[i] = this.dados[i].getLado();
		}
		
		return rolagens;
	}
	
	// Rola alguns dados de acordo com string dada
	public int[] rolar(String s) {
		int[] rolagens = new int[numDados];
		
		// Se não digitou nada, retorna os dados já rolados anteriormente
		if (s.length() == 0) {
			return getDados();
		}
		
		String[] numeros = s.split(" ");
		int[] numerosInteiro = new int[numeros.length];
		
		for(int i = 0; i < numeros.length; i++) {
			numerosInteiro[i] = Integer.valueOf(numeros[i]);
		}
		
		for (int i = 0; i < numDados; i++) {
			for(int j = 0; j < numerosInteiro.length; j++) {
				if(numerosInteiro[j] == i+1) {
					this.dados[i].rolar();
					break;
				}
			}
			
			rolagens[i] = this.dados[i].getLado();
		}
		
		return rolagens;
	}
	
	// Retorna rolagem antiga
	public int[] getDados() {
		int[] rolagens = new int[numDados];
		
		for (int i = 0; i < numDados; i++) {
			rolagens[i] = dados[i].getLado();
		}
		
		return rolagens;
	}
	
	// Exibe os dados
	@Override
	public String toString() {
		String resultado = "", aux = "";
		String[] aux2;
		
		for(int i = 0; i < numDados; i++) {
			resultado += i+1 + "\t\t";
			aux += this.dados[i].toString();
		}
		
		resultado += "\n";
		aux2 = aux.split("\n");
		aux = "";
		
		for(int i = 0; i < numDados; i++) {
			for(int j = i; j < (numDados*5); j+=5) {
				aux += aux2[j];
				aux += "\t\t";
			}
			aux += "\n";
		}
		
		
		return resultado + aux;
	}
}