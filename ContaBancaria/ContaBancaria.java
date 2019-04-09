/**
 * Representa uma conta bancária genérica.
 * @author delamaro
 *
 */
public class ContaBancaria {

	private String nomeCliente;
	static private int numContas = 0;
	private double saldo;
	
	/**
	 * Construtor. Cria uma conta com saldo 0
	 * @param n Nome do titular da conta
	 * @param num Numero atribuído à conta
	 */
	public ContaBancaria(String n, int num) {
		nomeCliente = n;
		numConta = num;
		saldo = 0.0;
		this.numContas++;
	}

	/**
	 * Obtem o nome do titular da conta.
	 * @return Nome do titular da conta.
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public static int getNumContas() {
		return numContas;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public double getSaldo() {
		return saldo;
	}
	
	protected void setSaldo(double s)
	{
		this.saldo = s;
	}
	
	public void saca(double qto) throws IllegalArgumentException {
		if ( saldo < qto) 
			throw new IllegalArgumentException("Saldo insuficiente para esse saque");
		saldo -= qto;
	}
	
	public void deposita(double qto) {
		saldo += qto;
	}

	public abstract void atualiza(double taxa);

}
