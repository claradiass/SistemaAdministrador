package sistemaadministrador.test.professorTest;



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

    @Test // indica que é método é um caso de teste Junit
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
}
