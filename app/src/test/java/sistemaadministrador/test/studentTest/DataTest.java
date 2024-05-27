package sistemaadministrador.test.studentTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.student.StudentService;

public class DataTest {
    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    @Test
    public void dataTest(){
        StudentRepository studentRepository = StudentRepository.getInstance();
        StudentService studentService = new StudentService(studentRepository);
        List<Student> students = studentService.searchStudent("");

        System.out.println(students);
        assertEquals(4, students.size());  // o objetivo desse teste não é dá certo, é apenas para visualização da lista no console de depuração
    }
}
