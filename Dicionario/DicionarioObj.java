class DicionarioObj {

    private String chave;
    private Integer valor;
    private Object obj;

    public DicionarioObj() {
        this();
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getObj() {
        return this.obj.toString();
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Integer getValor() {
        return valor;
    }

    public String getChave() {
        return chave;
    }
}