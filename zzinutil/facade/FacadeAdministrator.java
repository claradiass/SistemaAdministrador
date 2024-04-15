package inutil.facade;

import java.util.List;

import app.src.main.java.sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.model.Professor;
import app.src.main.java.sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.model.Student;

public interface FacadeAdministrator {
    void createStudentAccount(String userName, String nome, String senha);
    void createProfessorAccount(String userName, String nome, String senha);
    void deleteStudentAccount(int idStudent);
    void deleteProfessorAccount(int idProfessor);

    List<Student> viewStudentList();
    List<Professor> viewProfessorList();

    void updateStudentAccoun(int idStudent);
    void updateProfessorAccoun(int idProfessor);


}


