package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.AdministratorService;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.StudentService;


public class LoginAdmin implements Command {

    

    @Override
    public void execute() {
        AdministratorService controller = new AdministratorService();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

        // while(!loggedIn){
            System.out.println("Digite aqui o email: ");
            String email = scanner.nextLine();
            System.out.println();

            System.out.println("Digite aqui a senha: ");
            String password = scanner.nextLine();
            System.out.println();

            if(controller.verifyAdmin(email, password)){
                System.out.println("Você entrou no sistema");
                System.out.println();
                loggedIn = true;
                scanner.close();
                return;
            }
            System.out.println("Email e/ou senha incorretos");
            System.out.println();
        // }
        scanner.close();
    }
}
