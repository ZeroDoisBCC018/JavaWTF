import java.util.concurrent.TimeUnit;

public class maoJogador {

	public Baralho deck = new Baralho();
	public Carta[] naMao = new Carta[5];
	public int pontuacao = 200;

	public void inicializaMao(int size) throws InterruptedException {

		deck.inicializaBaralho();
		
		System.out.println("Embaralhando.... Aguarde....");
		deck.shuffle(500, 52);				/// ALTERAR VALOR (50)
		
		deck.retiraDoBaralho(naMao, size);
	}
	
	public void setPontuacao (int n) {
		pontuacao = n;
	}
	
	public int getPontuacao () {
		return pontuacao;
	}
	
	public void retornaBaralho() {
		deck.resetaBaralho();
		return;
	}
	
	public void imprimeMao() {
		char aux = 'n';
		System.out.println("\n[CARTAS]:");
		System.out.print("  ");
		System.out.println("+---------+  +---------+  +---------+  +---------+  +---------+");
		
		for (int i = 0; i < 5; i++) {
			aux = 'n';
			
			if (naMao[i].getValor() < 11) aux = 'I';
			else if (naMao[i].getValor() == 11) aux = 'J';
			else if (naMao[i].getValor() == 12) aux = 'Q';
			else if (naMao[i].getValor() == 13) aux = 'K';
			else if (naMao[i].getValor() == 14) aux = 'A';
			
			if (aux != 'I') {
				System.out.print("  | " + aux + "       |");
			}
			else {
				if(naMao[i].getValor() == 10) System.out.print("  | " + naMao[i].getValor() + "      |"); 
				else System.out.print("  | " + naMao[i].getValor() + "       |");
			}
			
		}
				
		System.out.println("\n  |         |  |         |  |         |  |         |  |         |");
		
		for (int i = 0; i < 5; i++) {
			System.out.print("  |    " + (char)naMao[i].getNaipe() + "    |");
		}
		
		System.out.println("\n  |         |  |         |  |         |  |         |  |         |");
		
		for (int i = 0; i < 5; i++) {
			aux = 'n';
			
			if (naMao[i].getValor() < 11) aux = 'I';
			else if (naMao[i].getValor() == 11) aux = 'J';
			else if (naMao[i].getValor() == 12) aux = 'Q';
			else if (naMao[i].getValor() == 13) aux = 'K';
			else if (naMao[i].getValor() == 14) aux = 'A';
			
			if (aux != 'I') {
				System.out.print("  |       " + aux + " |");
			}
			else {
				if(naMao[i].getValor() == 10) System.out.print("  |      " + naMao[i].getValor() + " |"); 
				else System.out.print("  |       " + naMao[i].getValor() + " |");
			}
		}
		
		System.out.println("\n  +---------+  +---------+  +---------+  +---------+  +---------+");
		System.out.print("      [1]          [2]          [3]          [4]          [5]\n");
	}
	
	public void alteraCarta(String s) throws InterruptedException {
		if (s.indexOf('1') != -1) deck.alteraCarta(naMao, 0);
		TimeUnit.MILLISECONDS.sleep(1);
		if (s.indexOf('2') != -1) deck.alteraCarta(naMao, 1);
		TimeUnit.MILLISECONDS.sleep(1);
		if (s.indexOf('3') != -1) deck.alteraCarta(naMao, 2);
		TimeUnit.MILLISECONDS.sleep(1);
		if (s.indexOf('4') != -1) deck.alteraCarta(naMao, 3);
		TimeUnit.MILLISECONDS.sleep(1);
		if (s.indexOf('5') != -1) deck.alteraCarta(naMao, 4);
		
		System.out.print("OBS: valores inválidos serão ignorados!\n");
		
		
		return;
	}
	
	public int[][] criaMatriz() {
		int matriz[][] = new int[4][15];
		/*
		 * pos	   = 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
		 * PAUS    -     2 3 4 5 6 7 8 9 10 J  Q  K  A
		 * OUROS   -     2 3 4 5 6 7 8 9 10 J  Q  K  A
		 * COPAS   -     2 3 4 5 6 7 8 9 10 J  Q  K  A
		 * ESPADAS -     2 3 4 5 6 7 8 9 10 J  Q  K  A
		 */
		
		for (int i = 0; i < 5; i++) {
			// TALVEZ GETVALOR+2
			matriz[naMao[i].getNaipeInt()][naMao[i].getValor()] = 1;
		}
		
		return matriz;
	}
	
	public boolean royalStraightFlush (int[][] matriz) {
		
		int i = 0;
		
		for(int j = 0; j < 4; j++) {
			i = 0;
			for (int k = 10; k < 15; k++) {
				
				if(matriz[j][k] == 1) i++;
				else if(matriz[j][k] == 0) i = 0;
				if(i == 5) return true;
			}
		}
		
		return false;
	}
	
