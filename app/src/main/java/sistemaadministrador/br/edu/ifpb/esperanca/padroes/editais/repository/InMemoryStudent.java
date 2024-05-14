package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository;

import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list.StudentsList;

public class InMemoryStudent implements DataService<Student>{
    protected StudentsList students = new StudentsList();

    @Override
    public void createAccount(Student student) {
        students.addStudent(student);
    }

    @Override
    public void disableAccount(int id) {
        students.disableAccount(id);
    }

    @Override
    public void activeAccount(int id) {
        students.activeAccount(id);
    }

    @Override
    public void updateUser(int idStudent, Student student) {
        students.updateStudentAccount(idStudent, student);
    }

    @Override
    public Student findById(int id) {
        return students.viewStudent(id);
    }

    @Override
    public List<Student> findAll() {
        return students.viewStudentsList();
    }

    @Override
    public List<Student> searchAccount(String termo) {
        return students.searchStudentByUserName(termo);
    }
    
}
