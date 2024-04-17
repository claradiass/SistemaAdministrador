package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.List;
import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.manager.Controller;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Student;




public class DisableStudentAccount implements Command{
    private Controller controller;

    public DisableStudentAccount(Controller controller) {
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
