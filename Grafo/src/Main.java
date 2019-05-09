package src;

class Main {
        public static void main(String args[]) {
                Grafo teste = new Grafo("testagrafo.txt");
                Vertice vert = teste.getVerticeNome("Limeira");
                teste.floydWarshall(vert);
        }
}
