package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.List;
import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.student.StudentService;


public class DisableStudentAccount implements Command{

    @Override
    public void execute() {
        StudentService controller = new StudentService(StudentRepository.getInstance());
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite aqui o nome: ");
        String termo = scanner.nextLine();

        List<Student> students = controller.searchStudent(termo); 
        
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                System.out.printf( "[%d] - %s\n", i, student);
            }

        System.out.print("Digite aqui o indice: ");
        int indice = scanner.nextInt();

        Student selecStudent = students.get(indice);
        String selectStudentUserName =  selecStudent.viewUserName();
        int newIndice = controller.getUserIdByUsername(selectStudentUserName);

        controller.disableStudentAccount(newIndice);
        System.out.println("Deu certo");
    }
}
