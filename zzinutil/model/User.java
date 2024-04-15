package zzinutil.model;

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

    public boolean verifyStatus(UserName userName){
        return status;
    }

    // public modifyStatusTo(UserName userName){

    // }
}
