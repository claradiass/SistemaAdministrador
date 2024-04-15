package app.src.main.java.sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.model;

public class UserName {
    private String userName;

    public UserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean search(String termo) {
        return userName.toLowerCase().contains(termo.toLowerCase());
    }


}
