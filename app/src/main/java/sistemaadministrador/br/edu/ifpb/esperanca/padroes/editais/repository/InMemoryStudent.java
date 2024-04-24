package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository;

import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list.StudentsList;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Student;

public class InMemoryStudent implements UserRepository<Student>{
    private StudentsList students = new StudentsList();

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
    public void updateUser(Student student) {
        // students.updateStudentAccount(0, null, null, null);
    }

    @Override
    public Student findById(int id) {
        return students.viewStudent(id);
    }

    @Override
    public List<Student> findAll() {
        return students.viewStudentsList();
    }
    
}
