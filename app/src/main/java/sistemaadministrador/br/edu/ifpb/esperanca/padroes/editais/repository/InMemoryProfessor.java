package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository;

import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list.ProfessorsList;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Professor;

public class InMemoryProfessor implements UserRepository<Professor>{
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
    public void updateUser(Professor professor) {
        // professors.updateprofessorAccount(0, null, null, null);
    }

    @Override
    public Professor findById(int id) {
        return professors.viewProfessor(id);
    }

    @Override
    public List<Professor> findAll() {
        return professors.viewProfessorsList();
    }
    
}
