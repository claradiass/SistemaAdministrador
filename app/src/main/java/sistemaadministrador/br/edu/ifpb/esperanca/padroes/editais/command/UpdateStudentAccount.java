package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.List;
import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.student.StudentService;


public class UpdateStudentAccount implements Command {
    

    @Override
    public void execute() {
        StudentService controller = new StudentService(StudentRepository.getInstance());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Busque pelo nome de usuário: ");
        String termo = scanner.nextLine();
        List<Student> students = controller.searchStudent(termo);

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.printf( "[%d] - %s\n", i, student);
        }

        

        System.out.println("Digite aqui o índice do usuário que deseja alterar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();
        
        
        
        Student selecStudent = students.get(indice);
        String selectStudentUserName =  selecStudent.viewUserName();
        int newIndice = controller.size(selectStudentUserName);
        



        System.out.println("Digite aqui o novo nome: ");
        String newName = scanner.nextLine();

        System.out.println("Digite aqui o novo usuário: ");
        String newUser = scanner.nextLine();

        System.out.println("Digite aqui a nova senha: ");
        String newPassword = scanner.nextLine();

        // int selectedStudentId = students.get(indice).getId();

        // Chamada do método de atualização
        
        controller.UpdateStudentAccount(newIndice, newName, newUser, newPassword);
    }

}


