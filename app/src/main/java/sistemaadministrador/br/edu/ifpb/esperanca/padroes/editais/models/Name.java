package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.models;

public class Name {
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void updateName(String name) {
        if(name == null || name.equals(name)){
            System.out.println("Mudança inválida");
            return;
        }
        this.name = name;
    }

    public boolean validateName(String name){
        return name != null;
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
