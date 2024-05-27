package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository;

import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list.ProfessorsList;

public class InMemoryProfessor implements DataService<Professor>{
    private ProfessorsList professors = new ProfessorsList();

    @Override
    public void createAccount(Professor professor) {
        professors.addProfessor(professor);
    }

    @Override
    public void disableAccount(int id) {
        professors.disableAccount(id);
    }

    @Override
    public void activeAccount(int id) {
        professors.activeAccount(id);
    }

    @Override
    public void updateUser(int idProfessor, Professor professor) {
        professors.updateProfessorAccount(idProfessor, professor);
    }

    @Override
    public Professor findById(int id) {
        return professors.viewProfessor(id);
    }

    @Override
    public List<Professor> findAll() {
        return professors.viewProfessorsList();
    }

    @Override
    public List<Professor> searchAccount(String termo) {
        return professors.searchProfessorByUserName(termo);
    }

    @Override
    public int getUserIdByUsername(String userName) {
        return professors.getUserIdByUsername(userName);
    }

    @Override
    public void validateUserName(String userName) {
        professors.validateUserName(userName);
    }

    
    
}
