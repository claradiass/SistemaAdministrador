package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.AdministratorService;

public class LoginAdmin implements Command {

    @Override
    public void execute() {
        AdministratorService controller = new AdministratorService();
        Scanner scanner = new Scanner(System.in);

            System.out.print("Digite aqui o email: ");
            String email = scanner.nextLine();
            System.out.println();

            System.out.print("Digite aqui a senha: ");
            String password = scanner.nextLine();
            System.out.println();

            if(controller.verifyAdmin(email, password)){
                System.out.println("Você entrou no sistema");
                return;
            }
            System.out.println("Email e/ou senha incorretos");
    }
}
