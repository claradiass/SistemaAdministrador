package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.student.StudentService;

public class CreateStudentAccount implements Command {

    @Override
    public void execute() {
        StudentService controller = new StudentService(StudentRepository.getInstance());
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String validatingName = scanner.nextLine();

        System.out.println();

        System.out.print("Usuário: ");
        String validatingUserName = scanner.nextLine();

        System.out.println();

        System.out.print("Senha: ");
        String validatingPassword = scanner.nextLine();

        controller.validateUserName(validatingUserName);
        controller.createStudentAccount(validatingName, validatingUserName, validatingPassword);
        System.out.println("Sua conta foi criada com sucesso!");
    }
}
