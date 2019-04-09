import java.util.concurrent.TimeUnit;

public class Baralho {

	public Carta[] cartas = new Carta[52];
	
	
	public Baralho () {
		
	}
	
	public void inicializaBaralho() {
		
		/*
		 * pos	   = 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
		 * PAUS    -     2 3 4 5 6 7 8 9 10 J  Q  K  A
		 * OUROS   -     2 3 4 5 6 7 8 9 10 J  Q  K  A
		 * COPAS   -     2 3 4 5 6 7 8 9 10 J  Q  K  A
		 * ESPADAS -     2 3 4 5 6 7 8 9 10 J  Q  K  A
		 */
		
		int i = 0;
		
		// PAUS
		int valorCarta = 2;
		char naipeCarta = 'P';
		while (i < 13) {
			cartas[i] = new Carta(naipeCarta, valorCarta);	
			valorCarta += 1;
			i += 1;
		}
		
		// OUROS
		valorCarta = 2;
		naipeCarta = 'O';
		while (i >= 13 && i < 26) {
			cartas[i] = new Carta(naipeCarta, valorCarta);	
			valorCarta += 1;
			i += 1;
		}
		
		// COPAS
		valorCarta = 2;
		naipeCarta = 'C';
		while (i >= 26 && i < 39) {
			cartas[i] = new Carta(naipeCarta, valorCarta);	
			valorCarta += 1;
			i += 1;
		}
		
		// ESPADAS
		valorCarta = 2;
		naipeCarta = 'E';
		while (i >= 39 && i < 52) {
			cartas[i] = new Carta(naipeCarta, valorCarta);	
			valorCarta += 1;
			i += 1;
		}
		
	}
	
	public void shuffle(int qntdEmbaralha, int nroCartas) throws InterruptedException {
		
		Random r = new Random();
		Carta auxCard = new Carta('N', 0);
		int aux1 = 0;
		int aux2 = 0;
		int i = 0;
		
		while (i < qntdEmbaralha) {
			aux1 = r.getIntRand(nroCartas);
			TimeUnit.MILLISECONDS.sleep(1);
			aux2 = r.getIntRand(nroCartas);
			
			if (aux1 != aux2) {
				// salva valores de carta[aux1] em auxCard
				auxCard.setNaipe(cartas[aux1].getNaipe()); 
				auxCard.setValor(cartas[aux1].getValor());
				
				// passa os valores de carta[aux2] para carta[aux1]
				cartas[aux1].setNaipe(cartas[aux2].getNaipe());
				cartas[aux1].setValor(cartas[aux2].getValor());
				
				// passa os valores de auxCard para carta[aux2]
				cartas[aux2].setNaipe(auxCard.getNaipe());
				cartas[aux2].setValor(auxCard.getValor());
				
				i++;
			}
		}
	}
	
	
	public void retiraDoBaralho(Carta[] maoJogador, int size) {
		
		int j = 0;
		int i = 0;
		while (i < size) {
			if (cartas[j].getNoBaralho() == 1) {
				maoJogador[i] = cartas[j];
				cartas[j].tiraDoBaralho();
				i++;
			}
			j++;
		}
	}
	
	public void resetaBaralho() {
		for (int i = 0; i < 52; i++) {
			cartas[i].colocaNoBaralho();
		}
	
	}
	
	public void alteraCarta(Carta[] naMao, int index) {

		int j = 0;
		int i = 0;
		while (i < 1) {
			if (cartas[j].getNoBaralho() == 1) {
				naMao[index] = cartas[j];
				cartas[j].tiraDoBaralho();
				i++;
			}
			j++;
		}
	}
	
	
	
	
	
	
	
}