package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;


public class StudentsList implements Serializable {
    private static final long serialVersionUID = 1L; // Identificador de versão para serialização
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

    public int size(String userName){
        // return studentsList.size();
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).exitsUserName(userName)) {
                return i;
            }
        }
        return -1;
    }

    public void validateUserName(String userName) throws IllegalArgumentException{
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).exitsUserName(userName)) {
                throw new IllegalArgumentException("The username cannot be existing");
            }
        }
    }

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

    public int getStudentIdByUsername(String username, int size) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).exitsUserName(username)) {
                return i;
            }
        }
        return -1; // Return -1 if no student is found
    }

    
    
}
