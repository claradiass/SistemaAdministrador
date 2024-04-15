package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.principal;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Name;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.Password;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models.UserName;

public class Professor extends User{

    public Professor(Name name, Password password, UserName userName) {
        super(name, password, userName);
    }

}
