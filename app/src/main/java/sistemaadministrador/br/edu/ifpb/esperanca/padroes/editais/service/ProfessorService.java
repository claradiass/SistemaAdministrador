package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service;

import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Name;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Password;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.UserName;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.ProfessorRepository;

public class ProfessorService implements FacadeProfessor{
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public void createProfessorAccount(String usuario, String nome, String senha) {
        Name name = new Name(nome);
        UserName userName = new UserName(usuario);
        Password password = new Password(senha);
        
        Professor professor = new Professor(name, password, userName);

        // Validar o nome de usuário
        try {
            professor.validateProfessor(nome, usuario, senha);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar conta de professor: " + e.getMessage());
            return; // Sai do método se a validação falhar
        }

        professorRepository.createAccount(professor);
    }

    @Override
    public void disableProfessorAccount(int idProfessor) {
        Professor selectProfessor = professorRepository.findById(idProfessor);
        selectProfessor.modifyStatusToDisable();
        System.out.println(selectProfessor.verifyStatus());
    }

    @Override
    public List<Professor> viewProfessorList() {
        return professorRepository.findAll();
    }

    // @Override
    // public void searchProfessor(String termo) {
    //     professorsList.searchProfessorByUserName(termo);
    // }

    @Override
    public void UpdateProfessorAccount(int id, String name, String userName, String password) {
        Name newName = new Name(name);
        UserName newUserName = new UserName(userName);
        Password newPassword = new Password(password);
        Professor professorToUpdate = new Professor(newName, newPassword, newUserName);

        professorRepository.updateUser(id, professorToUpdate);
    }

    @Override
    public List<Professor> searchProfessor(String userName) {
        return professorRepository.searchAccount(userName);
    }
}
