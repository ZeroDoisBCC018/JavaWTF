
public class Main {

	public static void main(String args[]) throws Exception{
	
		System.out.print("\t\t\t\t Bem-vindo ao\n888     888 d8b      888                                     888                       \n888     888 Y8P      888                                     888                       \n888     888          888                                     888                       \nY88b   d88P 888  .d88888  .d88b.   .d88b.  88888b.   .d88b.  888  888  .d88b.  888d888 \n Y88b d88P  888 d88\" 888 d8P  Y8b d88\"\"88b 888 \"88b d88\"\"88b 888 .88P d8P  Y8b 888P\"   \n  Y88o88P   888 888  888 88888888 888  888 888  888 888  888 888888K  88888888 888     \n   Y888P    888 Y88b 888 Y8b.     Y88..88P 888 d88P Y88..88P 888 \"88b Y8b.     888     \n    Y8P     888  \"Y88888  \"Y8888   \"Y88P\"  88888P\"   \"Y88P\"  888  888  \"Y8888  888     \n                                           888                                         \n                                           888                                         \n                                           888\n\n\t\t Esse jogo possui classificação indicativa [+18]\n");
		
		System.out.print("\nDeseja continuar e jogar? [S/N] ");
		
		int in = 0;
		while (in == 0) {
			String s = EntradaTeclado.leString();
			if (s.equals("N") || s.equals("n")) {
				in = 1;
				System.out.println("\n\nObrigado pelo apoio. Volte assim que se sentir preparado! ;)\n\n888     888 d8b      888                                     888                       \n888     888 Y8P      888                                     888                       \n888     888          888                                     888                       \nY88b   d88P 888  .d88888  .d88b.   .d88b.  88888b.   .d88b.  888  888  .d88b.  888d888 \n Y88b d88P  888 d88\" 888 d8P  Y8b d88\"\"88b 888 \"88b d88\"\"88b 888 .88P d8P  Y8b 888P\"   \n  Y88o88P   888 888  888 88888888 888  888 888  888 888  888 888888K  88888888 888     \n   Y888P    888 Y88b 888 Y8b.     Y88..88P 888 d88P Y88..88P 888 \"88b Y8b.     888     \n    Y8P     888  \"Y88888  \"Y8888   \"Y88P\"  88888P\"   \"Y88P\"  888  888  \"Y8888  888     \n                                           888                                         \n                                           888                                         \n                                           888\n\n\t\t\t\t\t\tCopyright© Mars 2019 VIDEOPOKER®\n");
				return;
			}
			else if (s.equals("S") || s.equals("s")) {
				in = 1;
			}
			else System.out.print("Entrada inválida! Deseja continuar e jogar? [S/N] ");
		}
		
		maoJogador hand = new maoJogador();
		hand.setPontuacao(200);
		
		while (hand.getPontuacao() > 0) {
		
			System.out.print("Você possui: "+hand.getPontuacao()+" fichas!\n");
			System.out.print("Digite o valor da aposta: ");
			
			int aposta = 0;
			int teste = 0;
			
			while (aposta <= 0 || aposta > hand.getPontuacao()) {
				
				while (teste == 0) {
					try {
							aposta = EntradaTeclado.leInt();
							teste = 1;
							if (aposta <= 0 || aposta > hand.getPontuacao()) {
								System.out.print("Valor inválido! Digite o valor da aposta: ]0-"+hand.getPontuacao()+"] ");
								teste = 0;
							}
						} catch (Exception e) {
							System.out.printf("Valor inválido! Tentativa de Batota detectada! Finalizando....\n");
							teste = 0;
							return;
						}
					}
				
			}
			
			
			hand.inicializaMao(5);
			hand.imprimeMao();
			
			
			
			in = 2;
			while (in != 0) {
				if (in == 2) System.out.printf("\nDeseja alterar alguma carta? [S/N] ");
				else if (in == 1) System.out.printf("\nDeseja alterar novamente? [S/N] ");
				String s = EntradaTeclado.leString();
				
				if (s.equals("N") || s.equals("n")) {
					in = 0;
				}
				else if (s.equals("S") || s.equals("s")) {
					in -= 1;
					System.out.printf("Quais cartas deseja alterar? [1-5] ");
					String mudaCartas = EntradaTeclado.leString();
					hand.alteraCarta(mudaCartas);
					hand.imprimeMao();
					
				}
				else System.out.print("Entrada inválida! ");
			}
			
			hand.verificaVitoria(aposta);
			
			if(hand.getPontuacao() == 0) {
				System.out.println("\nVocê ficou sem pontos! Deposite mais $$$$ e volte novamente! ;)\n\n\nObrigado por jogar\n\n888     888 d8b      888                                     888                       \n888     888 Y8P      888                                     888                       \n888     888          888                                     888                       \nY88b   d88P 888  .d88888  .d88b.   .d88b.  88888b.   .d88b.  888  888  .d88b.  888d888 \n Y88b d88P  888 d88\" 888 d8P  Y8b d88\"\"88b 888 \"88b d88\"\"88b 888 .88P d8P  Y8b 888P\"   \n  Y88o88P   888 888  888 88888888 888  888 888  888 888  888 888888K  88888888 888     \n   Y888P    888 Y88b 888 Y8b.     Y88..88P 888 d88P Y88..88P 888 \"88b Y8b.     888     \n    Y8P     888  \"Y88888  \"Y8888   \"Y88P\"  88888P\"   \"Y88P\"  888  888  \"Y8888  888     \n                                           888                                         \n                                           888                                         \n                                           888\n\n\t\t\t\t\t\tCopyright© Mars 2019 VIDEOPOKER®\n");
				return;
			}
			else {
				System.out.println("Pontuação atual: "+hand.getPontuacao());
				System.out.print("Jogar novamente? [S/N] ");
			}
				
			in = 0;
			while (in == 0) {
				String s = EntradaTeclado.leString();
				if (s.equals("N") || s.equals("n")) {
					in = 1;
					if(hand.getPontuacao() > 0) System.out.printf("\nSeu prêmio:\n$$$$ "+hand.getPontuacao()+" $$$$\n\n");
					System.out.println("\n\n\nObrigado por jogar\n\n888     888 d8b      888                                     888                       \n888     888 Y8P      888                                     888                       \n888     888          888                                     888                       \nY88b   d88P 888  .d88888  .d88b.   .d88b.  88888b.   .d88b.  888  888  .d88b.  888d888 \n Y88b d88P  888 d88\" 888 d8P  Y8b d88\"\"88b 888 \"88b d88\"\"88b 888 .88P d8P  Y8b 888P\"   \n  Y88o88P   888 888  888 88888888 888  888 888  888 888  888 888888K  88888888 888     \n   Y888P    888 Y88b 888 Y8b.     Y88..88P 888 d88P Y88..88P 888 \"88b Y8b.     888     \n    Y8P     888  \"Y88888  \"Y8888   \"Y88P\"  88888P\"   \"Y88P\"  888  888  \"Y8888  888     \n                                           888                                         \n                                           888                                         \n                                           888\n\n\t\t\t\t\t\tCopyright© Mars 2019 VIDEOPOKER®\n");

					return;
				}
				else if (s.equals("S") || s.equals("s")) {
					in = 1;
				}
				else System.out.print("Entrada inválida! Deseja continuar? [S/N] ");
			}
			
			hand.retornaBaralho();
		}
		
		
	}
}