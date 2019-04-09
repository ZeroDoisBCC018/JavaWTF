package mainpackage;

public class Contato {

	private String Nome;
	private String Endereco;
	private String Email;

	public Contato (String nome, String endereco, String email){
		this.Nome = nome;
		this.Endereco = endereco;
		this.Email = email;
	}

	public void setNome (String nome) {
		this.Nome = nome;
	}

	public void setNome (String endereco) {
		this.Endereco = endereco;
	}

	public void setNome (String email) {
		this.Email = email;
	}

	public String getNome (void) {
		return this.Nome;
	}

	public String getEndereco (void) {
		return this.Endereco;
	}

	public String getEmail (void) {
		return this.Email;
	}
}
