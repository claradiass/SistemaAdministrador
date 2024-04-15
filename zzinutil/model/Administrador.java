package zzinutil.model;

public class Administrador {
    private Name name;
    private Password password;
    private UserName userName;
    
    public Administrador(Name name, Password password, UserName userName) {
        this.name = name;
        this.password = password;
        this.userName = userName;
    }
}
