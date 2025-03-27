// Importações necessárias para construir a interface gráfica com Swing
import javax.swing.*; // Contém classes como JFrame, JButton, JLabel etc.
import java.awt.*; // Fornece classes para trabalhar com layout, cor, fonte etc.


interface Cafe {
    String descricao(); // Retorna a descrição do café
    double preco();     // Retorna o valor total do café
}

/*
 * Classe concreta que implementa Cafe
 * Representa um café simples, sem adicionais.
 */
class CafeSimples implements Cafe {
    public String descricao() {
        return "Café simples"; // Descrição básica
    }

    public double preco() {
        return 2.00; // Preço fixo para o café simples
    }
}

/*
 * Classe abstrata do padrão Decorator
 * Todas as classes decoradoras irão estender esta classe.
 * Ela mantém uma referência para um objeto Cafe e repassa as chamadas.
 */
abstract class CafeDecorator implements Cafe {
    protected Cafe cafe; // Composição: o decorador contém um café

    public CafeDecorator(Cafe cafe) {
        this.cafe = cafe; // Inicializa com o café base
    }

    // Os métodos apenas repassam a chamada para o objeto encapsulado
    public String descricao() {
        return cafe.descricao();
    }

    public double preco() {
        return cafe.preco();
    }
}

/*
 * Decorador concreto que adiciona leite ao café
 */
class Leite extends CafeDecorator {
    public Leite(Cafe cafe) {
        super(cafe);
    }

    public String descricao() {
        return cafe.descricao() + ", leite"; // Adiciona 'leite' à descrição
    }

    public double preco() {
        return cafe.preco() + 0.50; // Adiciona 0.50 ao preço
    }
}

/*
 * Decorador concreto que adiciona chocolate ao café
 */
class Chocolate extends CafeDecorator {
    public Chocolate(Cafe cafe) {
        super(cafe);
    }

    public String descricao() {
        return cafe.descricao() + ", chocolate"; // Adiciona 'chocolate' à descrição
    }

    public double preco() {
        return cafe.preco() + 0.75; // Adiciona 0.75 ao preço
    }
}

/*
 * Decorador concreto que adiciona chantilly ao café
 */
class Chantilly extends CafeDecorator {
    public Chantilly(Cafe cafe) {
        super(cafe);
    }

    public String descricao() {
        return cafe.descricao() + ", chantilly"; // Adiciona 'chantilly' à descrição
    }

    public double preco() {
        return cafe.preco() + 1.00; // Adiciona 1.00 ao preço
    }
}

/*
 * Classe principal que cria a interface gráfica da cafeteria
 * Permite ao usuário adicionar ingredientes ao café utilizando o padrão Decorator
 */
public class CafeteriaDecoratorUI {

    // Atributos principais da classe
    private Cafe cafe; // Objeto que representa o pedido atual
    private JLabel lblDescricao; // Label para exibir a descrição atual do café
    private JLabel lblPreco;     // Label para exibir o preço atual do café

    // Construtor da interface
    public CafeteriaDecoratorUI() {
        cafe = new CafeSimples(); // Começamos com um café simples

        // Criando a janela (frame) principal
        JFrame frame = new JFrame("Cafeteria - Decorador");
        frame.setSize(600, 500); // Define o tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha ao clicar no X
        frame.setLayout(new BorderLayout()); // Layout dividido em regiões (NORTE, SUL, CENTRO...)

        // Painel para exibir informações do pedido
        JPanel painelInfo = new JPanel();
        painelInfo.setOpaque(false); // Torna o fundo transparente
        painelInfo.setLayout(new BoxLayout(painelInfo, BoxLayout.Y_AXIS)); // Organiza os elementos verticalmente

        // Cria o label com a descrição do café
        lblDescricao = new JLabel("Descrição: " + cafe.descricao());
        lblDescricao.setFont(new Font("Roboto", Font.BOLD, 18));
        lblDescricao.setForeground(new Color(139, 69, 19)); // Marrom escuro

        // Cria o label com o preço do café
        lblPreco = new JLabel("Preço: R$ " + cafe.preco());
        lblPreco.setFont(new Font("Roboto", Font.BOLD, 18));
        lblPreco.setForeground(new Color(139, 69, 19)); // Marrom escuro

        // Adiciona os labels ao painel
        painelInfo.add(lblDescricao);
        painelInfo.add(lblPreco);

        // Painel para os botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        painelBotoes.setOpaque(false); // Fundo transparente

        // Botões de ação
        JButton btnLeite = criarBotao("Adicionar Leite");
        JButton btnChocolate = criarBotao("Adicionar Chocolate");
        JButton btnChantilly = criarBotao("Adicionar Chantilly");
        JButton btnReiniciar = criarBotao("Reiniciar Pedido");

        // Adiciona os botões ao painel
        painelBotoes.add(btnLeite);
        painelBotoes.add(btnChocolate);
        painelBotoes.add(btnChantilly);
        painelBotoes.add(btnReiniciar);

        // Adiciona os painéis à janela
        frame.add(painelInfo, BorderLayout.NORTH); // Painel de informações no topo
        frame.add(painelBotoes, BorderLayout.CENTER); // Painel de botões no centro

        // Define as ações de cada botão
        btnLeite.addActionListener(_ -> {
            cafe = new Leite(cafe); // Envolve o café atual com Leite
            atualizarTela();
        });

        btnChocolate.addActionListener(_ -> {
            cafe = new Chocolate(cafe); // Envolve com Chocolate
            atualizarTela();
        });

        btnChantilly.addActionListener(_ -> {
            cafe = new Chantilly(cafe); // Envolve com Chantilly
            atualizarTela();
        });

        btnReiniciar.addActionListener(_ -> {
            cafe = new CafeSimples(); // Reinicia para o café simples
            atualizarTela();
        });

        // Define cor de fundo da janela
        frame.getContentPane().setBackground(new Color(55, 27, 17)); // Marrom escuro

        // Centraliza a janela na tela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // Exibe a janela
    }

    // Atualiza os textos de descrição e preço na tela
    private void atualizarTela() {
        lblDescricao.setText("Descrição: " + cafe.descricao());
        lblPreco.setText(String.format("Preço: R$ %.2f", cafe.preco()));
    }

    // Método que cria botões com estilo visual e animação
    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Roboto", Font.PLAIN, 14));
        botao.setForeground(Color.WHITE);
        botao.setBackground(new Color(182, 129, 70)); // Marrom claro
        botao.setPreferredSize(new Dimension(200, 50));
        botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding interno
        botao.setFocusable(false); // Evita o contorno ao clicar
        botao.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 2)); // Borda marrom

        // Efeitos visuais ao passar o mouse sobre o botão (hover)
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(152, 103, 55)); // Mais escuro ao passar o mouse
                botao.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 128), 2)); // Destaque na borda
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(182, 129, 70)); // Volta ao normal
                botao.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 2));
            }
        });

        return botao;
    }

    // Método principal - ponto de entrada da aplicação
    public static void main(String[] args) {
        // Executa a interface de forma segura para aplicações Swing
        SwingUtilities.invokeLater(() -> new CafeteriaDecoratorUI());
    }
}
