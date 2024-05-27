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
    public void testDisableStudentAccount_Successful() {
        // Teste para desativação bem-sucedida
        String name = "Ana";
        int index = 0;
        String input = name + "\n" + index;

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

        assertFalse(students.get(0).verifyStatus());
    }

    @Test
    public void testDisableStudentAccount_Exception() {
        // Teste para lançar exceção ao tentar desativar novamente a mesma conta
        String name = "Ana";
        int index = 0;
        String input = name + "\n" + index;
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Capturando a saída do sistema
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        DisableStudentAccount command = new DisableStudentAccount();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute();
        });

        // Restaurando a entrada e a saída padrão do sistema
        System.setOut(originalOut);

        // Verificando se a exceção é lançada corretamente
        assertEquals("User already deactivated", exception.getMessage());
    }
}
