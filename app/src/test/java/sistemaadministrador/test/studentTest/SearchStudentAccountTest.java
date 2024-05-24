package sistemaadministrador.test.studentTest;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.SearchStudentAccount;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchStudentAccountTest {

    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    
    @Test
    public void testSearchStudentSuccess() {
        // Preparando os dados de teste
        // List<Student> students = new ArrayList<>();
        // Name name = new Name("ana");
        // UserName username = new UserName("Ana Clara");
        // Password password = new Password("ana.890EF");
        // students.add(new Student(name, password, username));  

        String searchTerm = "teste";
        InputStream inputStream = new ByteArrayInputStream(searchTerm.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        System.out.println(outContent);


        // Criando uma instância do comando de busca de aluno
        SearchStudentAccount searchStudent = new SearchStudentAccount();

        // Chama o método execute(), que vai escrever a saída em outContent
        // searchStudent.execute();
        // System.setOut(originalOut);
        
        
        // // Converte a saída capturada para uma string
        // String output = outContent.toString();

        // // Verificando se a saída contém o nome do aluno esperado
        // assertTrue(output.contains("Nome: ana Usuário: Ana Clara"));

        searchStudent.execute();
        System.setOut(originalOut);
        
        // Converte a saída capturada para uma string
        String output = outContent.toString();
        System.out.println(output);

        // Verificando se a saída contém o nome do aluno esperado
        assertTrue(output.contains("teste"));
    }

}