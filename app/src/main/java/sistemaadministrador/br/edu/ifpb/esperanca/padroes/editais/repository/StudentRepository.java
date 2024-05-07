package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository;

import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;

public class StudentRepository {
    private DataService<Student> dataService; 
    private static StudentRepository instance;

    public StudentRepository(DataService<Student> dataService) { 
        this.dataService = dataService;
    }

    public static StudentRepository getInstance(){
        if (instance == null){
            instance = new StudentRepository(new InMemoryStudent());
        }
        return instance;
    }

    public void updateRepository(DataService<Student> dataService){
        this.dataService = dataService;
    }

    public void createAccount(Student student) {
        dataService.createAccount(student);
    }

    public void disableAccount(int id) {
        dataService.disableAccount(id);
    }

    public void activeAccount(int id) {
        dataService.activeAccount(id);
    }

    public void updateUser(int idStudent, Student student) {
        dataService.updateUser(idStudent, student);
    }

    public Student findById(int id) {
        return (Student) dataService.findById(id);
    }

    public List<Student> findAll() {
        return dataService.findAll();
    }

    public List<Student> searchAccount(String termo) {
        return dataService.searchAccount(termo);
    } 


}
