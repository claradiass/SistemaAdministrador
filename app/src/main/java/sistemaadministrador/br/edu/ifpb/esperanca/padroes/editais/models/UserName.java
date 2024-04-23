package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models;

public class UserName {
    private String userName;

    public UserName(String userName) {
        validateUserName(userName);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void updateUserName(String userName) {
        if (!userName.isEmpty()) {
            this.userName = userName;
        }
    }

    public boolean search(String termo) {
        return userName.toLowerCase().contains(termo.toLowerCase()); // verifica se no username contém o termo apresentado
    }

    public boolean exitsUserName(String userNameToCheck){
        return userName.equalsIgnoreCase(userNameToCheck);
    }

    public void validateUserName(String username) throws IllegalArgumentException {
        if(username.isEmpty()){
            throw new IllegalArgumentException("The username cannot be null or existing");
        }
    }

    @Override
    public String toString() {
        return "Usuário: " + userName;
    }


}
