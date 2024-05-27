package sistemaadministrador.test.studentTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.DisableStudentAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.student.StudentService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DisableStudentAccountTest {

    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    @Test
    public void testDisableStudentAccount() {
        // Teste para desativação bem-sucedida
        String name = "Ana";
        int indice = 0;
        String input = name + "\n" + indice;

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        DisableStudentAccount disableStudentAccount = new DisableStudentAccount();
        disableStudentAccount.execute();

        System.setOut(originalOut);

        StudentRepository studentRepository = StudentRepository.getInstance();
        StudentService studentService = new StudentService(studentRepository);
        List<Student> students = studentService.searchStudent("");

        System.out.println(students);

        assertFalse(students.get(0).verifyStatus());

        // Teste para lançar exceção ao tentar desativar novamente a mesma conta
        String nome2 = "Ana";
        int indice2 = 0;
        String input2 = nome2 + "\n" + indice2;
        InputStream inputStream2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(inputStream2);

        // Capturando a saída do sistema
        ByteArrayOutputStream outContent2 = new ByteArrayOutputStream();
        PrintStream originalOut2 = System.out;
        System.setOut(new PrintStream(outContent2));

        DisableStudentAccount command = new DisableStudentAccount();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute();
        });

        // Restaurando a entrada e a saída padrão do sistema
        System.setOut(originalOut2);

        // Verificando se a conta do aluno foi desativada corretamente
        assertFalse(students.get(0).verifyStatus());
        assertEquals("User already deactivated", exception.getMessage());
    }

}





