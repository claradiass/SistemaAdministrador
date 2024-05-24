package sistemaadministrador.test.professorTest;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.FileServiceProfessor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository;

public class TestSetup {
    public static void setup() {
        ProfessorRepository professorRepository = ProfessorRepository.getInstance();
        professorRepository.updateRepository(new FileServiceProfessor());
    }
}
