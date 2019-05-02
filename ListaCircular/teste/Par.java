package teste;

public class Par {

    private Object obj1;
    private Object obj2;

    public Par(Object obj1, Object obj2) {
        this.setObj1(obj1);
        this.setObj2(obj2);
    }

    /**
     * @return the obj2
     */
    public Object getObj2() {
        return obj2;
    }

    /**
     * @param obj2 the obj2 to set
     */
    public void setObj2(Object obj2) {
        this.obj2 = obj2;
    }

    /**
     * @return the obj1
     */
    public Object getObj1() {
        return obj1;
    }

    /**
     * @param obj1 the obj1 to set
     */
    public void setObj1(Object obj1) {
        this.obj1 = obj1;
    }
}