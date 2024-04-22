package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Name;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Password;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.UserName;

public class User {
    private Name name;
    private Password password;
    private UserName userName;
    private boolean status;
    
    public User(Name name, Password password, UserName userName) {
        this.name = name;
        this.password = password;
        this.userName = userName;
        status = true;
    }

    public void validateUser(String nameToCheck, String userNameToCheck, String passwordToCheck){
        name.validateName(nameToCheck);
        userName.validateUserName(userNameToCheck);
        password.validatePassword(passwordToCheck);
        userName.exitsUserName(userNameToCheck);
    }

    public void updateName(String newName){
        name.updateName(newName);
    }

    public void updatePassword(String newPassword){
        password.updatePassword(newPassword);
    }

    public void updateUserName(String newUserName){
        userName.updateUserName(newUserName);
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

    public boolean modifyStatusToDisable(){
        if (!status){
            System.out.println("User already deactivated");
            return status;
        } 
        return status = false;
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
        return name.toString() + " " +  userName.toString();
    }
}
