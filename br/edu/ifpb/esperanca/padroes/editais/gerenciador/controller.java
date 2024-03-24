package br.edu.ifpb.esperanca.padroes.editais.gerenciador;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.esperanca.padroes.editais.model.Professor;
import br.edu.ifpb.esperanca.padroes.editais.model.Student;



public class controller {
    private List<Student> students = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();

    public controller(List<Student> students, List<Professor> professores) {
        this.students = students;
        this.professores = professores;
    }

    public void addStudent(List<Student> students, Student student){
        students.add(student);
    }   

    public void addProfessor(List<Professor> professores, Professor professor){
        professores.add(professor);
    }

    public void removeStudent(List<Student> students, Student student){
        students.remove(student);
    }

}
