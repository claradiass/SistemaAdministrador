package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;


public class StudentsList {
    private List<Student> studentsList;

    public StudentsList() {
        if (studentsList == null) {
            this.studentsList = new ArrayList<>();
        }
    }
    //sempre vai criar uma nova instância

    public List<Student> viewStudentsList() {
        return studentsList;
    } // private 

    public void addStudent(Student student){
        studentsList.add(student);
    }

    public void removeStudent(Student student){
        studentsList.remove(student);
    }

    public List<Student> searchStudentByUserName(String letter){
        return studentsList.stream().filter(student -> student.searchByUserName(letter)).collect(Collectors.toList());
    }

    public Student viewStudent(int id){
        return studentsList.get(id);
    }

    public void exitsUserName(String userNameToCheck) throws IllegalArgumentException {
        if(studentsList.stream().anyMatch(student -> student.exitsUserName(userNameToCheck))){
            throw new IllegalArgumentException("Username unavailable");
        }
    }

    public void disableAccount(int id){
        Student student = viewStudent(id);
        student.modifyStatusToDisable(); 
    }

    public void activeAccount(int id){
        Student student = viewStudent(id);
        student.modifyStatusToActivate(); 
    }

    public void updateStudentAccount(int id, Student student){
        int searchStudent = studentsList.indexOf(studentsList.get(id));
        if(searchStudent != -1){
            studentsList.set(searchStudent, student);
        }
    }
}
