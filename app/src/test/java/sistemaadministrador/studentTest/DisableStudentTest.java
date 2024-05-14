package sistemaadministrador.studentTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.DisableStudentAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Name;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Password;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.UserName;

public class DisableStudentTest {
    @Test
    public void testeDisableStudentSucess(){

        String input = "ana";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        int inputIndex = 0; // Este é o valor do tipo int que você quer fornecer como entrada
        String inputIndexString = String.valueOf(inputIndex); // Convertendo o int para String
        InputStream inputStreamIndex = new ByteArrayInputStream(inputIndexString.getBytes()); // Criando um InputStream a partir da String
        System.setIn(inputStreamIndex); // Configurando o System.in para usar o InputStream criado

        List<Student> students = new ArrayList<>();
        Name name = new Name("ana");
        UserName username = new UserName("anaaaaaa");
        Password password = new Passwosrd("ana.890EF");
        students.add(new Student(name, password, username));
        System.out.println(students.get(0));

        DisableStudentAccount disableStudentAccount = new DisableStudentAccount();
        disableStudentAccount.execute();

        assertFalse(students.get(0).verifyStatus());

    }

//     @Test
// public void testeDisableStudentSuccess() {
//     // Simulando entrada do usuário para nome e índice
//     String input = "ana\n0\n"; // Adicionando uma quebra de linha extra após o índice
//     InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//     System.setIn(inputStream);

//     List<Student> students = new ArrayList<>();
//     Name name = new Name("ana");
//     UserName username = new UserName("anaaaaaa");
//     Password password = new Password("ana.890EF");
//     students.add(new Student(name, password, username));
//     System.out.println(students.get(0));

//     DisableStudentAccount disableStudentAccount = new DisableStudentAccount();
//     disableStudentAccount.execute();

//     assertFalse(students.get(0).verifyStatus());
// }


}



