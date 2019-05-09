package src;

import java.util.*;

public class Vertice {

    // o id neste programa não tem nenhuma finalidade
    // mas pode ser um valor assinalado ao vertice
    private final String id;
    private final String nome;
    private HashMap<String, Integer> adjacentes;
    private int grau;

    public Vertice(String id, String nome) {
        this.nome = nome;
        this.id = id;
        this.grau = 0;
        adjacentes = new HashMap<String, Integer>();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getGrau() {
        return adjacentes.size();
    }

    @Override
    public int hashCode() {
        final int primo = 31;
        int resultado = 1;
        resultado = primo * resultado + ((id == null) ? 0 : id.hashCode());
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Vertice clone = (Vertice) obj;

        if (id == null) {
            if (clone.id != null)
                return false;
        } else if (!id.equals(clone.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public void adicionaVizinho(String nome, int peso) {
        adjacentes.put(nome, peso);
        this.grau += 1;
    }

    public void tiraVizinho(String nome) {
        if (this.grau == 0)
            return;
        for (Iterator<Map.Entry<String, Integer>> it = adjacentes.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getKey().equals(nome)) {
                it.remove();
            }
        }
        this.grau -= 1;
    }

    public void apagar() {
        adjacentes.clear();
        this.grau = 0;
    }

    public void mostrarVizinhos() {
        Iterator it = adjacentes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry alvo = (Map.Entry) it.next();
            System.out.println(alvo.getKey());
            it.remove();
        }
    }

    // retorna o vizinho mais proximo
    public String maisProximo() {
        Integer peso1;
        Integer peso2;
        Iterator it = adjacentes.entrySet().iterator();
        Map.Entry<String, Integer> ret;
        Map.Entry<String, Integer> anterior;
        Map.Entry<String, Integer> atual;
        String retorno = " ";
        while (it.hasNext()) {
            atual = (Map.Entry) it.next();
            anterior = atual;
            peso1 = anterior.getValue();
            peso2 = atual.getValue();
            if (peso1 <= peso2) {
                retorno = atual.getKey();
            } else {
                retorno = anterior.getKey();
            }
            it.remove();
        }
        return retorno;
    }
}
