package sistemaadministrador.test.professorTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.ViewProfessorList;

public class ViewProfessorListTest {
    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    @Test
    public void lista(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream outOriginal = System.out;

        System.setOut(new PrintStream(outContent));

        ViewProfessorList viewProfessorList = new ViewProfessorList();
        viewProfessorList.execute();

        System.setOut(outOriginal);

        assertTrue(outContent.toString().contains("Jaindson"));
    }
}
