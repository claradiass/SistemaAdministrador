package sistemaadministrador.test.professorTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.DisableProfessorAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.professor.ProfessorService;

public class DisableProfessorAccountTest {
    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    public void teste(){

    }

    @Test
    public void TestDisable(){
        String name = "Jai"; // teste para dar certo>
        int indice = 0;
        String input = name + "\n" + indice;

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        DisableProfessorAccount disableProfessorAccount = new DisableProfessorAccount();
        disableProfessorAccount.execute();

        System.setOut(originalOut);

        ProfessorRepository professorRepository = ProfessorRepository.getInstance();
        ProfessorService professorService = new ProfessorService(professorRepository);
        List<Professor> professors = professorService.searchProfessor("");

        System.out.println(professors);

        assertFalse(professors.get(0).verifyStatus());



        //PARA PEGAR O MESMA LISTA FIZ O DOIS TESTES EM UMA MESMA CLASSE
        // teste que tem que dar errado >


        String nome2 = "Jaindson";
        int indice2 = 0;
        String input2 = nome2 + "\n" + indice2;
        InputStream inputStream2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(inputStream2);

        // Capturando a saída do sistema
        ByteArrayOutputStream outContent2 = new ByteArrayOutputStream();
        PrintStream originalOut2 = System.out;
        System.setOut(new PrintStream(outContent2));

        DisableProfessorAccount command = new DisableProfessorAccount();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute();
        });

        // Restaurando a entrada e a saída padrão do sistema
        System.setOut(originalOut2);

        // Verificando se a conta do professor foi desativada corretamente

        // Supondo que o professor com índice 1 é o que estamos desativando
        assertFalse(professors.get(0).verifyStatus());
        assertEquals("User already deactivated", exception.getMessage());
    }

    
}
