package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.FileServiceStudent;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.StudentService;

import java.util.List; 

public class SearchStudentAccount implements Command{

    private StudentRepository studentRepository = StudentRepository.getInstance();
    

    @Override
    public void execute() {
        StudentService controller = new StudentService(StudentRepository.getInstance());
        studentRepository.updateRepository(new FileServiceStudent());
        Scanner scanner = new Scanner(System.in);


        // controller.createStudentAccount("ana", "Ana Clara", "ana.098KKKKK");


        System.out.print("Digite aqui: ");
        String termo = scanner.nextLine();
        controller.searchStudent(termo);
        List<Student> students = controller.searchStudent(termo); 
        for (Student student : students) {
            System.out.print("Conta: " + student.toString());
        }
    }

}
