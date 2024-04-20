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

    public boolean searchByUserName(String termo){
        return userName.search(termo);
    }

    @Override
    public String toString() {
        return name.toString() + " " +  userName.toString();
    }

    public boolean verifyStatus(UserName userName){
        return status;
    }

    public boolean modifyStatusToDisable(UserName userName){
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
