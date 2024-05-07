// package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.manager;

// import java.util.List;

// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list.ProfessorsList;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list.StudentsList;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Email;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Name;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Password;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.UserName;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Administrador;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Professor;
// import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal.Student;




// public class Controller implements FacadeAdministrator{
//     private StudentsList studentsList = new StudentsList();
//     private ProfessorsList professorsList;

//     @Override
//     public boolean verifyAdmin(String writeEmail, String writePassword) {
//         Administrador newAdministrador = new Administrador();
//         Email email = new Email(writeEmail);
//         Password password = new Password(writePassword);

//         if(newAdministrador.validateEmail(email) && newAdministrador.validatePassword(password)){
//             return true;
//         }
        
//         return false;
        
//     }

//     @Override
//     public void createStudentAccount(String nome, String usuario, String senha) {

//         Name name = new Name(nome);
//         UserName userName = new UserName(usuario);
//         Password password = new Password(senha);
        
//         Student student = new Student(name, password, userName);

//         // Validar o nome de usuário
//         try {
//             student.validateStudent(nome, usuario, senha);
//         } catch (IllegalArgumentException e) {
//             System.out.println("Erro ao criar conta de estudante: " + e.getMessage());
//             return; // Sai do método se a validação falhar
//         }

//         studentsList.addStudent(student);
//     }

//     @Override
//     public List<Student> searchStudent(String termo) {
//         return studentsList.searchStudentByUserName(termo);
//     }

//     @Override
//     public List<Student> viewStudentList() {
//         return studentsList.viewStudentsList();
//     }

//     @Override
//     public void disableStudentAccount(int idStudent) {
//         Student selectStudent = studentsList.viewStudent(idStudent);
//         selectStudent.modifyStatusToDisable();
//         System.out.println(selectStudent.verifyStatus());
//     }

//     @Override
//     public void UpdateStudentAccount(int id, String name, String userName, String password) {
//         Name newName = new Name(name);
//         UserName newUserName = new UserName(userName);
//         Password newPassword = new Password(password);
//         Student studentToUpdate = new Student(newName, newPassword, newUserName);

//         studentsList.updateStudentAccount(id, studentToUpdate);
//     }

// // **************************************************************************************** mudar isso

//     @Override
//     public void createProfessorAccount(String usuario, String nome, String senha) {
//         Name name = new Name(nome);
//         UserName userName = new UserName(usuario);
//         Password password = new Password(senha);
        
//         Professor professor = new Professor(name, password, userName);

//         // Validar o nome de usuário
//         try {
//             professor.validateProfessor(nome, usuario, senha);
//         } catch (IllegalArgumentException e) {
//             System.out.println("Erro ao criar conta de professor: " + e.getMessage());
//             return; // Sai do método se a validação falhar
//         }

//         professorsList.addProfessor(professor);
//     }

//     @Override
//     public void disableProfessorAccount(int idProfessor) {
//         Professor selectProfessor = professorsList.viewProfessor(idProfessor);
//         selectProfessor.modifyStatusToDisable();
//         System.out.println(selectProfessor.verifyStatus());
//     }

//     @Override
//     public List<Professor> viewProfessorList() {
//         return professorsList.viewProfessorsList();
//     }

//     @Override
//     public void searchProfessor(String termo) {
//         professorsList.searchProfessorByUserName(termo);
//     }

//     @Override
//     public void UpdateProfessorAccount(int id, String name, String userName, String password) {
//         Name newName = new Name(name);
//         UserName newUserName = new UserName(userName);
//         Password newPassword = new Password(password);
//         Professor professorToUpdate = new Professor(newName, newPassword, newUserName);

//         professorsList.updateProfessorAccount(id, professorToUpdate);
//     }
// }



package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service;

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

        // Validar o nome de usuário
        try {
            student.validateStudent(nome, usuario, senha);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar conta de estudante: " + e.getMessage());
            return; // Sai do método se a validação falhar
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
    public void disableStudentAccount(int idStudent) {
        Student selectStudent = studentRepository.findById(idStudent);
        selectStudent.modifyStatusToDisable();
        System.out.println(selectStudent.verifyStatus());
    }

    @Override
    public void UpdateStudentAccount(int id, String name, String userName, String password) {
        Name newName = new Name(name);
        UserName newUserName = new UserName(userName);
        Password newPassword = new Password(password);
        Student studentToUpdate = new Student(newName, newPassword, newUserName);

        studentRepository.updateUser(id, studentToUpdate);
    }

}
