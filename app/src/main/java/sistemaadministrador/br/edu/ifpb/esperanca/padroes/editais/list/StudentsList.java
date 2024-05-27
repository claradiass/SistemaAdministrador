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

    public List<Student> viewStudentsList() {
        return studentsList;
    }  

    public int getUserIdByUsername(String userName){
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
        Student student = studentsList.get(id);
        System.out.println(student.viewUserName());
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
