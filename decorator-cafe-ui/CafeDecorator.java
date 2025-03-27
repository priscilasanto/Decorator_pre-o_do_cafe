// Define uma classe abstrata chamada CafeDecorator, que implementa a interface Cafe.
// Essa classe servirá como base para todos os "adicionais" (ou "decoradores") que serão aplicados ao café.
public abstract class CafeDecorator implements Cafe {

    // Atributo protegido que armazena uma referência para um objeto do tipo Cafe.
    // Esse será o objeto que estamos "decorando" ou estendendo com novos comportamentos.
    protected Cafe cafe;

    // Construtor que recebe um objeto Cafe como parâmetro.
    // Esse objeto será armazenado e utilizado para delegar chamadas de métodos.
    public CafeDecorator(Cafe cafe) {
        this.cafe = cafe;
    }

    // Método que retorna a descrição do café.
    // Ele simplesmente delega a chamada para o objeto Cafe que está sendo decorado.
    public String descricao() {
        return cafe.descricao();
    }

    // Método que retorna o preço do café.
    // Assim como a descrição, ele delega a chamada para o objeto Cafe decorado.
    public double preco() {
        return cafe.preco();
    }
}
