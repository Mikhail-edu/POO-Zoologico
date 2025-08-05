

import javax.swing.*;
import java.awt.*;

public class MinhaJanela {
    public static void main(String[] args) {
        // Criar a janela principal
        JFrame janela = new JFrame("Gerenciamento do zoologico");
        janela.setSize(400, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel principal com layout vertical
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        // Painel para entrada de nome
        JPanel painelEntrada = new JPanel();
        JLabel rotulo = new JLabel("Digite seu nome:");
        JTextField campoTexto = new JTextField(15);
        JButton botao = new JButton("Saudar");

        // Ação do botão
        botao.addActionListener(e -> {
            String nome = campoTexto.getText().trim();
            if (!nome.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Bem Vindo, " + nome + "!");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, digite um nome.");
            }
        });

        painelEntrada.add(rotulo);
        painelEntrada.add(campoTexto);
        painelEntrada.add(botao);

        // Carregar e redimensionar a imagem
        String caminho = "foto1.jpg";
        ImageIcon imagemOriginal = new ImageIcon(caminho);

    if (imagemOriginal.getIconWidth() == -1) {
    JOptionPane.showMessageDialog(null, "Erro: imagem não encontrada em " + caminho);
}
        Image imagemRedimensionada = imagemOriginal.getImage().getScaledInstance(
                300, 350, Image.SCALE_SMOOTH
        );
        ImageIcon imagemIcon = new ImageIcon(imagemRedimensionada);
        JLabel labelImagem = new JLabel(imagemIcon);
        labelImagem.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionar tudo ao painel principal
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 10))); // espaço superior
        painelPrincipal.add(painelEntrada);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 20))); // espaço entre painel e imagem
        painelPrincipal.add(labelImagem);

        // Adicionar painel à janela e exibir
        janela.add(painelPrincipal);
        janela.setVisible(true);
    }
}