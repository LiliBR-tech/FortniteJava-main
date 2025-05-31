package br.com.FortniteJava;

public class Demo {
    public static void main(String[] args) {
        int x = 250, y = 450;
        System.out.println("Tiro disparado em: " + x + "," + y);

        int resultado = somar(2, 3);
        System.out.println("Resultado da soma: " + resultado);
    }        

    public static int somar(int a, int b) {
        return a + b;
    }
}
