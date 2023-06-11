package org.uv.demo;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest (classes = Examen4yahirApplication.class)
class Examen4yahirApplicationTests {

	@Test
    public void miMetodoTest() {
        // Lógica de prueba
        int resultado=5;
        resultado = miMetodo();

        // Afirmación
        
    }

    public int miMetodo() {
        return 5; // El resultado esperado es 5
    }
}

