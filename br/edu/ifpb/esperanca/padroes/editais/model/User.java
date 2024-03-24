package br.edu.ifpb.esperanca.padroes.editais.model;

public class User {
    private Name name;
    private Password password;
    private UserName userName;
    
    public User(Name name, Password password, UserName userName) {
        this.name = name;
        this.password = password;
        this.userName = userName;
    }
}
