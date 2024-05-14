package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.ProfessorService;

public class CreateProfessorAccount implements Command{
    @Override
    public void execute() {
        ProfessorService controller = new ProfessorService(ProfessorRepository.getInstance());
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String validatingName = scanner.nextLine();

        System.out.println();

        System.out.print("Usuário: ");
        String validatingUserName = scanner.nextLine();

        System.out.println();

        System.out.print("Senha: ");
        String validatingPassword = scanner.nextLine();

        controller.createProfessorAccount(validatingName, validatingUserName, validatingPassword);
        System.out.println("Sua conta foi criada com sucesso!");
    }
}
