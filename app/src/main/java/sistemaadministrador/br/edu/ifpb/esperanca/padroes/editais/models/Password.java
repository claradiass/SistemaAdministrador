package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models;

public class Password {
    private String password;

    public Password(String password) {
        validatePassword(password);
        this.password = password;
    }

    public void updatePassword(String password) throws IllegalArgumentException {
        if (!password.isEmpty()) {
            this.password = password;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password otherPassword = (Password) o;
        return password.equals(otherPassword.password);
    }

    public boolean validatePassword(String password)  throws IllegalArgumentException {

        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) { 
            throw new IllegalArgumentException("A password must have at least 8 characters, including at least one lowercase letter, one uppercase letter, and one number.");
        }
        // ^ inicio da string, 
        //(?=.*[a-z]) É um lookahead positivo que verifica se há pelo menos uma letra minúscula em qualquer lugar da string.
        //(?=.*[A-Z]): É um lookahead positivo que verifica se há pelo menos uma letra maiúscula em qualquer lugar da string.
        // (?=.*\\d): É um lookahead positivo que verifica se há pelo menos um dígito em qualquer lugar da string.
        // .{8,}: Corresponde a qualquer caractere (exceto nova linha) pelo menos 8 vezes.
        // $: Denota o final da string.

        return true;
    }


}
