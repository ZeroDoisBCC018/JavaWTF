package teste;

public class ListaCircular<TIPO extends Object> {

    private TIPO[] lista;
    private int tamanho;
    private int elementos;
    private int primeiro;
    private int ultimo;

    public ListaCircular(int tamanho) {
        this.tamanho = tamanho;
        lista = (TIPO[]) new Object[tamanho];
        this.primeiro = 0;
        this.ultimo = 0;
        this.elementos = 0;
    }

    /**
     * @return Número de elementos na lista
     */
    public int getElementos() {
        return elementos;
    }

    /**
     * @return Tamanho da lista
     */
    public int getTamanho() {
        return tamanho;
    }

    // @return Primeiro elemento da lista
    public int getPrimeiro() {
        return primeiro + 1;
    }

    // @return Último elemento da lista
    public int getUltimo() {
        return ultimo + 1;
    }

    public int insereInicio(TIPO obj) {

        if (obj == NULL) {
            throw new Exception("Objeto não instanciado");
            return -1;
        }

        if (elementos == tamanho) {
            throw new Exception("Lista cheia");
            return -1;
        }

        int posicao;
        posicao = primeiro - 1;

        if (posicao < 0) {
            posicao = 99;
        }

        this.primeiro = posicao;
        lista[primeiro] = obj;
        this.elementos += 1;
        return primeiro + 1;
    }

    public int insereFinal(TIPO obj) {

        if (obj == NULL) {
            throw new Exception("Objeto não instanciado");
            return -1;
        }

        if (elementos == tamanho) {
            throw new Exception("Lista cheia");
            return -1;
        }

        int posicao;
        posicao = ultimo + 1;

        if (posicao > 100) {
            posicao = 0;
        }

        this.ultimo = posicao;
        lista[ultimo] = obj;
        this.elementos += 1;
        return ultimo + 1;
    }

    public void removeInicio() {

        if (this.elementos == 0) {
            throw new Exception("Lista vazia");
            return;
        }

        this.lista[primeiro] = NULL;
        this.primeiro += 1;

        if (this.primeiro > 99)
            this.primeiro = 0;
    }

    public void removeFim() {

        if (this.elementos == 0) {
            throw new Exception("Lista vazia");
            return;
        }

        this.lista[ultimo] = NULL;
        this.ultimo += 1;

        if (this.ultimo < 0)
            this.primeiro = 99;
    }
}