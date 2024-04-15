package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.manager.Controller;


public class LoginAdmin {
    private Controller controller;

    public LoginAdmin(Controller controller) {
        this.controller = controller;
    }

    public void executeLoginAdmin(){
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

        while(!loggedIn){
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
                return;
            }
            System.out.println("Email e/ou senha incorretos");
            System.out.println();
        }
    }
}
