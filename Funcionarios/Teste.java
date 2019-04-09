import java.util.ArrayList;

public class Teste {

    public static void main(String[] args) {

        double SalarioBase = 3.000;
        double total;

        total = 0.00;

        ArrayList folha = new ArrayList<Funcionario>();

        try {
            Gerente g1 = new Gerente("ajhksdf", "12783647917", SalarioBase);
            folha.add(g1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Gerente g2 = new Gerente("aiudhasd", "78123789451", SalarioBase);
            folha.add(g2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Assistente a1 = new Assistente("qwiudj", "23768", SalarioBase);
            folha.add(a1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Assistente a2 = new Assistente("wuiehw", "18276121312987", SalarioBase);
            folha.add(a2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Vendedor v1 = new Vendedor("uewfskasf", "12763012", SalarioBase);
            folha.add(v1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Vendedor v2 = new Vendedor("eu", "34447834855", SalarioBase);
            folha.add(v2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Assistente aux = new Funcionario();

        for (int i = 0; i < 6; i++) {
            aux = folha.get(i);
            total += aux.calculaSalario();
        }

        System.out.println("total = " + total);
    }
}

