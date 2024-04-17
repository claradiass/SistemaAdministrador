package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.manager.Controller;



public class CreateStudentAccount implements Command {
    private Controller controller;

    public CreateStudentAccount(Controller controller) {
        this.controller = controller;
    }

    public void executeCreateStudentAccount(){
        

        
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String validatingName = scanner.nextLine();

        System.out.println();

        System.out.print("Usuário: ");
        String validatingUserName = scanner.nextLine();

        System.out.println();

        System.out.print("Senha: ");
        String validatingPassword = scanner.nextLine();

        controller.createStudentAccount(validatingName, validatingUserName, validatingPassword);
    }


}
