package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain;

import java.io.Serializable;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Name;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Password;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.UserName;

public class User implements Serializable {
    private static final long serialVersionUID = 123456789L;

    private Name name;
    private Password password;
    private UserName userName;
    private boolean status; // B maiúsculo permite o null
    
    public User(Name name, Password password, UserName userName) {
        this.name = name;
        this.password = password;
        this.userName = userName;
        this.status = true;
    }

    public String viewUserName(){
        return userName.getUserName();
    }

    public void validateUser(String nameToCheck, String userNameToCheck, String passwordToCheck){
        name.validateName(nameToCheck);
        userName.validateUserName(userNameToCheck);
        userName.exitsUserName(userNameToCheck);
        password.validatePassword(passwordToCheck);
        
    }

    public void updateUser(String newName, String newUserName, String newPassword){
        name.updateName(newName);
        userName.updateUserName(newUserName);
        password.updatePassword(newPassword);
    }

    public boolean exitsUserName(String userNameToCheck){
        return userName.exitsUserName(userNameToCheck);
    }

    public boolean searchByUserName(String termo){
        return userName.search(termo);
    }

    public boolean verifyStatus(){
        return status;
    }

    public void modifyStatusToDisable()throws IllegalArgumentException{
        if (!status){
            throw new IllegalArgumentException("User already deactivated");
        } 
        status = false;
    }

    public boolean modifyStatusToActivate(){
        if (status){
            System.out.println("User already active");
            return status;
        }
        return status = true;
    }

    @Override
    public String toString() {
        return name.toString() + " " +  userName.toString() + " status: " + verifyStatus();
    }
}
