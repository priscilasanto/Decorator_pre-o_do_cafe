public class Chantilly extends CafeDecorator {
    public Chantilly(Cafe cafe) { super(cafe); }
    public String descricao() { return cafe.descricao() + ", chantilly"; }
    public double preco() { return cafe.preco() + 1.00; }
}
