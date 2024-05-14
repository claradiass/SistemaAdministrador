package sistemaadministrador.studentTest;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.FileService;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;

public class TestSetup {
    public static void setup() {
        StudentRepository studentRepository = StudentRepository.getInstance();
        studentRepository.updateRepository(new FileService());
    }
}
