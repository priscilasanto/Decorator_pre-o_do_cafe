public class Chocolate extends CafeDecorator {
    public Chocolate(Cafe cafe) { super(cafe); }
    public String descricao() { return cafe.descricao() + ", chocolate"; }
    public double preco() { return cafe.preco() + 0.75; }
}
