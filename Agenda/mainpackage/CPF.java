package mainpackage;

public class CPF extends Contato {

	private String DataNascimento;
	private String EstadoCivil;

	public CPF (String nome, String endereco, String email, String dataNascimento, String estadoCivil) {
		super(nome, endereco, email);
		this.DataNascimento = dataNascimento;
		this.EstadoCivil = estadoCivil;
	} 

	public void setDataNascimento (String data) {
		this.DataNascimento = data;
	}

	public void setEstadoCivil (String estado) {
		this.EstadoCivil = estado;
	}

	public String getDataNascimento (void) {
		return this.DataNascimento;
	}

	public String getEstadoCivil (void) {
		return this.EstadoCivil;
	}
}
