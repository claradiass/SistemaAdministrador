package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Professor;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list.ProfessorsList;

public class FileServiceProfessor extends InMemoryProfessor{
    private ProfessorsList professorsList;

    public FileServiceProfessor() {
        professorsList = new ProfessorsList();
        loadDataFromFile();
    }

    private void loadDataFromFile() {
        File data = new File("dataProfessor.bin"); // cria um novo documento com o método File e com o nome data.bin
        if (data.exists()) { // verifica se o arquivo já existe
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dataProfessor.bin"))) {
                // new FileInputStream("data.bin"): Aqui, estamos criando um novo objeto FileInputStream. 
                // O FileInputStream é uma classe em Java que permite a leitura de dados de um arquivo no disco. 
                // O parâmetro "data.bin" especifica o nome do arquivo a partir do qual queremos ler os dados.

                //new ObjectInputStream(...): Em seguida, estamos criando um novo objeto ObjectInputStream. 
                // O ObjectInputStream é uma classe em Java que permite a leitura de objetos serializados a partir de uma fonte de entrada, neste caso, um arquivo.

                // ois = ...: Estamos atribuindo o objeto ObjectInputStream recém-criado a uma variável chamada ois. Este é o objeto que usaremos para 
                // ler os objetos serializados do arquivo.

                //Então, resumindo, esta linha de código está criando um fluxo de entrada de arquivo para ler objetos serializados do arquivo "data.bin". 
                // Esses objetos provavelmente foram gravados anteriormente em um arquivo usando um ObjectOutputStream. Este processo é conhecido como 
                // desserialização, onde os dados serializados são convertidos de volta em objetos Java.

                professorsList = (ProfessorsList) ois.readObject();

                //ois.readObject(): Esta parte do código está lendo um objeto serializado do arquivo usando o ObjectInputStream que foi criado anteriormente. 
                // O método readObject() do ObjectInputStream lê o próximo objeto serializado disponível a partir do fluxo de entrada e o retorna como um objeto 
                // do tipo Object.

                //(ProfessorsList): Aqui, estamos fazendo um casting (conversão de tipo) do objeto retornado por ois.readObject() para o tipo ProfessorsList. 
                // O casting é necessário porque readObject() retorna um objeto do tipo Object, e nós sabemos que o objeto serializado no arquivo é do tipo 
                // ProfessorsList. Portanto, estamos basicamente dizendo ao compilador que confiamos que o objeto retornado é uma instância de ProfessorsList.

                // Resumindo, esta linha de código está lendo um objeto serializado do arquivo usando ObjectInputStream, convertendo-o para o tipo ProfessorsList e 
                // atribuindo-o à variável ProfessorsList, que agora contém os dados lidos do arquivo. Isso é crucial para carregar os dados 
                // salvos anteriormente no arquivo de volta para a lista ProfessorsList.

            } catch (IOException | ClassNotFoundException e) {
                //IOException: Esta é uma exceção de E/S (entrada e saída), que ocorre quando ocorre algum problema durante a leitura ou escrita de dados 
                // a partir de uma fonte externa, como um arquivo, rede, ou dispositivo de entrada/saída. Por exemplo, se o arquivo que estamos tentando 
                // ler não existe, ou não temos permissão para acessá-lo, uma IOException pode ser lançada.

                // ClassNotFoundException: Esta exceção ocorre quando uma aplicação tenta carregar uma classe em tempo de execução usando o método Class.forName(), 
                // mas a classe especificada não é encontrada no classpath. Em contextos de leitura de objetos serializados, como neste caso, 
                // esta exceção é lançada se a classe associada ao objeto serializado lido não puder ser encontrada no classpath do programa.

                e.printStackTrace();

                // Dentro do bloco catch, o método printStackTrace() é chamado no objeto de exceção (e). Isso imprime a pilha de chamadas de métodos que 
                // levaram à exceção. Isso é útil para depuração, pois fornece informações sobre onde e como a exceção ocorreu, 
                // ajudando os desenvolvedores a identificar e corrigir problemas em seus programas.
            }
        }
    }

    public void saveDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dataProfessor.bin"))) {
            // new FileOutputStream("data.bin"): Aqui estamos criando um novo objeto FileOutputStream. Esta classe em Java é usada para gravar bytes em um arquivo. 
            // O parâmetro "data.bin" especifica o nome do arquivo onde queremos escrever os dados.

            // new ObjectOutputStream(...): Este é um construtor que cria um novo objeto ObjectOutputStream. Ele é usado para escrever objetos Java em um fluxo de 
            // saída, como um arquivo. O construtor requer um objeto OutputStream como parâmetro, e é por isso que estamos passando o FileOutputStream que acabamos 
            // de criar. Isso significa que estamos criando um fluxo de saída de objetos que escreverá dados serializados em nosso arquivo "data.bin".

            // ObjectOutputStream oos = ...: Aqui, estamos atribuindo o objeto ObjectOutputStream recém-criado a uma variável chamada oos. Essa variável oos será 
            // usada para interagir com o fluxo de saída e escrever objetos no arquivo "data.bin".

            // Resumindo, essa linha de código está criando um fluxo de saída de objetos (ObjectOutputStream) associado a um arquivo chamado "data.bin". 
            // Esse fluxo de saída será usado para escrever objetos serializados no arquivo.

            oos.writeObject(professorsList);
            // ProfessorsList é o objeto que queremos escrever no arquivo. Presumivelmente, é uma instância da classe ProfessorsList, que contém uma lista de estudantes 
            // (ou alguma outra estrutura de dados relacionada).

            // O método writeObject() serializa o objeto ProfessorsList e escreve os bytes resultantes no arquivo associado ao ObjectOutputStream. Isso significa que 
            // o Java converte o objeto ProfessorsList em uma sequência de bytes que representam o estado do objeto, tornando-o adequado para armazenamento ou transmissão. 
            // Esses bytes são então escritos no arquivo, permitindo que o objeto seja recuperado posteriormente por meio de desserialização.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createAccount(Professor professor) {
        professorsList.addProfessor(professor);
        saveDataToFile(); // chama o método saveDataToFile() para salvar a lista atualizada no arquivo.
    }

    public void disableAccount(int id) {
        professorsList.disableAccount(id);
        saveDataToFile();
    }

    public void activeAccount(int id) {
        professorsList.activeAccount(id);
        saveDataToFile();
    }

    public void updateUser(int idProfessor, Professor professor) {
        professorsList.updateProfessorAccount(idProfessor, professor);
        saveDataToFile();
    }

    public Professor findById(int id) {
        return professorsList.viewProfessor(id);
    }

    public List<Professor> findAll() {
        return professorsList.viewProfessorsList();
    }

    public List<Professor> searchAccount(String termo) {
        return professorsList.searchProfessorByUserName(termo);
    }

    public int getStudentIdByUsername(String userName) {
        return professorsList.getProfessorIdByUsername(userName);
    }

    public int size(String userName) {
        return professorsList.size(userName);
    }

    public void validateUserName(String userName) {
        professorsList.validateUserName(userName);
    }
}
