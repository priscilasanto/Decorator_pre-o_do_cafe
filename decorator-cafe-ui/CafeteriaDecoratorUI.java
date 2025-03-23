import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Interface básica
interface Cafe {
    String descricao();
    double preco();
}

// Café Simples
class CafeSimples implements Cafe {
    public String descricao() { return "Café simples"; }
    public double preco() { return 2.00; }
}

// Decorador abstrato
abstract class CafeDecorator implements Cafe {
    protected Cafe cafe;
    public CafeDecorator(Cafe cafe) { this.cafe = cafe; }
    public String descricao() { return cafe.descricao(); }
    public double preco() { return cafe.preco(); }
}

// Decoradores concretos
class Leite extends CafeDecorator {
    public Leite(Cafe cafe) { super(cafe); }
    public String descricao() { return cafe.descricao() + ", leite"; }
    public double preco() { return cafe.preco() + 0.50; }
}

class Chocolate extends CafeDecorator {
    public Chocolate(Cafe cafe) { super(cafe); }
    public String descricao() { return cafe.descricao() + ", chocolate"; }
    public double preco() { return cafe.preco() + 0.75; }
}

class Chantilly extends CafeDecorator {
    public Chantilly(Cafe cafe) { super(cafe); }
    public String descricao() { return cafe.descricao() + ", chantilly"; }
    public double preco() { return cafe.preco() + 1.00; }
}

// Classe principal com interface
public class CafeteriaDecoratorUI {

    private Cafe cafe;
    private JLabel lblDescricao;
    private JLabel lblPreco;

    public CafeteriaDecoratorUI() {
        cafe = new CafeSimples();
        JFrame frame = new JFrame("Cafeteria - Decorador");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Remover imagem de fundo sofisticada
        frame.setLayout(new BorderLayout());

        // Criar painel para informações do café
        JPanel painelInfo = new JPanel();
        painelInfo.setOpaque(false);
        painelInfo.setLayout(new BoxLayout(painelInfo, BoxLayout.Y_AXIS));

        lblDescricao = new JLabel("Descrição: " + cafe.descricao());
        lblDescricao.setFont(new Font("Roboto", Font.BOLD, 18));
        lblDescricao.setForeground(new Color(139, 69, 19)); // Marrom mais escuro para o texto

        lblPreco = new JLabel("Preço: R$ " + cafe.preco());
        lblPreco.setFont(new Font("Roboto", Font.BOLD, 18));
        lblPreco.setForeground(new Color(139, 69, 19)); // Marrom mais escuro para o texto

        painelInfo.add(lblDescricao);
        painelInfo.add(lblPreco);

        // Criar painel de botões com bordas arredondadas e animação
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        painelBotoes.setOpaque(false);

        JButton btnLeite = criarBotao("Adicionar Leite");
        JButton btnChocolate = criarBotao("Adicionar Chocolate");
        JButton btnChantilly = criarBotao("Adicionar Chantilly");
        JButton btnReiniciar = criarBotao("Reiniciar Pedido");

        painelBotoes.add(btnLeite);
        painelBotoes.add(btnChocolate);
        painelBotoes.add(btnChantilly);
        painelBotoes.add(btnReiniciar);

        // Adicionando os painéis
        frame.add(painelInfo, BorderLayout.NORTH);
        frame.add(painelBotoes, BorderLayout.CENTER);

        // Ações dos botões
        btnLeite.addActionListener(e -> {
            cafe = new Leite(cafe);
            atualizarTela();
        });

        btnChocolate.addActionListener(e -> {
            cafe = new Chocolate(cafe);
            atualizarTela();
        });

        btnChantilly.addActionListener(e -> {
            cafe = new Chantilly(cafe);
            atualizarTela();
        });

        btnReiniciar.addActionListener(e -> {
            cafe = new CafeSimples();
            atualizarTela();
        });

        // Definir o fundo da janela para marrom escuro com transparência
        frame.getContentPane().setBackground(new Color(55, 27, 17)); // Cor marrom escuro

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void atualizarTela() {
        lblDescricao.setText("Descrição: " + cafe.descricao());
        lblPreco.setText(String.format("Preço: R$ %.2f", cafe.preco()));
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Roboto", Font.PLAIN, 14));
        botao.setForeground(Color.WHITE);
        botao.setBackground(new Color(182, 129, 70)); // Marrom claro suave
        botao.setPreferredSize(new Dimension(200, 50));
        botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        botao.setFocusable(false);

        // Adicionando sombreamento sutil nos botões para dar um toque profissional
        botao.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 2)); // Sombra de borda marrom
        botao.setFocusPainted(false);

        // Animação de hover
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(152, 103, 55)); // Cor mais escura ao passar o mouse
                botao.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 128), 2)); // Borda mais clara ao passar o mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(182, 129, 70)); // Cor normal
                botao.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 2)); // Restaura a borda normal
            }
        });

        return botao;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CafeteriaDecoratorUI());
    }
}
