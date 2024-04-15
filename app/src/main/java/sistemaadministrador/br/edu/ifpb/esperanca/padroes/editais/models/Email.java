package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models;

public class Email {
    private String email;

    public Email(String email) {
        this.email = email;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email otherEmail = (Email) o;
        return email.equals(otherEmail.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
