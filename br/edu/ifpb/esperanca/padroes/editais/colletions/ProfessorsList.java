package br.edu.ifpb.esperanca.padroes.editais.colletions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifpb.esperanca.padroes.editais.model.Professor;

public class ProfessorsList {
    private List<Professor> professorsList;

    public ProfessorsList() {
        this.professorsList = new ArrayList<>();
    }

    public List<Professor> viewProfessorsList() {
        return professorsList;
    }

    public void addStudent(Professor professor){
        professorsList.add(professor);
    }

    public void removeStudent(Professor professor){
        professorsList.remove(professor);
    }

    //para cada objeto student, verifique se o método search retorna verdadeiro para o termo de pesquisa fornecido
    public List<Professor> searchStudentByUserName(String letter){
        return professorsList.stream().filter(professor -> professor.searchByUserName(letter)).collect(Collectors.toList());
    }


}
