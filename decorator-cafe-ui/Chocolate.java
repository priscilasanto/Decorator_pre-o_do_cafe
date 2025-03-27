// A classe Chocolate estende CafeDecorator, aplicando o padrão Decorator.
// Ela adiciona a funcionalidade de "chocolate" a um objeto Cafe existente.
public class Chocolate extends CafeDecorator {

    // Construtor da classe, recebe como argumento um objeto Cafe (pode ser CaféSimples ou outro decorador)
    public Chocolate(Cafe cafe) {
        // Chama o construtor da superclasse CafeDecorator, armazenando o objeto cafe
        super(cafe);
    }

    // Sobrescreve o método descricao() definido na interface Cafe
    @Override
    public String descricao() {
        // Adiciona ", chocolate" à descrição do café atual.
        // Exemplo: se a descrição anterior era "Café simples, leite",
        // o retorno será "Café simples, leite, chocolate"
        return cafe.descricao() + ", chocolate";
    }

    // Sobrescreve o método preco() definido na interface Cafe
    @Override
    public double preco() {
        // Soma 0.75 ao preço atual do café, representando o custo do chocolate.
        // Exemplo: se o café custava 3.00, agora custará 3.75
        return cafe.preco() + 0.75;
    }
}
