package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models;

public class UserName {
    private String userName;

    public UserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void updateUserName(String userName) {
        if(userName == null || userName == this.userName){
            System.out.println("Mudança inválida");
        }
        this.userName = userName;
    }

    public boolean search(String termo) {
        return userName.toLowerCase().contains(termo.toLowerCase()); // verifica se no username contém o termo apresentado
    }

    public boolean exitsUserName(String userName){
        return userName.toLowerCase().equals(this.userName.toLowerCase());
    }

    public boolean validateUserName(String username){
        return username != null;
    }

    @Override
    public String toString() {
        return "Usuário: " + userName;
    }


}
