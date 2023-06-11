package org.uv.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Examen4yahirApplication.class)
class Examen4yahirApplicationTests {

    @Test
    void contextLoads() {
        // Lógica de prueba
        boolean resultado = myMethod();

        // Afirmación
        assertTrue(resultado);
    }

    public boolean myMethod() {
        // Lógica del método que estás probando
        return true; // El resultado esperado es verdadero (true)
    }

}
