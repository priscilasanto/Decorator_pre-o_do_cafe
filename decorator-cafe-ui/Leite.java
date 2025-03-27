// A classe Leite estende CafeDecorator, seguindo o padrão de projeto Decorator.
// Serve para adicionar o ingrediente "leite" a qualquer objeto que implemente a interface Cafe.
public class Leite extends CafeDecorator {

    // Construtor da classe Leite
    // Recebe um objeto Cafe (pode ser um CafeSimples ou outro decorador)
    public Leite(Cafe cafe) {
        // Chama o construtor da superclasse CafeDecorator, armazenando o café original
        // Isso permite encadear múltiplos decoradores.
        super(cafe);
    }

    // Sobrescreve o método descricao() da interface Cafe
    @Override
    public String descricao() {
        // Retorna a descrição atual do café e adiciona ", leite"
        // Exemplo: "Café simples, leite"
        return cafe.descricao() + ", leite";
    }

    // Sobrescreve o método preco() da interface Cafe
    @Override
    public double preco() {
        // Soma 0.50 ao preço atual do café para representar o adicional de leite
        // Exemplo: se o café custava R$ 2.00, agora custará R$ 2.50
        return cafe.preco() + 0.50;
    }
}
