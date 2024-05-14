package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.List;
import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.ProfessorService;

public class SearchProfessor implements Command{

    @Override
    public void execute() {
        ProfessorService controller = new ProfessorService(ProfessorRepository.getInstance());
        Scanner scanner = new Scanner(System.in);


        // controller.createStudentAccount("ana", "Ana Clara", "ana.098KKKKK");


        System.out.print("Digite aqui: ");
        String termo = scanner.nextLine();
        controller.searchProfessor(termo);
        List<Professor> professors = controller.searchProfessor(termo); 
        for (Professor professor : professors) {
            System.out.print("Conta: " + professor.toString());
        }


    }
    
}
