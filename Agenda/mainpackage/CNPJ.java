package mainpackage;

public class CNPJ extends Contato {

	private String UnidadeFederativa;
	private String RazaoSocial;

	public CNPJ (String nome, String endereco, String email, String unidadeFederativa, String razaoSocial) {
		super(nome, endereco, email);
		this.UnidadeFederativa = unidadeFederativa;
		this.RazaoSocial = razaoSocial;
	} 

	public void setUnidadeFederativa (String uf) {
		this.UnidadeFederativa = uf;
	}

	public void setRazaoSocial (String razao) {
		this.RazaoSocial = razao;
	}

	public String getUnidadeFederativa (void) {
		return this.UnidadeFederativa;
	}

	public String getRazaoSocial (void) {
		return this.RazaoSocial;
	}
}
