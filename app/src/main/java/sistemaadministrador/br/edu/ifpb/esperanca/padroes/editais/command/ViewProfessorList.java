package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.professor.ProfessorService;

public class ViewProfessorList implements Command{
    @Override
    public void execute() {
        ProfessorService controller = new ProfessorService(ProfessorRepository.getInstance());
        System.out.println("lista abaixo");
        System.out.println(controller.viewProfessorList());
    }
}
