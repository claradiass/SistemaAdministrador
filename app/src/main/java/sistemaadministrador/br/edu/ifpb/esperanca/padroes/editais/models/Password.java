package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models;

public class Password {
    private String password;

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void updatePassword(String password) {
        if(password == null || password == this.password){
            System.out.println("Mudança inválida");
        }
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password otherPassword = (Password) o;
        return password.equals(otherPassword.password);
    }

    @Override
    public int hashCode() {
        return password.hashCode();
    }

    public boolean validatePassword(String password){
        return password != null;
    }



}
