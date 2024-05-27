package sistemaadministrador.test.professorTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

        assertTrue(outContent.toString().contains("Usuário: Jaindson"));

    }

    @Test
    public void testSearchProfessorFail() {
        // Simulando a entrada do usuário
        String searchTerm = "zayan";
        InputStream inputStream = new ByteArrayInputStream(searchTerm.getBytes());
        System.setIn(inputStream);

        // Capturando a saída do sistema
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Criando uma instância do comando de busca de professor
        SearchProfessorAccount searchProfessor = new SearchProfessorAccount();

        // Chama o método execute(), que vai escrever a saída em outContent
        searchProfessor.execute();
        System.setOut(originalOut);
        
        // Converte a saída capturada para uma string
        String output = outContent.toString();
        System.out.println(output);

        // Verificando se a saída não contém o termo de busca inesperado
        assertFalse(output.contains("zayan"));
    }
}
