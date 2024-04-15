package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.manager;

import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Email;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Name;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Password;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.UserName;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Administrador;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.ProfessorsList;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Student;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.StudentsList;




public class Controller implements FacadeAdministrator{
    private StudentsList studentsList = new StudentsList();
    private ProfessorsList professorsList = new ProfessorsList();
    

    @Override
    public void createStudentAccount(String nome, String usuario, String senha) {

        boolean exitsUserName = studentsList.exitsUserName(usuario);
        if (exitsUserName) {
            System.out.println("O nome de usuário já está em uso. Por favor, escolha outro.");
            return; // Saímos do método se o nome de usuário estiver em uso
        }

        Name name = new Name(nome);
        name.validateName(nome); //validador apenas com null
        Password password = new Password(senha);
        password.validatePassword(senha);
        UserName userName = new UserName(usuario);
        userName.validateUserName(usuario);

        Student student = new Student(name, password, userName);
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
        selectStudent.updateNameStudent(name);
    }

    @Override
    public void updateStudentUserName(int id, String name) {
        Student selectStudent = studentsList.viewStudent(id);
        selectStudent.updateUserNameStudent(name);
    }

    @Override
    public void updateStudentPassword(int id, String name) {
        Student selectStudent = studentsList.viewStudent(id);
        selectStudent.updatePasswordStudent(name);
    }

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
    public void createProfessorAccount(String usuario, String nome, String senha) {
        Name name = new Name(nome);
        Password password = new Password(senha);
        UserName userName = new UserName(usuario);

        Professor professor = new Professor(name, password, userName);
        professorsList.addProfessor(professor);
    }

    @Override
    public void disableProfessorAccount(int idProfessor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProfessorAccount'");
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
    public void updateProfessorAccount(int idProfessor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProfessorAccoun'");
    }
}
