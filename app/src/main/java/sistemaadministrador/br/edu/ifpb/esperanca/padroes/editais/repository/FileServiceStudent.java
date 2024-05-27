package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository;

import java.io.*;
import java.util.List;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.list.StudentsList;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.domain.Student;

public class FileServiceStudent extends InMemoryStudent{
    private StudentsList studentsList;

    public FileServiceStudent() {
        studentsList = new StudentsList();
        loadDataFromFile();
    }

    private void loadDataFromFile() {
        File data = new File("data.bin"); // cria um novo documento com o método File e com o nome data.bin
        if (data.exists()) { // verifica se o arquivo já existe
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
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

                studentsList = (StudentsList) ois.readObject();

                //ois.readObject(): Esta parte do código está lendo um objeto serializado do arquivo usando o ObjectInputStream que foi criado anteriormente. 
                // O método readObject() do ObjectInputStream lê o próximo objeto serializado disponível a partir do fluxo de entrada e o retorna como um objeto 
                // do tipo Object.

                //(StudentsList): Aqui, estamos fazendo um casting (conversão de tipo) do objeto retornado por ois.readObject() para o tipo StudentsList. 
                // O casting é necessário porque readObject() retorna um objeto do tipo Object, e nós sabemos que o objeto serializado no arquivo é do tipo 
                // StudentsList. Portanto, estamos basicamente dizendo ao compilador que confiamos que o objeto retornado é uma instância de StudentsList.

                // Resumindo, esta linha de código está lendo um objeto serializado do arquivo usando ObjectInputStream, convertendo-o para o tipo StudentsList e 
                // atribuindo-o à variável studentsList, que agora contém os dados lidos do arquivo. Isso é crucial para carregar os dados 
                // salvos anteriormente no arquivo de volta para a lista studentsList.

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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            // new FileOutputStream("data.bin"): Aqui estamos criando um novo objeto FileOutputStream. Esta classe em Java é usada para gravar bytes em um arquivo. 
            // O parâmetro "data.bin" especifica o nome do arquivo onde queremos escrever os dados.

            // new ObjectOutputStream(...): Este é um construtor que cria um novo objeto ObjectOutputStream. Ele é usado para escrever objetos Java em um fluxo de 
            // saída, como um arquivo. O construtor requer um objeto OutputStream como parâmetro, e é por isso que estamos passando o FileOutputStream que acabamos 
            // de criar. Isso significa que estamos criando um fluxo de saída de objetos que escreverá dados serializados em nosso arquivo "data.bin".

            // ObjectOutputStream oos = ...: Aqui, estamos atribuindo o objeto ObjectOutputStream recém-criado a uma variável chamada oos. Essa variável oos será 
            // usada para interagir com o fluxo de saída e escrever objetos no arquivo "data.bin".

            // Resumindo, essa linha de código está criando um fluxo de saída de objetos (ObjectOutputStream) associado a um arquivo chamado "data.bin". 
            // Esse fluxo de saída será usado para escrever objetos serializados no arquivo.

            oos.writeObject(studentsList);
            // studentsList é o objeto que queremos escrever no arquivo. Presumivelmente, é uma instância da classe StudentsList, que contém uma lista de estudantes 
            // (ou alguma outra estrutura de dados relacionada).

            // O método writeObject() serializa o objeto studentsList e escreve os bytes resultantes no arquivo associado ao ObjectOutputStream. Isso significa que 
            // o Java converte o objeto studentsList em uma sequência de bytes que representam o estado do objeto, tornando-o adequado para armazenamento ou transmissão. 
            // Esses bytes são então escritos no arquivo, permitindo que o objeto seja recuperado posteriormente por meio de desserialização.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createAccount(Student student) {
        studentsList.addStudent(student);
        saveDataToFile(); // chama o método saveDataToFile() para salvar a lista atualizada no arquivo.
    }

    public void disableAccount(int id) {
        studentsList.disableAccount(id);
        saveDataToFile();
    }

    public void activeAccount(int id) {
        studentsList.activeAccount(id);
        saveDataToFile();
    }

    public void updateUser(int idStudent, Student student) {
        studentsList.updateStudentAccount(idStudent, student);
        saveDataToFile();
    }

    public Student findById(int id) {
        return studentsList.viewStudent(id);
    }

    public List<Student> findAll() {
        return studentsList.viewStudentsList();
    }

    public List<Student> searchAccount(String termo) {
        return studentsList.searchStudentByUserName(termo);
    }

    public int getUserIdByUsername(String userName){
        return studentsList.getUserIdByUsername(userName);
    }

    public void validateUserName(String userName){
        studentsList.validateUserName(userName);
    }
}
