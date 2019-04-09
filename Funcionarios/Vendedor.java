public class Vendedor extends Funcionario {

    private double salario;

    public double calculaSalario(double salariobase) {
        return salariobase/2;
    }

    public Vendedor(String nome, String CPF, double salarioBase) {
        super(nome, CPF, salarioBase);
        this.salario = calculaSalario(salarioBase);
    }
}

