package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.List;
import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.StudentService;




public class DisableStudentAccount implements Command{
    private StudentService controller;

    public DisableStudentAccount(StudentService controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite aqui o nome: ");
        String termo = scanner.nextLine();
        controller.searchStudent(termo);
        List<Student> students = controller.searchStudent(termo); 
        
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                System.out.printf("[%d] - %s",i , student);
            }
        
        System.out.println("Digite aqui o indice: ");
        int indice = scanner.nextInt();

        controller.disableStudentAccount(indice);
    }


}
