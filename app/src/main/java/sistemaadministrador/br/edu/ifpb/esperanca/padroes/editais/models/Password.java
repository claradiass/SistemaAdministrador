package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models;

public class Password {
    private String password;

    public Password(String password) {
        validatePassword(password);
        this.password = password;
    }

    public void updatePassword(String password) throws IllegalArgumentException {
        if(validatePassword(password) || password == this.password){
            throw new IllegalArgumentException("The name cannot be null or equal to the one already existing.");
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

    public boolean validatePassword(String password)  throws IllegalArgumentException {
        if(password.length() < 8) {
            throw new IllegalArgumentException("The password must have 8 digits");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("The password must contain lowercase letters");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("The password must contain uppercase letters");
        }
        

        if(!password.matches(".*\\d.*")){
            throw new IllegalArgumentException("The password must contain number");
        }

        return true;
    }


}
