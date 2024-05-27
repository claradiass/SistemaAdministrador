package sistemaadministrador.test.professorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.CreateProfessorAccount;


public class CreateProfessorAccountTest {
    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    @Test 
    public void testCreateProfessorAccount() {
        String input = "Jaindson\nJaindson\nJaindson.123J";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CreateProfessorAccount command = new CreateProfessorAccount();
        command.execute();

        System.setOut(originalOut);

        assertTrue(outContent.toString().contains("Sua conta foi criada com sucesso!"));
    }

    @Test
    public void testWrongFormatPassword() {
        String input = "John Doe\njohndoe\npassword.ANA\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CreateProfessorAccount command = new CreateProfessorAccount();
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute();
        });

        System.setOut(originalOut);

        assertFalse(outContent.toString().contains("Sua conta foi criada com sucesso!"));
        assertEquals("A password must have at least 8 characters, including at least one lowercase letter, one uppercase letter, and one number.", exception.getMessage());
    }

    @Test
    public void testUserNameNull() {
        String input = "John Doe\n\npassword.ANA22\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CreateProfessorAccount command = new CreateProfessorAccount();
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute();
        });

        System.setOut(originalOut);

        assertFalse(outContent.toString().contains("Sua conta foi criada com sucesso!"));
        assertEquals("The username cannot be null or existing", exception.getMessage());
    }

    @Test
    public void testNameNull() {
        String input = "\n\nJohn Doe\npassword.ANA22\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CreateProfessorAccount command = new CreateProfessorAccount();
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute();
        });

        System.setOut(originalOut);

        assertFalse(outContent.toString().contains("Sua conta foi criada com sucesso!"));
        assertEquals("The name cannot be null", exception.getMessage());
    }

    @Test
    public void testPasswordNull() {
        String input = "Ana Clara\nana\n\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CreateProfessorAccount command = new CreateProfessorAccount();
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute();
        });

        System.setOut(originalOut);

        assertFalse(outContent.toString().contains("Sua conta foi criada com sucesso!"));
        assertEquals("A password must have at least 8 characters, including at least one lowercase letter, one uppercase letter, and one number.", exception.getMessage());
    }

    @Test
    public void testUserNameExists() {
        String input = "Jaindson\nJaindson\nJaindson.123J";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CreateProfessorAccount command = new CreateProfessorAccount();
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute();
        });

        System.setOut(originalOut);

        assertFalse(outContent.toString().contains("Sua conta foi criada com sucesso!"));
        assertEquals("The username cannot be existing", exception.getMessage());
    }
}
