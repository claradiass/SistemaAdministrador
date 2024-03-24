package br.edu.ifpb.esperanca.padroes.editais.service;

import java.util.List;

import br.edu.ifpb.esperanca.padroes.editais.facade.FacadeAdministrator;
import br.edu.ifpb.esperanca.padroes.editais.model.Professor;
import br.edu.ifpb.esperanca.padroes.editais.model.Student;

public class AdministradorService implements FacadeAdministrator{

    @Override
    public void createStudentAccount(String userName, String nome, String senha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createStudentAccount'");
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