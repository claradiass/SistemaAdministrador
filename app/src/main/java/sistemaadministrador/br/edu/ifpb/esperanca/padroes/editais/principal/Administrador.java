package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Email;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Password;

public class Administrador {
    private static final Email email = new Email("adm@gmail.com"); 
    private static final Password password = new Password("adm123");

    public boolean validateEmail(Email emailWrite){
        return email.equals(emailWrite);
    }

    public boolean validatePassword(Password passwordWrite){
        return password.equals(passwordWrite);
    }
}