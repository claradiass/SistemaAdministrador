package sistemaadministrador.test.studentTest;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.FileServiceStudent;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;

public class TestSetup {    
    public static void setup() {
        StudentRepository studentRepositoryy = StudentRepository.getInstance();
        studentRepositoryy.updateRepository(new FileServiceStudent());
    }
}
