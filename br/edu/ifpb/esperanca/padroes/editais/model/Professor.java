package br.edu.ifpb.esperanca.padroes.editais.model;

public class Professor {

    private Name name;
    private Password password;
    private UserName userName;
    
    public Professor(Name name, Password password, UserName userName) {
        this.name = name;
        this.password = password;
        this.userName = userName;
    }

    public boolean searchByUserName(String termo){
        return userName.search(termo);
    }

}
