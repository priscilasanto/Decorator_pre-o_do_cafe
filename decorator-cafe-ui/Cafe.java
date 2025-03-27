// Declaração de uma interface chamada Cafe.
// Interfaces em Java definem um contrato que as classes que a implementam devem seguir.
public interface Cafe {

    // Método que deve retornar a descrição do café.
    // Exemplo: "Café simples", "Café com leite", etc.
    String descricao();

    // Método que deve retornar o preço do café como um valor numérico (double).
    // Cada tipo de café ou combinação de ingredientes terá um preço diferente.
    double preco();
}
