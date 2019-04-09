package Principal;

public class Bozo {

	public static void main(String[] args) throws Exception{
		// Serão usados 5 dados
		RolaDados rolaDados = new RolaDados(5);
		Placar placar = new Placar();
		int numPartidas = 10;
		
		// Repete as rodadas
		for(int i = 0; i < numPartidas; i++) {
			System.out.println(placar.toString());
			
			System.out.println("****** Rodada " + (i+1));
			System.out.println("Pressione ENTER para iniciar a rodada.");
			EntradaTeclado.leString();
			
			rolaDados.rolar();
			System.out.println(rolaDados.toString());
			
			System.out.println("Digite os dados que deseja TROCAR. Separados por espaços.");
			rolaDados.rolar(EntradaTeclado.leString());
			System.out.println(rolaDados.toString());
				
			System.out.println("Digite os dados que deseja TROCAR. Separados por espaços.");
			rolaDados.rolar(EntradaTeclado.leString());
			System.out.println(rolaDados.toString());
			
			System.out.println("Digite os dados que deseja TROCAR. Separados por espaços.");
			rolaDados.rolar(EntradaTeclado.leString());
			System.out.println(rolaDados.toString());
			
			System.out.println(placar.toString());
			
			// Enquanto não digita posição válida, repete
			boolean checa;
			do {
				System.out.println("Escolha a posição que quer ocupar com essa jogada ===>");
				checa = placar.add(EntradaTeclado.leInt(), rolaDados.getDados());
			}while(checa == false);
			
			System.out.println(placar.toString());
		}
		
		// Exibe a pontuação final
		System.out.println("********************");
		System.out.println("PONTUAÇÃO FINAL: " + placar.getScore());
		System.out.println("********************");
	}

}
