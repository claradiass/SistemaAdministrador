package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.manager.Controller;

public class ViewStudentList {
    private Controller controller;

    public ViewStudentList(Controller controller) {
        this.controller = controller;
    }

    public void executeviewStudentList(){
        System.out.println("lista abaixo");
        System.out.println(controller.viewStudentList());
    }
}
