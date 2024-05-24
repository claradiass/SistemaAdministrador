package sistemaadministrador.test.professorTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.SearchProfessorAccount;

public class SearchProfessorAccountTest {
    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    @Test
    public void procurar(){
        String input = "Jaindson";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        SearchProfessorAccount command = new SearchProfessorAccount();
        command.execute();

        System.setOut(originalOut);

        assertTrue(outContent.toString().contains("Jaindson"));

    }
}
