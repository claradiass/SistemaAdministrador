package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais;
import java.util.Scanner;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.CommandExecute;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.CreateStudentAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.CreateProfessorAccount; 
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.DisableStudentAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.DisableProfessorAccount; 
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.SearchStudentAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.SearchProfessorAccount; 
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.UpdateStudentAccount;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.UpdateProfessorAccount; 
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.ViewStudentList;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.ViewProfessorList; 
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.FileServiceStudent;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.FileServiceProfessor; 
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository; 
public class App {
    private static CommandExecute execute = new CommandExecute();
    private StudentRepository studentRepository = StudentRepository.getInstance();
    private ProfessorRepository professorRepository = ProfessorRepository.getInstance(); 
    

    public void menuPrincipal() {
        studentRepository.updateRepository(new FileServiceStudent());
        professorRepository.updateRepository(new FileServiceProfessor()); 
        Scanner scanner = new Scanner(System.in);

        int op = -1;

        while (op != 11) { 
            exibirMenu();
            System.out.print("Digite a opção: ");
            op = scanner.nextInt();
            System.out.println();

            switch (op) {
                case 1:
                    execute.execute(new CreateStudentAccount());
                    break;
                case 2:
                    execute.execute(new ViewStudentList());
                    break;
                case 3:
                    execute.execute(new SearchStudentAccount());
                    break;
                case 4:
                    execute.execute(new DisableStudentAccount());
                    break;
                case 5:
                    execute.execute(new UpdateStudentAccount());
                    break;
                case 6: 
                    execute.execute(new CreateProfessorAccount());
                    break;
                case 7:
                    execute.execute(new ViewProfessorList());
                    break;
                case 8:
                    execute.execute(new SearchProfessorAccount());
                    break;
                case 9:
                    execute.execute(new DisableProfessorAccount());
                    break;
                case 10:
                    execute.execute(new UpdateProfessorAccount());
                    break;
                case 11:
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
        System.out.println("6. Criar conta de professor");
        System.out.println("7. Visualizar lista de professores");
        System.out.println("8. Procurar professor");
        System.out.println("9. Desativar conta de professor");
        System.out.println("10. Atualizar dados do professor");
        System.out.println("11. Sair do sistema");
        System.out.println("--------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        App app = new App();
        app.menuPrincipal();
    }
}
