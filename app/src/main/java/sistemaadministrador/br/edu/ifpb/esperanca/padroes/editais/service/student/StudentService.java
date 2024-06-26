package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service.student;

import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Name;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Password;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.UserName;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;

public class StudentService implements FacadeStudent{
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudentAccount(String nome, String usuario, String senha) {

        Name name = new Name(nome);
        UserName userName = new UserName(usuario);
        Password password = new Password(senha);
        
        Student student = new Student(name, password, userName);

        try {
            student.validateStudent(nome, usuario, senha);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar conta de estudante: " + e.getMessage());
            return; 
        }

        studentRepository.createAccount(student);
    }

    @Override
    public List<Student> searchStudent(String termo) {
        return studentRepository.searchAccount(termo);
    }

    @Override
    public List<Student> viewStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public void disableStudentAccount(int id) {
        studentRepository.disableAccount(id);
    }

    @Override
    public void UpdateStudentAccount(int id, String name, String userName, String password) {
        
        Name newName = new Name(name);
        UserName newUserName = new UserName(userName);
        Password newPassword = new Password(password);
        Student studentToUpdate = new Student(newName, newPassword, newUserName);

        studentRepository.updateUser(id, studentToUpdate);
    }

    @Override
    public int getUserIdByUsername(String userName) {
        return studentRepository.getUserIdByUsername(userName);
    }

    @Override
    public void validateUserName(String userName) {
        studentRepository.validateUserName(userName);
    }   

}
