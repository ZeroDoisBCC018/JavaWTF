public class PoupancaOuro extends ContaPoupanca {

	public ContaPoupanca(String n, int num, int dia){
		super(n, num, dia);
	}

	public void atualiza(double taxa) {
		double s = getSaldo();
		setSaldo(s * (1.0 + taxa));
	}
}
