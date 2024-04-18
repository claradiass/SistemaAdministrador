package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais;
import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.CommandExecute;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.CreateStudentAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.DisableStudentAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.LoginAdmin;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.SearchStudent;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.UpdateStudent;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.ViewStudentList;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.manager.Controller;

public class App {
    private static Controller controller = new Controller();
    private static CommandExecute execute = new CommandExecute();
    
    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);

        // execute.execute(new LoginAdmin(controller));

        int op = -1;

        while (op != 6) {
            exibirMenu();
            System.out.print("Digite a opção: ");
            op = scanner.nextInt();
            System.out.println();

            switch (op) {
                case 1:
                    execute.execute(new CreateStudentAccount(controller));
                    break;
                case 2:
                    execute.execute(new ViewStudentList(controller));
                    break;
                case 3:
                    execute.execute(new SearchStudent(controller));
                    break;
                case 4:
                    execute.execute(new DisableStudentAccount(controller));
                    break;
                case 5:
                    execute.execute(new UpdateStudent(controller));
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("----------------------------- Menu Principal -----------------------------");
        System.out.println("1. Criar conta de aluno");
        System.out.println("2. Visualizar lista de alunos");
        System.out.println("3. Procurar aluno");
        System.out.println("4. Desativar conta de aluno");
        System.out.println("5. Atualizar dados do aluno");
        System.out.println("6. Sair do sistema");
        System.out.println("--------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        App app = new App();
        app.menuPrincipal();
    }
}

