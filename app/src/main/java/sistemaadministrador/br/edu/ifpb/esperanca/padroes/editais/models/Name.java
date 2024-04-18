package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models;

public class Name {
    private String name;

    public Name(String name) {
        if(validateNullName(name)){
            throw new IllegalArgumentException("The name cannot be null");
        }
        this.name = name;
    }

    public void updateName(String name) throws IllegalArgumentException {
        if(validateEqualName(name) || validateNullName(name)){
            throw new IllegalArgumentException("The name cannot be null or equal to the one already existing.");
        }
        this.name = name;
    }

    public void validateName(String name) throws IllegalArgumentException {
        if(validateEqualName(name) || validateNullName(name)){
            throw new IllegalArgumentException("The name cannot be null or equal to the one already existing.");
        }
    }

    // public boolean validateExistenceName(String name){
    //     return name.toLowerCase().equals(this.name.toLowerCase());
    // }

    public boolean validateNullName(String name){
        return name == null;
    }

    public boolean validateEqualName(String name){
        return name.equals(name);
    }

    @Override
    public String toString() {
        return "Nome: " + name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true; // Verifica se o objeto atual é o mesmo que o objeto passado como parâmetro (mesma instãncia, mesmo lugar na memória)
        if(o == null || this.getClass() != o.getClass()) return false; 

        Name otherName = (Name)o;
        return name.equals(otherName.name); // Compara os campos 'name' dos dois objetos Name
    }
    
}
