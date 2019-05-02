public class Dicionario<Tipo extends DicionarioObj> {

    private Tipo[] array;
    private index;

    public Dicionario() {
        array = (Tipo[]) new DicionarioObj(100);
        this.index = 0;
    }

    public insert(K chave) {
        if(this.index >= 100) throw new
    }

    public add(K chave, V valor) {

    }

}