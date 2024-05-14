package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.service;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Administrador;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Email;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.models.Password;

// public class AdministratorService implements FacadeAdministrator{

//     @Override
//     public boolean verifyAdmin(String writeEmail, String writePassword) {
//         Administrador newAdministrador = new Administrador();
//         Email email = new Email(writeEmail);
//         Password password = new Password(writePassword);

//         if(newAdministrador.validateEmail(email) && newAdministrador.validatePassword(password)){
//             return true;
//         }
        
//         return false;
        
//     }
    
// }

public class AdministratorService implements FacadeAdministrator {

    @Override
    public boolean verifyAdmin(String writeEmail, String writePassword) {
        Administrador newAdministrador = new Administrador();
        Email email = new Email(writeEmail);
        Password password = new Password(writePassword);

        if (newAdministrador.validateEmail(email) && password.equals(new Password("adm123.OI"))) {
            return true;
        }
        
        return false;
    }
}
