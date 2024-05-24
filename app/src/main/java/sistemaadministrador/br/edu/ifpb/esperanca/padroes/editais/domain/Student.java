package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain;


import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Name;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Password;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.UserName;

public class Student extends User {

    public Student(Name name, Password password, UserName userName) {
        super(name, password, userName);
    }

    public void validateStudent(String nameToCheck, String userNameToCheck, String passwordToCheck){
        super.validateUser(nameToCheck, userNameToCheck, passwordToCheck);
    }

    public void updateStudent (String newName, String newUserName, String newPassword){
        super.updateUser(newName, newUserName, newPassword);
    }
    

}
