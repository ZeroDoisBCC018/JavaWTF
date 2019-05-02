import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

public class ContaPalavra {
    
    private String nomeArquivo;
    private File arquivoAlvo;
    private Scanner leitor;
    private HashMap<String, Integer> dicionario;
    
    public ContaPalavra(String nomeArquivo) {
        this.nomeArquivo = "./" + nomeArquivo; // arquivo neste diretório
		
		try {
			arquivoAlvo = new File(nomeArquivo);
			leitor = new Scanner(arquivoAlvo);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    public String getNomeArquivo() {
        return this.nomeArquivo;
    }
    
    public void criaMapa() {
        dicionario = new HashMap<String, Integer>();
    }
    
    public void mostraMapa() {
        
    }
	
}
