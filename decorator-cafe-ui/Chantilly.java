// Classe Chantilly estende CafeDecorator, ou seja, é um decorador concreto.
// Serve para adicionar chantilly ao café original.
public class Chantilly extends CafeDecorator {

    // Construtor da classe recebe um objeto Cafe (pode ser CaféSimples ou outro decorador já aplicado)
    public Chantilly(Cafe cafe) {
        // Passa o café recebido para a superclasse CafeDecorator
        // Isso permite encadear os decoradores.
        super(cafe);
    }

    // Sobrescreve o método descricao() da interface Cafe
    @Override
    public String descricao() {
        // Retorna a descrição anterior e adiciona ", chantilly"
        // Exemplo: "Café simples, leite, chantilly"
        return cafe.descricao() + ", chantilly";
    }

    // Sobrescreve o método preco() da interface Cafe
    @Override
    public double preco() {
        // Retorna o preço atual + 1.00 referente ao chantilly
        // Exemplo: se o café custava 2.50, agora custa 3.50
        return cafe.preco() + 1.00;
    }
}