	public boolean straightFlush (int[][] matriz) {
		int i = 0;
		
		for(int j = 0; j < 4; j++) {
			i = 0;
			for (int k = 2; k < 15; k++) {
				
				if(matriz[j][k] == 1) i++;
				else if(matriz[j][k] == 0) i = 0;
				if(i == 5) return true;
			}
		}
		
		return false;
	}
	
	public boolean quadra (int[][] matriz) {
		int i = 0;
		
		
		for (int k = 2; k < 15; k++) {
			i = 0;
			for(int j = 0; j < 4; j++) {
				
				if(matriz[j][k] == 1) i++;
				//else if(matriz[j][k] == 0) i = 0;
				if(i == 4) return true;
			}
		}
		
		return false;
	}
	
	public boolean flush (int[][] matriz) {
		int i = 0;
		
		for(int j = 0; j < 4; j++) {	// naipe
			i = 0;
			for (int k = 2; k < 15; k++) {	// cartas
				
				if(matriz[j][k] == 1) i++;
				if(i == 5) return true;
			}
		}
		
		return false;
	}
	
	public boolean straight (int[][] matriz) {
		int i = 0;
		
		for (int k = 2; k < 15; k++) {	// cartas
				
			if(matriz[0][k] == 1 || matriz[1][k] == 1 || matriz[2][k] == 1 || matriz[3][k] == 1) i++;
			else if(matriz[0][k] == 0 && matriz[1][k] == 0 && matriz[2][k] == 0 && matriz[3][k] == 0) i = 0;
			if(i == 5) return true;
		}
		
		
		return false;
	}
	
	public boolean trinca (int[][] matriz) {
		int i = 0;
		
		for (int k = 2; k < 15; k++) {
			i = 0;
			for(int j = 0; j < 4; j++) {
				
				if(matriz[j][k] == 1) i++;
				if(i == 3) return true;
			}
		}
		
		return false;
	}
	
	public boolean doisPares (int[][] matriz) {
		int i = 0;
		int pares = 0;
		
		for (int k = 2; k < 15; k++) {
			i = 0;
			for(int j = 0; j < 4; j++) {
				
				if(matriz[j][k] == 1) i++;
				if(i == 2) {
					pares++;
					break;
				}
			}
		}
		
		if (pares >= 2) return true;
		return false;
	}
	
	public boolean fullHand (int[][] matriz) {
		int i = 0;
		int pares = 0;
		
		for (int k = 2; k < 15; k++) {
			i = 0;
			for(int j = 0; j < 4; j++) {
				
				if(matriz[j][k] == 1) i++;
				if(i == 2) {
					pares++;
					break;
				}
			}
			if (pares == 2) break;
		}
		
		if (pares == 2 && trinca(matriz)) return true;
		return false;
	}
	
	public void verificaVitoria (int aposta) {
		
		int[][] matriz = criaMatriz();
		
		if(royalStraightFlush(matriz)) {
			setPontuacao(pontuacao += aposta * 200);
			System.out.print("@Royal Straight Flush! [Aposta x 200]\n");
			return;
		}
		
		else if(straightFlush(matriz)) {
			setPontuacao(pontuacao += aposta * 100);
			System.out.print("@Straight Flush! [Aposta x 100]\n");
			return;
		}
		
		else if(quadra(matriz)) {
			setPontuacao(pontuacao += aposta * 50);
			System.out.print("@Quadra! [Aposta x 50]\n");
			return;
		}
		
		else if(fullHand(matriz)) {
			setPontuacao(pontuacao += aposta * 20);
			System.out.print("@Full Hand! [Aposta x 20]\n");
			return;
		}
		
		else if(flush(matriz)) {
			setPontuacao(pontuacao += aposta * 10);
			System.out.print("@Flush! [Aposta x 10]\n");
			return;
		}
		
		else if(straight(matriz)) {
			setPontuacao(pontuacao += aposta * 5);
			System.out.print("@Straight! [Aposta x 5]\n");
			return;
		}
		
		else if(trinca(matriz)) {
			setPontuacao(pontuacao += aposta * 2);
			System.out.print("@Trinca! [Aposta x 2]\n");
			return;
		}
		
		else if(doisPares(matriz)) {
			setPontuacao(pontuacao += aposta * 1);
			System.out.print("@Dois Pares! [Aposta x 1]\n");
			return;
		}
		
		else {
			setPontuacao(pontuacao -= aposta);
			System.out.print("@Nenhuma combinação!\n");
			return;
		}
		
		
	}
	
}