package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service;

import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;

public interface FacadeProfessor {
    void createProfessorAccount(String userName, String nome, String senha);
    void disableProfessorAccount(Professor selectProfessor);
    List<Professor> viewProfessorList();
    void UpdateProfessorAccount(int id, String newName, String newUserName, String newPassword);
    List<Professor> searchProfessor(String userName);
    int getStudentIdByUsername(String username);

}