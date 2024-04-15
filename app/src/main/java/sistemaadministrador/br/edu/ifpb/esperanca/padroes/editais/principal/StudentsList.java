package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    //para cada objeto student, verifique se o método search retorna verdadeiro para o termo de pesquisa fornecido
    public List<Student> searchStudentByUserName(String letter){
        return studentsList.stream().filter(student -> student.searchByUserName(letter)).collect(Collectors.toList());
    }

    public Student viewStudent(int id){    
        // if(studentsList.get(id).verifyStatus() == false){
        //     return studentsList.get(id);
        // }
        return studentsList.get(id);
    }

    public boolean exitsUserName(String userName){
        return studentsList.stream().anyMatch(student -> student.exitsUserName(userName));
    }


}
