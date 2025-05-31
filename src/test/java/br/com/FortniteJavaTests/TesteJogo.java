package br.com.FortniteJavaTests;

import br.com.FortniteJava.JogoAvancado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteJogo {

 @Test
     public void testSoma() {
        assertEquals(5, JogoAvancado.somar(2, 3));
    }
}
