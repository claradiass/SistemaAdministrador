package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.student;

import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;

public interface FacadeStudent {
    void createStudentAccount(String nome, String userName, String senha);
    void disableStudentAccount(int id);
    List<Student> viewStudentList();
    void UpdateStudentAccount(int id, String newName, String newUserName, String newPassword);
    List<Student> searchStudent(String usuario);
    int getUserIdByUsername(String userName);
    void validateUserName(String userName);
}


