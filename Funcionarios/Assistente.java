public class Assistente extends Funcionario {

    private double salario;

    public double calculaSalario(double salariobase) {
        return salariobase;
    }

    public Assistente(String nome, String CPF, double salarioBase) {
        super(nome, CPF, salarioBase);
        this.salario = calculaSalario(salarioBase);
    }
}

