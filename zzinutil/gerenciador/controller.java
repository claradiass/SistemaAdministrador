package zzinutil.gerenciador;

import java.util.ArrayList;
import java.util.List;

import app.src.main.java.sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.colletions.StudentsList;
import app.src.main.java.sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.facade.FacadeAdministrator;
import app.src.main.java.sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.model.Name;
import app.src.main.java.sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.model.Password;
import app.src.main.java.sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.model.Professor;
import app.src.main.java.sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.model.Student;
import app.src.main.java.sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.model.UserName;



public class controller implements FacadeAdministrator{

    @Override
    public void createStudentAccount(String usuario, String nome, String senha) {
        Name name = new Name(nome);
        Password password = new Password(senha);
        UserName userName = new UserName(usuario);

        Student student = new Student(name, password, userName);

        StudentsList studentsList = new StudentsList();
        
    }




    @Override
    public void createProfessorAccount(String userName, String nome, String senha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProfessorAccount'");
    }

    @Override
    public void deleteStudentAccount(int idStudent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStudentAccount'");
    }

    @Override
    public void deleteProfessorAccount(int idProfessor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProfessorAccount'");
    }

    @Override
    public List<Student> viewStudentList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewStudentList'");
    }

    @Override
    public List<Professor> viewProfessorList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewProfessorList'");
    }

    @Override
    public void updateStudentAccoun(int idStudent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStudentAccoun'");
    }

    @Override
    public void updateProfessorAccoun(int idProfessor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProfessorAccoun'");
    }
    

}
