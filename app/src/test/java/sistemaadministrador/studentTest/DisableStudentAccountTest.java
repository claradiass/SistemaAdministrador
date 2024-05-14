// package sistemaadministrador.studentTest;

// import static org.junit.jupiter.api.Assertions.assertFalse;

// import java.io.ByteArrayInputStream;
// import java.io.InputStream;
// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.Test;

// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;

// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.DisableStudentAccount;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Name;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Password;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.UserName;

// public class DisableStudentTest {

//     @Test
//     public void testeDisableStudentSucess(){

//         String input = "teste";
//         InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//         System.setIn(inputStream);

//         int inputIndex = 0; // Este é o valor do tipo int que você quer fornecer como entrada
//         String inputIndexString = String.valueOf(inputIndex); // Convertendo o int para String
//         InputStream inputStreamIndex = new ByteArrayInputStream(inputIndexString.getBytes()); // Criando um InputStream a partir da String
//         System.setIn(inputStreamIndex); // Configurando o System.in para usar o InputStream criado

        

//         DisableStudentAccount disableStudentAccount = new DisableStudentAccount();
//         disableStudentAccount.execute();

//         assertFalse();

//     }

// //     @Test
// // public void testeDisableStudentSuccess() {
// //     // Simulando entrada do usuário para nome e índice
// //     String input = "teste\n0\n"; // Adicionando uma quebra de linha extra após o índice
// //     InputStream inputStream = new ByteArrayInputStream(input.getBytes());
// //     System.setIn(inputStream);

// //     List<Student> students = new ArrayList<>();
// //     Name name = new Name("teste");
// //     UserName username = new UserName("testeaaaaa");
// //     Password password = new Password("teste.890EF");
// //     students.add(new Student(name, password, username));
// //     System.out.println(students.get(0));

// //     DisableStudentAccount disableStudentAccount = new DisableStudentAccount();
// //     disableStudentAccount.execute();

// //     assertFalse(students.get(0).verifyStatus());
// // }


// }

// package sistemaadministrador.studentTest;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.DisableStudentAccount;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.FileService;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.StudentService;

// import java.io.ByteArrayInputStream;
// import java.io.ByteArrayOutputStream;
// import java.io.InputStream;
// import java.io.PrintStream;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.*;

// public class DisableStudentAccountTest {

//     @BeforeEach
//     public void setUp() {
//         TestSetup.setup();
//     }

//     @Test
//     public void testDisableStudentAccount() {
//         // Simulando a entrada do usuário
//         String input = "teste";
//         InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//         System.setIn(inputStream);

//         // Capturando a saída do sistema
//         ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//         PrintStream originalOut = System.out;
//         System.setOut(new PrintStream(outContent));

//         // Executando o teste
//         DisableStudentAccount command = new DisableStudentAccount();
//         command.execute();

//         // Restaurando a entrada e a saída padrão do sistema
//         System.setOut(originalOut);

//         // Verificando se a conta do estudante foi desativada corretamente
//         StudentRepository studentRepository = StudentRepository.getInstance();
//         StudentService studentService = new StudentService(studentRepository);
//         List<Student> students = studentService.searchStudent("teste");

//         assertEquals(1, students.size());
//         assertFalse(students.get(0).isActive());
//     }
// }


// package sistemaadministrador.studentTest;

// import static org.junit.jupiter.api.Assertions.assertFalse;

// import java.io.ByteArrayInputStream;
// import java.io.InputStream;
// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.Test;

// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;

// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.DisableStudentAccount;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Name;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Password;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.UserName;

// public class DisableStudentTest {

//     @Test
//     public void testeDisableStudentSucess(){

//         String input = "teste";
//         InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//         System.setIn(inputStream);

//         int inputIndex = 0; // Este é o valor do tipo int que você quer fornecer como entrada
//         String inputIndexString = String.valueOf(inputIndex); // Convertendo o int para String
//         InputStream inputStreamIndex = new ByteArrayInputStream(inputIndexString.getBytes()); // Criando um InputStream a partir da String
//         System.setIn(inputStreamIndex); // Configurando o System.in para usar o InputStream criado

        

//         DisableStudentAccount disableStudentAccount = new DisableStudentAccount();
//         disableStudentAccount.execute();

//         assertFalse();

//     }

// //     @Test
// // public void testeDisableStudentSuccess() {
// //     // Simulando entrada do usuário para nome e índice
// //     String input = "teste\n0\n"; // Adicionando uma quebra de linha extra após o índice
// //     InputStream inputStream = new ByteArrayInputStream(input.getBytes());
// //     System.setIn(inputStream);

// //     List<Student> students = new ArrayList<>();
// //     Name name = new Name("teste");
// //     UserName username = new UserName("testeaaaaa");
// //     Password password = new Password("teste.890EF");
// //     students.add(new Student(name, password, username));
// //     System.out.println(students.get(0));

// //     DisableStudentAccount disableStudentAccount = new DisableStudentAccount();
// //     disableStudentAccount.execute();

// //     assertFalse(students.get(0).verifyStatus());
// // }


// }

package sistemaadministrador.studentTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.DisableStudentAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.FileService;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.StudentService;

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
        // Simulando a entrada do usuário
        String nome = "teste";
        int indice = 0;
        String input = nome + "\n" + indice;
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);


        // Capturando a saída do sistema
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        

        // Executando o teste
        DisableStudentAccount command = new DisableStudentAccount();
        command.execute();
        System.out.println(outContent);
        // Restaurando a entrada e a saída padrão do sistema
        System.setOut(originalOut);

        // Verificando se a conta do estudante foi desativada corretamente
        StudentRepository studentRepository = StudentRepository.getInstance();
        StudentService studentService = new StudentService(studentRepository);
        List<Student> students = studentService.searchStudent("teste");

        // assertEquals(1, students.size());
        assertFalse(students.get(0).verifyStatus());
    }
}





