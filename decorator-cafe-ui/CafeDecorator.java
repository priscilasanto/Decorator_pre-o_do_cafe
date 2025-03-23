public abstract class CafeDecorator implements Cafe {
    protected Cafe cafe;
    public CafeDecorator(Cafe cafe) { this.cafe = cafe; }
    public String descricao() { return cafe.descricao(); }
    public double preco() { return cafe.preco(); }
}
