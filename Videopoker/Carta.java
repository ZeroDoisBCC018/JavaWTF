public class Carta {

	
	/* P - Paus    - 0 
	 * O - Ouros   - 1
	 * C - Copas   - 2
	 * E - Espadas - 3
	 */
	private char naipe;
	
	/*
	 * 2 ao 10
	 * 11 - J - Valete
	 * 12 - Q - Dama
	 * 13 - K - Rei
	 * 14 - A - Ás
	 */
	private int valor;
	
	/*
	 * 0 - não está
	 * 1 - está
	 */
	private int noBaralho = 1;
	
	public Carta (char np, int vlr) {
		naipe = np;
		valor = vlr;
	}
	
	public char getNaipe() {
		return naipe;
	}
	
	public int getNaipeInt() {
		if (naipe == 'P') return 0;
		else if (naipe == 'O') return 1;
		else if (naipe == 'C') return 2;
		else if (naipe == 'E') return 3;
		else return -1;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setNaipe(char n) {
		naipe = n;
	}
	
	public void setValor(int v) {
		valor = v;
	}
	
	public int getNoBaralho() {
		return noBaralho;
	}
	
	public void tiraDoBaralho() {
		noBaralho = 0;
	}
	
	public void colocaNoBaralho() {
		noBaralho = 1;
	}
}