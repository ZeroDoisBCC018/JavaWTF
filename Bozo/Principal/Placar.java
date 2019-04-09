package Principal;

public class Placar {
	private int[] placar = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	
	// Percorre o vetor dos dados, funciona corretamente apenas para lado = 6
	private int[] verificaDados(int[] dados) {
		int[] num = {0, 0, 0, 0, 0, 0};
		
		for(int i = 0; i < dados.length; i++) {
			switch(dados[i]) {
				case 1:
					num[0]++;
					break;
					
				case 2:
					num[1]++;
					break;
					
				case 3:
					num[2]++;
					break;
					
				case 4:
					num[3]++;
					break;
					
				case 5:
					num[4]++;
					break;
					
				case 6:
					num[5]++;
					break;
					
			}
		}
		
		return num;
	}
	
	// Adiciona em uma posição do placar
	public boolean add(int posicao, int[] dados) {
		// Checa posições inválidas
		if(posicao > 10 || posicao < 1) {
			System.out.println("Digite uma posição entre 1 a 10!");
			return false;
		}
		
		if(placar[posicao-1] >= 0) {
			System.out.println("Posição já está ocupada!");
			return false;
		}
		
		// Confere pontuação em cada posição
		int soma = 0;
		int[] num;
		boolean checa1 = false, checa2 = false;
		switch(posicao) {
			case 1:
				for(int i = 0; i < dados.length; i++) {
					if(dados[i] == 1) {
						soma += 1;
					}
				}
				this.placar[0] = soma;
				break;
			
			case 2:
				for(int i = 0; i < dados.length; i++) {
					if(dados[i] == 2) {
						soma += 2;
					}
				}
				this.placar[1] = soma;
				break;
				
			case 3:
				for(int i = 0; i < dados.length; i++) {
					if(dados[i] == 3) {
						soma += 3;
					}
				}
				this.placar[2] = soma;			
				break;
							
			case 4:
				for(int i = 0; i < dados.length; i++) {
					if(dados[i] == 4) {
						soma += 4;
					}
				}
				this.placar[3] = soma;
				break;
				
			case 5:
				for(int i = 0; i < dados.length; i++) {
					if(dados[i] == 5) {
						soma += 5;
					}
				}
				this.placar[4] = soma;
				break;
				
			case 6:
				for(int i = 0; i < dados.length; i++) {
					if(dados[i] == 6) {
						soma += 6;
					}
				}
				this.placar[5] = soma;
				break;
				
			case 7:
				num = verificaDados(dados);
				for(int i = 0; i < 6; i++) {
					if(num[i] == 3) {
						checa1 = true;
					}else if(num[i] == 2){
						checa2 = true;
					}
				}
				if(checa1 && checa2) {
					this.placar[6] = 15;
				}else {
					this.placar[6] = 0;
				}
				break;
				
			case 8:
				num = verificaDados(dados);
				int qtd = 0;
				for(int i = 0; i < 6; i++) {
					if(num[i] == 1) {
						qtd++;
					}
				}
				for(int i = 0; i < 5; i++) {
					soma += dados[i]; 
				}
				if(qtd == 5 && (soma == 15 || soma == 20)) {
					this.placar[7] = 20;
				}else {
					this.placar[7] = 0;
				}	
				break;
				
			case 9:
				num = verificaDados(dados);
				for(int i = 0; i < 6; i++) {
					if(num[i] >= 4) {
						checa1 = true;
						break;
					}
				}
				if(checa1 == true) {
					this.placar[8] = 30;
				}else {
					this.placar[8] = 0;
				}
				break;
				
			case 10:
				num = verificaDados(dados);
				for(int i = 0; i < 6; i++) {
					if(num[i] == 5) {
						checa1 = true;
						break;
					}
				}
				if(checa1 == true) {
					this.placar[9] = 40;
				}else {
					this.placar[9] = 0;
				}
				break;
		}
		
		return true;
	}
	
	// Retorna pontuação total
	public int getScore() {
		int soma = 0;
		
		for(int i = 0; i < placar.length; i++){
			if(placar[i] >= 0) {
				soma += placar[i];
			}
		}
		
		return soma;
	}
	
	// Exibe placar na tela
	@Override
	public String toString() {
		String resultado = "";
		String[] valores = new String[10];
		for(int i = 0; i< 10; i++) {
			if(placar[i] >= 0) {
				valores[i] = String.valueOf(placar[i]);
			}else {
				valores[i] = "(" + (i+1) + ")";
			}
		}
		resultado += valores[0] + "\t|\t" + valores[6] + "\t|\t" + valores[3] + " \n";
		resultado += "-------------------------------------\n";
		resultado += valores[1] + "\t|\t" + valores[7] + "\t|\t" + valores[4] + " \n";
		resultado += "-------------------------------------\n";
		resultado += valores[2] + "\t|\t" + valores[8] + "\t|\t" + valores[5] + " \n";
		resultado += "-------------------------------------\n";
		resultado += "\t|\t" + valores[9] + "\t|\t\n";
		resultado += "\t+---------------+\t\n";
		      
		return resultado;
	}
}