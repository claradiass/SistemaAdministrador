package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.manager;

import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list.ProfessorsList;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list.StudentsList;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Email;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Name;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Password;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.UserName;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Administrador;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Student;




public class Controller implements FacadeAdministrator{
    private StudentsList studentsList = new StudentsList();
    private ProfessorsList professorsList = new ProfessorsList();

    @Override
    public boolean verifyAdmin(String writeEmail, String writePassword) {
        Administrador newAdministrador = new Administrador();
        Email email = new Email(writeEmail);
        Password password = new Password(writePassword);

        if(newAdministrador.validateEmail(email) && newAdministrador.validatePassword(password)){
            return true;
        }
        
        return false;
        
    }

    @Override
    public void createStudentAccount(String nome, String usuario, String senha) {

        Name name = new Name(nome);
        UserName userName = new UserName(usuario);
        Password password = new Password(senha);
        
        Student student = new Student(name, password, userName);

        // Validar o nome de usuário
        try {
            student.validateStudent(nome, usuario, senha);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar conta de estudante: " + e.getMessage());
            return; // Sai do método se a validação falhar
        }

        studentsList.addStudent(student);
    }

    @Override
    public List<Student> searchStudent(String termo) {
        return studentsList.searchStudentByUserName(termo);
    }

    @Override
    public List<Student> viewStudentList() {
        return studentsList.viewStudentsList();
    }

    @Override
    public void disableStudentAccount(int idStudent) {
        Student selectStudent = studentsList.viewStudent(idStudent);
        selectStudent.modifyStatusToDisable();
        System.out.println(selectStudent.verifyStatus());
    }

    @Override
    public void updateStudentName(int id, String name) {
        Student selectStudent = studentsList.viewStudent(id);
        selectStudent.updateName(name);
    }

    @Override
    public void updateStudentUserName(int id, String name) {
        Student selectStudent = studentsList.viewStudent(id);
        selectStudent.updateUserName(name);
    }

    @Override
    public void updateStudentPassword(int id, String name) {
        Student selectStudent = studentsList.viewStudent(id);
        selectStudent.updatePassword(name);
    }

// **************************************************************************************** mudar isso

    @Override
    public void createProfessorAccount(String usuario, String nome, String senha) {
        Name name = new Name(nome);
        UserName userName = new UserName(usuario);
        Password password = new Password(senha);
        
        Professor professor = new Professor(name, password, userName);

        // Validar o nome de usuário
        try {
            professor.validateProfessor(nome, usuario, senha);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar conta de professor: " + e.getMessage());
            return; // Sai do método se a validação falhar
        }

        professorsList.addProfessor(professor);
    }

    @Override
    public void disableProfessorAccount(int idProfessor) {
        Professor selectProfessor = professorsList.viewProfessor(idProfessor);
        selectProfessor.modifyStatusToDisable();
        System.out.println(selectProfessor.verifyStatus());
    }

    @Override
    public List<Professor> viewProfessorList() {
        return professorsList.viewProfessorsList();
    }

    @Override
    public void searchProfessor(String termo) {
        professorsList.searchProfessorByUserName(termo);
    }

    @Override
    public void updateProfessorName(int id, String name) {
        Professor selectProfessor = professorsList.viewProfessor(id);
        selectProfessor.updateName(name);
    }

    @Override
    public void updateProfessorUserName(int id, String name) {
        Professor selectProfessor = professorsList.viewProfessor(id);
        selectProfessor.updateUserName(name);
    }

    @Override
    public void updateProfessorPassword(int id, String name) {
        Professor selectProfessor = professorsList.viewProfessor(id);
        selectProfessor.updatePassword(name);
    }
}
