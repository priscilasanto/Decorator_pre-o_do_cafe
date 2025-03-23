public class Leite extends CafeDecorator {
    public Leite(Cafe cafe) { super(cafe); }
    public String descricao() { return cafe.descricao() + ", leite"; }
    public double preco() { return cafe.preco() + 0.50; }
}
