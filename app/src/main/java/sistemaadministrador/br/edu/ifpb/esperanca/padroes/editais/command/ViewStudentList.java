package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.student.StudentService;

public class ViewStudentList implements Command{

    @Override
    public void execute() {
        StudentService controller = new StudentService(StudentRepository.getInstance());
        System.out.println("lista abaixo");
        System.out.println(controller.viewStudentList());
    }
}
