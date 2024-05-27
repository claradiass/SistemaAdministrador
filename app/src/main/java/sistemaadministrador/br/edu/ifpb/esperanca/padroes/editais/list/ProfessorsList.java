package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;


public class ProfessorsList implements Serializable {
    private static final long serialVersionUID = 1L; // Identificador de versão para serialização
    private List<Professor> professorsList;

    public ProfessorsList() {
        if (professorsList == null) {
            this.professorsList = new ArrayList<>();
        }
    }

    public List<Professor> viewProfessorsList() {
        return professorsList;
    }

    public void addProfessor(Professor professor){
        professorsList.add(professor);
    }

    public void removeProfessor(Professor professor){
        professorsList.remove(professor);
    }

    //para cada objeto Professor, verifique se o método search retorna verdadeiro para o termo de pesquisa fornecido
    public List<Professor> searchProfessorByUserName(String letter){
        return professorsList.stream().filter(professor -> professor.searchByUserName(letter)).collect(Collectors.toList());
    }

    public Professor viewProfessor(int id){
        return professorsList.get(id);
    }

    public void exitsUserName(String userNameToCheck) throws IllegalArgumentException {
        if(professorsList.stream().anyMatch(professor -> professor.exitsUserName(userNameToCheck))){
            throw new IllegalArgumentException("Username unavailable");
        }
    }

    public void disableAccount(int id){
        Professor professor = viewProfessor(id);
        professor.modifyStatusToDisable(); 
    }

    public void activeAccount(int id){
        Professor professor = viewProfessor(id);
        professor.modifyStatusToActivate(); 
    }

    public void updateProfessorAccount(int id, Professor professor){
        int searchProfessor = professorsList.indexOf(professorsList.get(id));
        if(searchProfessor != -1){
            professorsList.set(searchProfessor, professor);
        }
    }

    public int size(String userName){
        for (int i = 0; i < professorsList.size(); i++) {
            System.out.println("Comparing: " + professorsList.get(i).viewUserName() + " with " + userName);
            if (professorsList.get(i).exitsUserName(userName)) {
                return i;
            }
        }
        return -1;
    }

    public void validateUserName(String userName) throws IllegalArgumentException{
        for (int i = 0; i < professorsList.size(); i++) {
            if (professorsList.get(i).exitsUserName(userName)) {
                throw new IllegalArgumentException("The username cannot be existing");
            }
        }
    }

    public int getProfessorIdByUsername(String username) {
        for (int i = 0; i < professorsList.size(); i++) {
            System.out.println("Comparing: " + professorsList.get(i).viewUserName() + " with " + username);
            if (professorsList.get(i).exitsUserName(username)) {
                return i;
            }
        }
        return -1; // Return -1 if no student is found
    }
}
