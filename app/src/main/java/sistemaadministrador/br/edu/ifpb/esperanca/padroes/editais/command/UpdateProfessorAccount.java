package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.List;
import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.professor.ProfessorService;

public class UpdateProfessorAccount implements Command{
    @Override
    public void execute() {
        ProfessorService controller = new ProfessorService(ProfessorRepository.getInstance());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Busque pelo nome de usuário: ");
        String termo = scanner.nextLine();
        List<Professor> professors = controller.searchProfessor(termo);

        for (int i = 0; i < professors.size(); i++) {
            Professor professor = professors.get(i);
            System.out.printf("[%d] - %s\n", i, professor);
        }

        System.out.println("Digite aqui o índice do usuário que deseja alterar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        Professor selectProfessor = professors.get(indice);
        String selectProfessorUserName =  selectProfessor.viewUserName();
        int newIndice = controller.getUserIdByUsername(selectProfessorUserName);
        

        System.out.println("Digite aqui o novo nome: ");
        String newName = scanner.nextLine();

        System.out.println("Digite aqui o novo usuário: ");
        String newUser = scanner.nextLine();

        System.out.println("Digite aqui a nova senha: ");
        String newPassword = scanner.nextLine();

        // Chamada do método de atualização
        controller.UpdateProfessorAccount(newIndice, newName, newUser, newPassword);
    }
}
