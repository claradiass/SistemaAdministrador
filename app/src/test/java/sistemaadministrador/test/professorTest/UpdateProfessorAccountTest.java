package sistemaadministrador.test.professorTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.UpdateProfessorAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.professor.ProfessorService;

public class UpdateProfessorAccountTest {
    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    @Test
    public void testUpdateProfessor() {
        // Simulando a entrada do usuário
        String input = "Jaindson\n0\nNovoNome\nNovoUsuario\nNovaSenha123.";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Executando o teste
        UpdateProfessorAccount command = new UpdateProfessorAccount();
        command.execute();

        // Verificando se a conta do estudante foi atualizada corretamente
        ProfessorRepository professorRepository = ProfessorRepository.getInstance();
        ProfessorService professorService = new ProfessorService(professorRepository);
        List<Professor> professors = professorService.viewProfessorList();

        // Verificando se o nome, usuário e senha do estudante foram atualizados corretamente
        assertEquals("Nome: NovoNome Usuário: NovoUsuario status: true", professors.get(0).toString()); // Assumindo que o toString() de Professor retorna o nome
    }
}
