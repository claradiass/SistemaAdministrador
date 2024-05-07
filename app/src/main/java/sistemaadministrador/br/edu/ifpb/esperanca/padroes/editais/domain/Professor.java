package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Name;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Password;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.UserName;

public class Professor extends User{

    public Professor(Name name, Password password, UserName userName) {
        super(name, password, userName);
    }

    public void validateProfessor(String nameToCheck, String userNameToCheck, String passwordToCheck){
        super.validateUser(nameToCheck, userNameToCheck, passwordToCheck);
    }

    public void updateProfessor(String newName, String newUserName, String newPassword){
        super.updateUser(newName, newUserName, newPassword);
    }

}
