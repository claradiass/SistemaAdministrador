package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.manager;

import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Student;


public interface FacadeAdministrator {
    boolean verifyAdmin(String email, String password);

    void createStudentAccount(String nome, String userName, String senha);//
    void createProfessorAccount(String userName, String nome, String senha);
    void disableStudentAccount(int idStudent);//
    void disableProfessorAccount(int idProfessor);

    List<Student> viewStudentList();//
    List<Professor> viewProfessorList();

    void updateStudentName(int id, String name);//
    void updateStudentUserName(int id, String name);
    void updateStudentPassword(int id, String name);

    void updateProfessorAccount(int idProfessor);

    List<Student> searchStudent(String usuario);//
    void searchProfessor(String usuario);



}


