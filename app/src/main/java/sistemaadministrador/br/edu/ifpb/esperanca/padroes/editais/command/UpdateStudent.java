package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.List;
import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.manager.Controller;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Student;


public class UpdateStudent implements Command {
    private Controller controller;

    public UpdateStudent(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Busque pelo nome de usuário: ");
        String termo = scanner.nextLine();
        controller.searchStudent(termo);
        List<Student> students = controller.searchStudent(termo); 
        
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                System.out.printf("[%d] - %s", i , student);
            }
        
        System.out.println("Digite aqui o indice do usuário que deseja alterar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Alterar nome?");
        System.out.println("1 - sim, 2 - não");
        int opcao1 = scanner.nextInt();
        scanner.nextLine(); 
        
        if(opcao1 == 1){
            System.out.println("Digite aqui o novo nome: ");
            String newName = scanner.nextLine();
            controller.updateStudentName(indice, newName);
        }
        System.out.println();

        System.out.println("Alterar usuário?");
        System.out.println("1 - sim, 2 - não");
        int opcao2 = scanner.nextInt();
        scanner.nextLine();
        if(opcao2 == 1){
            System.out.println("Digite aqui o novo usuário: ");
            String newUser = scanner.nextLine();
            controller.updateStudentUserName(indice, newUser);
        }

        System.out.println();

        // System.out.println("Alterar senha?");
        // System.out.println("1 - sim, 2 - não");System.out.println("Alterar senha?");
        // System.out.println("1 - sim, 2 - não");
        // int opcao3 = scanner.nextInt();
        // scanner.nextLine();
        // if(opcao3 == 1){
        //     System.out.println("Digite aqui a nova senha: ");
        //     String newName = scanner.nextLine();
        //     controller.updateStudentPassword(indice, newName);
        // }

        // System.out.println();
        // int opcao3 = scanner.nextInt();
        // scanner.nextLine();
        // if(opcao3 == 1){
        //     System.out.println("Digite aqui a nova senha: ");
        //     String newName = scanner.nextLine();
        //     controller.updateStudentPassword(indice, newName);
        // }

        // System.out.println();


    }
}
