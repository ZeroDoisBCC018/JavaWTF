package Principal;

public class Dado {
	private int lado, rolagem = 0;
	private Random rand = new Random();
	
	
	public Dado() {
		this.lado = 6;
	}
	
	public Dado(int n) {
		this.lado = n;
	}
	
	// Pega o valor rolado anteriormente
	public int getLado(){
		if(rolagem > 0) {
			return this.rolagem;
		}else {
			System.out.println("O dado ainda não foi rolado!");
			return 0;
		}
	}
	
	// Faz a rolagem do dado
	public int rolar() {
		this.rolagem = rand.getIntRand(lado) + 1;
		return this.rolagem;
	}
	
	// Define uma semente para o dado
	public void setSeed(int seed) {
		this.rand.setSemente(seed);
	}
	
	// Exibe rolagem, funciona corretamente apenas para lado = 6
	@Override
	public String toString() {
		String resultado = "";
		switch (this.rolagem) {
		case 1:
			resultado += "+-----+\n";
			resultado += "|     |\n";
			resultado += "|  *  |\n";
			resultado += "|     |\n";
			resultado += "+-----+\n";
			break;
			
		case 2:
			resultado += "+-----+\n";
			resultado += "|*    |\n";
			resultado += "|     |\n";
			resultado += "|    *|\n";
			resultado += "+-----+\n";
			break;
			
		case 3:
			resultado += "+-----+\n";
			resultado += "|*    |\n";
			resultado += "|  *  |\n";
			resultado += "|    *|\n";
			resultado += "+-----+\n";
			break;

		case 4:
			resultado += "+-----+\n";
			resultado += "|*   *|\n";
			resultado += "|     |\n";
			resultado += "|*   *|\n";
			resultado += "+-----+\n";
			break;
			
		case 5:
			resultado += "+-----+\n";
			resultado += "|*   *|\n";
			resultado += "|  *  |\n";
			resultado += "|*   *|\n";
			resultado += "+-----+\n";
			break;
			
		case 6:
			resultado += "+-----+\n";
			resultado += "|*   *|\n";
			resultado += "|*   *|\n";
			resultado += "|*   *|\n";
			resultado += "+-----+\n";
			break;
		
		default:
			resultado += "Ainda não houveram rolagens!";
		}

		return resultado;
	}

}
