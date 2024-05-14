package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository;

import java.io.*;
import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list.StudentsList;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;

public class FileService extends InMemoryStudent{
    private StudentsList studentsList;

    public FileService() {
        studentsList = new StudentsList();
        loadDataFromFile();
    }

    private void loadDataFromFile() {
        File data = new File("data.bin");
        if (data.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
                studentsList = (StudentsList) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            oos.writeObject(studentsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createAccount(Student student) {
        studentsList.addStudent(student);
        saveDataToFile();
    }

    public void disableAccount(int id) {
        studentsList.disableAccount(id);
        saveDataToFile();
    }

    public void activeAccount(int id) {
        studentsList.activeAccount(id);
        saveDataToFile();
    }

    public void updateUser(int idStudent, Student student) {
        studentsList.updateStudentAccount(idStudent, student);
        saveDataToFile();
    }

    public Student findById(int id) {
        return studentsList.viewStudent(id);
    }

    public List<Student> findAll() {
        return studentsList.viewStudentsList();
    }

    public List<Student> searchAccount(String termo) {
        return studentsList.searchStudentByUserName(termo);
    }
}
