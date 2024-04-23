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
        List<Student> students = controller.searchStudent(termo);

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.printf("[%d] - %s\n", i, student);
        }

        System.out.println("Digite aqui o índice do usuário que deseja alterar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite aqui o novo nome: ");
        String newName = scanner.nextLine();

        System.out.println("Digite aqui o novo usuário: ");
        String newUser = scanner.nextLine();

        System.out.println("Digite aqui a nova senha: ");
        String newPassword = scanner.nextLine();

        // Chamada do método de atualização
        controller.UpdateStudentAccount(indice, newName, newUser, newPassword);
    }

}
