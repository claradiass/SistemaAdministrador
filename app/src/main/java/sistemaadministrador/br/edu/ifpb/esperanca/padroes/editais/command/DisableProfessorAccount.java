package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.List;
import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.professor.ProfessorService;

public class DisableProfessorAccount implements Command{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        ProfessorService controller = new ProfessorService(ProfessorRepository.getInstance());

        System.out.print("Digite aqui o nome: ");
        String termo = scanner.nextLine();
        controller.searchProfessor(termo);
        List<Professor> professors = controller.searchProfessor(termo); 
        
            for (int i = 0; i < professors.size(); i++) {
                Professor professor = professors.get(i);
                System.out.printf("[%d] - %s\n",i , professor);
            }

        System.out.print("Digite aqui o indice: ");
        int indice = scanner.nextInt();

        Professor selectProfessor = professors.get(indice);
        String selectProfessorUserName =  selectProfessor.viewUserName();
        int newIndice = controller.getUserIdByUsername(selectProfessorUserName);

        controller.disableProfessorAccount(newIndice);
    }
}
