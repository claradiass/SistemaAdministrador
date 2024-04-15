package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.manager.Controller;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Student;

import java.util.List; 

public class SearchStudent {
    private Controller controller;

    public SearchStudent(Controller controller) {
        this.controller = controller;
    }

    public void executeSearchStudent(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite aqui: ");
        String termo = scanner.nextLine();
        controller.searchStudent(termo);
        List<Student> students = controller.searchStudent(termo); 
        System.out.println(students);
    }

}
