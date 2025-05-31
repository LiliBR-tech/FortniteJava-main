package br.com.FortniteJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JogoSimples extends JPanel implements ActionListener, KeyListener {
    private int x = 250, y = 250; // Posição inicial do jogador
    private int tiroX = -10, tiroY = -10; // Posição inicial do tiro
    private Timer timer;

    public JogoSimples() {
        timer = new Timer(20, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 30, 30); // Personagem
        g.setColor(Color.RED);
        g.fillRect(tiroX, tiroY, 10, 10); // Tiro
    }

    public void actionPerformed(ActionEvent e) {
        if (tiroY > -10) tiroY -= 5; // Movimentação do tiro
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) x -= 10;
        if (key == KeyEvent.VK_RIGHT) x += 10;
        if (key == KeyEvent.VK_UP) y -= 10;
        if (key == KeyEvent.VK_DOWN) y += 10;
        if (key == KeyEvent.VK_SPACE) { // Disparo
            tiroX = x + 10;
            tiroY = y;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo Simples");
        JogoSimples jogo = new JogoSimples();
        frame.add(jogo);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
