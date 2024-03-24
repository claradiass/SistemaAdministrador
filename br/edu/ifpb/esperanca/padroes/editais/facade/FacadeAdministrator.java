package br.edu.ifpb.esperanca.padroes.editais.facade;

import java.util.List;

import br.edu.ifpb.esperanca.padroes.editais.model.Professor;
import br.edu.ifpb.esperanca.padroes.editais.model.Student;

public interface FacadeAdministrator {
    void createStudentAccount(String userName, String nome, String senha);
    void createProfessorAccount(String userName, String nome, String senha);
    void deleteStudentAccount(int idStudent);
    void deleteProfessorAccount(int idProfessor);

    List<Student> viewStudentList();
    List<Professor> viewProfessorList();

    void updateStudentAccoun(int idStudent);
    void updateProfessorAccoun(int idProfessor);



    //não se deleta, suspende
}


