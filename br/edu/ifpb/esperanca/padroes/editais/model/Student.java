package br.edu.ifpb.esperanca.padroes.editais.model;

public class Student{
    private Name name;
    private Password password;
    private UserName userName;
    
    public Student(Name name, Password password, UserName userName) {
        this.name = name;
        this.password = password;
        this.userName = userName;
    }

    public boolean searchByUserName(String termo){
        return userName.search(termo);
    }

}
