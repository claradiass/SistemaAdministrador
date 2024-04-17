package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.manager.Controller;

public class ViewStudentList implements Command{
    private Controller controller;

    public ViewStudentList(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        System.out.println("lista abaixo");
        System.out.println(controller.viewStudentList());
    }
}
