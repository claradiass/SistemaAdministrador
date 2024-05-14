package sistemaadministrador.studentTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.LoginAdmin;

public class LoginAdminTeste {

    @Test
    public void testLoginAdminSuccess() {
        String input = "adm@gmail.com\nadm123.OI\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        LoginAdmin command = new LoginAdmin();
        command.execute();

        System.setOut(originalOut);

        assertTrue(outContent.toString().contains("Você entrou no sistema"));
    }

    @Test
    public void testLoginAdminInvalidCredentials() {
        String input = "admin@example.com\nwrongpassword.8U\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        LoginAdmin command = new LoginAdmin();
        command.execute();

        System.setOut(originalOut);

        assertTrue(outContent.toString().contains("Email e/ou senha incorretos"));
    }
}
