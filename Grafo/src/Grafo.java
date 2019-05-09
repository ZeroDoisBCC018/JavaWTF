package src;

import java.util.*;
import java.io.*;

public class Grafo {

    private HashSet<Vertice> grafo;
    private int ordem;

    public Grafo(String file) {

        FileReader arquivo;
        BufferedReader buffer;
        String filepath;
        String linha;
        filepath = file; // mesmo diretório - é possível mudar o filepath
        grafo = new HashSet<Vertice>();

        try {

            arquivo = new FileReader(filepath);
            buffer = new BufferedReader(arquivo);
            Vertice atual = new Vertice("0", "init");

            while ((linha = buffer.readLine()) != null) {

                // pega os vizinhos baseado na formatação do arquivo-fonte usando tab ('\t')
                if (!linha.contains("\t")) {
                    atual = new Vertice("0", linha);
                    grafo.add(atual);
                } else {
                    String parte[] = linha.split(" ");
                    String adjNome = parte[0];
                    String adjPeso = parte[1];
                    int peso;

                    try {
                        peso = Integer.parseInt(adjPeso);
                        if (peso < 0) {
                            // caso o peso da aresta (id) seja negativo
                            throw new Exception("Peso inválido, fixado automaticamente como 0");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(e.toString());
                        peso = 0;
                    } catch (Exception e) {
                        peso = 0;
                    }
                    atual.adicionaVizinho(adjNome, peso);
                    ordem += 1;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public int getOrdem() {
        return this.ordem;
    }

    public void limpar() {
        grafo.clear();
    }

    // mostra o grafo por nome seguido de id (conteúdo assinalado)
    public void mostrar() {
        for (Vertice v : grafo) {
            System.out.println(v.getNome() + ", " + v.getId());
        }
    }

    // encontra e retorna o vertice no grafo a partir do nome
    public Vertice getVerticeNome(String nome) {
        Vertice ret = new Vertice(null, null);
        for (Vertice v : grafo) {
            if (v.getNome() == nome) {
                ret = v;
                return ret;
            }
        }
        return ret;
    }

    // encontra e retorna o vertice no grafo a partir do id (conteúdo assinalado)
    public Vertice getVerticeId(String id) {
        Vertice ret = new Vertice(null, null);
        for (Vertice v : grafo) {
            if (v.getId() == id) {
                ret = v;
                return ret;
            }
        }
        return ret;
    }

    // executa um algoritmo adaptado e baseado no Floyd-Warshall,
    // que mostra o caminho conexo mais curto a partir de qualquer vertice do grafo
    // imprime o caminho e no final limpa o grafo
    public void floydWarshall(Vertice inicial) {
        if (inicial.getGrau() == 0) {
            grafo.clear();
            return;
        }
        String prox = inicial.maisProximo();
        System.out.println("Saindo de " + inicial.toString() + " para " + prox);
        inicial.tiraVizinho(prox);
        floydWarshall(getVerticeNome(prox));
    }
}
