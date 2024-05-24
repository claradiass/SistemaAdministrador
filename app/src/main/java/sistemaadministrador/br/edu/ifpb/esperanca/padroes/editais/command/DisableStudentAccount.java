package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.List;
import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.StudentService;




public class DisableStudentAccount implements Command{

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        StudentService controller = new StudentService(StudentRepository.getInstance());

        System.out.print("Digite aqui o nome: ");
        String termo = scanner.nextLine();
        controller.searchStudent(termo);
        List<Student> students = controller.searchStudent(termo); 
        
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                System.out.printf("[%d] - %s",i , student);
            }
        
        
        System.out.print("Digite aqui o indice: ");
        int indice = scanner.nextInt();
        Student selecStudent = students.get(indice);
        // scanner.nextLine(); 

        controller.disableStudentAccount(selecStudent);
    }



}
