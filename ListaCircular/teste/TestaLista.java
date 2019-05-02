package teste;

import static org.junit.Assert.*;

public class TestaLista {

    @Test
    public void test() {
        ListaCircular lista = new ListaCircular(5);
        int out = lista.getElementos();
        assertEquals(0, out);
    }
}