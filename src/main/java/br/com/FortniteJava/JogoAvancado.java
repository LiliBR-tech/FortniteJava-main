package br.com.FortniteJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class JogoAvancado extends JPanel implements ActionListener, KeyListener {

    private int x = 250, y = 450;
    private ArrayList<Rectangle> tiros = new ArrayList<>();
    private ArrayList<Rectangle> inimigos = new ArrayList<>();
    private Timer timer;

    public JogoAvancado() {
        timer = new Timer(20, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);

        // Criando inimigos
        for (int i = 0; i < 5; i++) {
            inimigos.add(new Rectangle(50 + i * 100, 50, 30, 30));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 30, 30); // Jogador

        g.setColor(Color.RED);
        for (Rectangle tiro : tiros) {
            g.fillRect(tiro.x, tiro.y, tiro.width, tiro.height);
        }

        g.setColor(Color.GREEN);
        for (Rectangle inimigo : inimigos) {
            g.fillRect(inimigo.x, inimigo.y, inimigo.width, inimigo.height);
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (Rectangle tiro : tiros) {
            tiro.y -= 5;
        }

        for (Rectangle inimigo : inimigos) {
            inimigo.y += 2;
        }

        tiros.removeIf(tiro -> inimigos.removeIf(inimigo -> inimigo.intersects(tiro)));
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) x -= 10;
        if (key == KeyEvent.VK_RIGHT) x += 10;
        if (key == KeyEvent.VK_SPACE) { 
            tiros.add(new Rectangle(x + 10, y, 5, 10));
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    // Método utilitário
    public static int somar(int a, int b) {
        return a + b;
    }

    // Método main único e correto
    public static void main(String[] args) {
        boolean modoTeste = args.length > 0 && args[0].equalsIgnoreCase("teste");

        System.out.println("Resultado da soma: " + somar(2, 3));
        if (modoTeste) System.out.println("🔍 Modo de teste ativado (autoencerramento em 5s)");

        JFrame frame = new JFrame("Jogo Avançado");
        JogoAvancado jogo = new JogoAvancado();
        frame.add(jogo);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        if (modoTeste) {
            new javax.swing.Timer(5000, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    System.out.println("⏰ Encerrando automaticamente após 5 segundos (modoTeste)");
                    frame.dispose();
                    System.exit(0);
                }
            }).start();
        }
    }
}
