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
        // scanner.nextLine(); 

        controller.disableStudentAccount(indice);
    }

//     @Override
// public void execute() {
//     Scanner scanner = new Scanner(System.in);
//     StudentService controller = new StudentService(StudentRepository.getInstance());

//     System.out.println("Digite aqui o nome e o índice (separados por uma quebra de linha): ");
//     String termo = scanner.nextLine();
//     int indice = Integer.parseInt(scanner.nextLine()); // Lendo o índice como inteiro

//     List<Student> students = controller.searchStudent(termo);

//     for (int i = 0; i < students.size(); i++) {
//         Student student = students.get(i);
//         System.out.printf("[%d] - %s%n", i, student);
//     }

//     if (indice >= 0 && indice < students.size()) {
//         controller.disableStudentAccount(indice);
//     } else {
//         System.out.println("Índice inválido.");
//     }
// }


//     @Override
// public void execute() {
//     Scanner scanner = new Scanner(System.in);
//     StudentService controller = new StudentService(StudentRepository.getInstance());

//     System.out.println("Digite aqui o nome: ");
//     String termo = scanner.nextLine();
//     controller.searchStudent(termo);
//     List<Student> students = controller.searchStudent(termo); 
    
//     for (int i = 0; i < students.size(); i++) {
//         Student student = students.get(i);
//         System.out.printf("[%d] - %s", i, student);
//     }
    
//     System.out.println("Digite aqui o indice: ");
//     if (scanner.hasNextInt()) {
//         int indice = scanner.nextInt();
//         controller.disableStudentAccount(indice);
//     } else {
//         System.out.println("Índice inválido. Encerrando o processo.");
//     }
// }



}
