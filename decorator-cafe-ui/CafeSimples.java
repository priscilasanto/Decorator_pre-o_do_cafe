// Classe concreta que implementa a interface Cafe.
// Representa a versão mais básica de um café, sem adicionais.
public class CafeSimples implements Cafe {

    // Implementa o método descricao() da interface Cafe.
    // Retorna uma string descritiva do produto.
    public String descricao() {
        return "Café simples";
    }

    // Implementa o método preco() da interface Cafe.
    // Retorna o preço fixo do café simples.
    public double preco() {
        return 2.00;
    }
}
