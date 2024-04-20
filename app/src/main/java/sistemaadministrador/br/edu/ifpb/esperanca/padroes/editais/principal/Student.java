package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Name;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Password;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.UserName;

public class Student{

    private Name name;
    private Password password;
    private UserName userName;
    private boolean status;
    
    public Student(Name name, Password password, UserName userName) {
        this.name = name;
        this.password = password;
        this.userName = userName;
        status = true;
    }

    public Boolean searchByUserName(String termo){
        return userName.search(termo);
    }
    

    public boolean exitsUserName(String userNameToCheck){
        return userName.exitsUserName(userNameToCheck);
    }


    @Override
    public String toString() {
        return name.toString() + " " +  userName.toString();
    }

    public boolean verifyStatus(){
        return status;
    }

    public void updateNameStudent(String newName){
        name.updateName(newName);
    }

    public void updateUserNameStudent(String newUserName){
        userName.updateUserName(newUserName);
    }

    public void updatePasswordStudent(String newPassword){
        password.updatePassword(newPassword);
    }

    public boolean modifyStatusToDisable(){
        if (!status){
            System.out.println("Usuário já desativado");
            return status;
        } 
        return status = false;
    }

    public boolean modifyStatusToActivate(UserName userName){
        if (status){
            System.out.println("Usuário já ativo");
            return status;
        }
        return status = true;
    }

    

}
