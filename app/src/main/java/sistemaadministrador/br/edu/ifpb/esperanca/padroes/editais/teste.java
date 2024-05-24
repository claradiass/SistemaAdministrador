package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais;
import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.CommandExecute;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.CreateProfessorAccount; // Nova importação
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.DisableProfessorAccount; // Nova importação
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.LoginAdmin;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.SearchProfessorAccount; // Nova importação
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.UpdateProfessorAccount; // Nova importação
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.ViewProfessorList; // Nova importação
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.FileServiceProfessor; // Nova importação
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository; // Nova importação
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.ProfessorService; // Nova importação

public class teste {
    private static CommandExecute execute = new CommandExecute();
    private ProfessorRepository professorRepository = ProfessorRepository.getInstance(); // Mudança de StudentRepository para ProfessorRepository
    

    public void menuPrincipal() {
        professorRepository.updateRepository(new FileServiceProfessor()); // Mudança de FileServiceStudent para FileServiceProfessor
        Scanner scanner = new Scanner(System.in);

        // execute.execute(new LoginAdmin(controller));

        int op = -1;

        while (op != 7) { // Mudança do valor 6 para 7 para incluir as opções do professor
            exibirMenu();
            System.out.print("Digite a opção: ");
            op = scanner.nextInt();
            System.out.println();

            switch (op) {
                case 1:
                    execute.execute(new CreateProfessorAccount()); // Mudança de CreateStudentAccount para CreateProfessorAccount
                    break;
                case 2:
                    execute.execute(new ViewProfessorList()); // Mudança de ViewStudentList para ViewProfessorList
                    break;
                case 3:
                    execute.execute(new SearchProfessorAccount()); // Nova opção para buscar professor
                    break;
                case 4:
                    execute.execute(new DisableProfessorAccount()); // Nova opção para desativar conta de professor
                    break;
                case 5:
                    execute.execute(new UpdateProfessorAccount()); // Nova opção para atualizar dados do professor
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
        teste app = new teste();
        app.menuPrincipal();
    }
}
