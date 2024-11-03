public class Vertice {
    private String info;

    public Vertice(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "(" + this.info + ")";
    }

}
