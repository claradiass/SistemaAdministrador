package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Name;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Password;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.UserName;

public class Student extends User{

    public Student(Name name, Password password, UserName userName) {
        super(name, password, userName);
    }

    public void validateStudent(String nameToCheck, String userNameToCheck, String passwordToCheck){
        super.validateUser(nameToCheck, userNameToCheck, passwordToCheck);
    }
    

}
