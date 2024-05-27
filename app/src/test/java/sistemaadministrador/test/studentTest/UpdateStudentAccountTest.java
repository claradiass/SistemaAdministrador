package sistemaadministrador.test.studentTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.UpdateStudentAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.student.StudentService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateStudentAccountTest {

    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    @Test
    public void testUpdateStudent() {
        // Simulando a entrada do usuário
        String input = "Ana\n0\nNovoNome2\nNovoUsuario2\nNovaSenha123.2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Executando o teste
        UpdateStudentAccount command = new UpdateStudentAccount();
        command.execute();

        // Verificando se a conta do estudante foi atualizada corretamente
        StudentRepository studentRepository = StudentRepository.getInstance();
        StudentService studentService = new StudentService(studentRepository);
        List<Student> students = studentService.viewStudentList();

        // Verificando se o nome, usuário e senha do estudante foram atualizados corretamente
        assertEquals("Nome: NovoNome Usuário: NovoUsuario status: true", students.get(0).toString()); // Assumindo que o toString() de Student retorna o nome
    }
}
