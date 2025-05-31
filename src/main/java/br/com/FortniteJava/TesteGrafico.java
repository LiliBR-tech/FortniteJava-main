package br.com.FortniteJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TesteGrafico extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.fillOval(100, 100, 100, 100); // Círculo visual para teste
    }

    public static void main(String[] args) {
        boolean modoTeste = args.length > 0 && args[0].equalsIgnoreCase("teste");

        JFrame frame = new JFrame("Teste Gráfico");
        TesteGrafico painel = new TesteGrafico();
        frame.add(painel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        System.out.println("🎨 Teste gráfico iniciado" + (modoTeste ? " (modoTeste)" : ""));

        if (modoTeste) {
            // Autoencerramento após 5 segundos
            new javax.swing.Timer(5000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("⏰ Encerrando TesteGrafico automaticamente (modoTeste)");
                    frame.dispose();
                    System.exit(0);
                }
            }).start();
        }
    }
}
