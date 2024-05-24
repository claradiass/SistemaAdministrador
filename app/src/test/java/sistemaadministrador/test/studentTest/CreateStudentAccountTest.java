package sistemaadministrador.test.studentTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.CreateStudentAccount;

public class CreateStudentAccountTest {

    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    @Test // indica que é métodoé um caso de teste Junit
    public void testCreateStudentAccount() {

        
        String input = "Ana Clara\nana\npassword.@222ANA\n"; // Simulando a entrada do usuário que seria nome, usuário e senha.
        // Quando você está trabalhando com entrada de dados em Java, como texto digitado pelo usuário, 
        // você geralmente interage com um objeto chamado InputStream. Este objeto representa uma sequência 
        // de dados que podem ser lidos, como caracteres de texto.
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        // input.getBytes(): A string input contém os dados que você deseja simular como entrada do usuário. 
        // Para transformá-la em algo que o Java possa entender melhor, você a converte em um array de bytes. 
        // Em Java, todas as strings são codificadas em Unicode, mas para processamento, muitas vezes você precisa convertê-las em bytes.

        // new ByteArrayInputStream(...): Aqui, você está criando um novo objeto ByteArrayInputStream. 
        // Este objeto é uma implementação específica de InputStream que lê os dados de um array de bytes.

        // InputStream inputStream = ...: Esta linha está atribuindo o objeto ByteArrayInputStream que você criou à variável inputStream. 
        // Agora, inputStream contém a sequência de bytes que representam os dados de entrada que você deseja simular.

        // Então, resumindo, o que essa linha faz é converter a string de entrada em bytes e, em seguida, criar um objeto InputStream que pode ser usado para ler esses bytes. 
        // Isso simula a entrada do usuário, que seu código pode então ler como se estivesse vindo de um teclado ou de outro dispositivo de entrada.

        System.setIn(inputStream);
        // System.setIn(inputStream);: Esta linha substitui a entrada padrão do sistema (normalmente o teclado) pelo inputStream que você acabou de criar. 
        // Isso faz com que o Scanner leia a entrada simulada em vez de esperar a entrada do usuário pelo teclado.

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        // ByteArrayOutputStream outContent = new ByteArrayOutputStream();: Aqui, você está criando um objeto ByteArrayOutputStream. 
        // Este objeto é usado para armazenar dados de saída em forma de bytes em memória. É como uma "memória temporária" onde você pode gravar informações.

        PrintStream originalOut = System.out;
        // Nesta linha, você está armazenando a saída padrão do sistema em uma variável chamada originalOut. Normalmente, a saída padrão é o console, ou seja, 
        // quando você imprime algo no console usando System.out.println(), isso é o que você está usando aqui. Armazenar a saída padrão é útil porque você pode 
        // querer restaurá-la mais tarde após o teste.

        System.setOut(new PrintStream(outContent));
        // Aqui, você está substituindo a saída padrão do sistema pelo outContent que você acabou de criar. Isso significa que qualquer coisa que seja impressa 
        // usando System.out.println() ou similar durante a execução do teste será capturada pelo outContent em vez de ser exibida no console. Isso é útil para 
        // testar a saída do seu código, porque você pode verificar se ele está produzindo a saída esperada sem realmente exibi-la no console durante o teste.

        // Resumindo, esse trecho de código cria um objeto que pode capturar a saída do sistema (nesse caso, substituindo a saída padrão pelo objeto criado), 
        // permitindo que você acesse e verifique essa saída durante a execução do teste sem realmente exibi-la no console. Isso é útil para testar a saída 
        // do seu código de forma automatizada.

        CreateStudentAccount command = new CreateStudentAccount(); // Criando uma instância 
        command.execute(); // executando o método 

        System.setOut(originalOut);
        //  Esta linha restaura a saída padrão do sistema para o valor original (normalmente o console).
        // Basicamente, restaurar a saída padrão do sistema após o teste é uma medida de precaução para garantir que seu ambiente de teste permaneça limpo e 
        // não afete o funcionamento de outros testes ou do próprio código em execução.

        assertTrue(outContent.toString().contains("Sua conta foi criada com sucesso!"));
        // Aqui, você está verificando se a saída capturada pelo outContent contém a mensagem de sucesso esperada. Se a mensagem estiver presente na saída, 
        //o teste será considerado bem-sucedido; caso contrário, será considerado falha.
           
    }

    @Test
    public void testCreateStudentAccountError() {
        String input = "John Doe\njohndoe\npassword.ANA\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CreateStudentAccount command = new CreateStudentAccount();
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute();
        });
        // IllegalArgumentException exception: Aqui estamos declarando uma variável chamada exception do tipo IllegalArgumentException. Esta variável será usada 
        // para armazenar qualquer exceção do tipo IllegalArgumentException que for lançada durante a execução do método execute().
        // assertThrows(IllegalArgumentException.class, () -> { command.execute(); }): Este é um método de assertiva que verifica se uma exceção é 
        // lançada durante a execução do código dentro da expressão lambda () -> { command.execute(); }.
        // IllegalArgumentException.class: Este é o tipo de exceção que estamos esperando que seja lançado durante a execução do código dentro da expressão lambda. 
        // Se uma exceção de outro tipo for lançada, o teste falhará.
        // () -> { command.execute(); }: Esta é uma expressão lambda que encapsula o código que queremos testar. No caso, estamos chamando o método execute() do 
        // objeto command. Se este método lançar uma exceção do tipo IllegalArgumentException, a assertiva será bem-sucedida, caso contrário, o teste falhará.
        // exception: Após a execução do código dentro da expressão lambda, se uma exceção do tipo IllegalArgumentException for lançada, ela será capturada 
        // nesta variável exception. Isso nos permite acessar e examinar a exceção para realizar as verificações necessárias no teste.

        System.setOut(originalOut);

        assertFalse(outContent.toString().contains("Sua conta foi criada com sucesso!"));
        assertEquals("A password must have at least 8 characters, including at least one lowercase letter, one uppercase letter, and one number.", exception.getMessage());
    }

    @Test
    public void testCreateStudentAccountNull() {
        
        String input = "John Doe\n\npassword.ANA22\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        
        CreateStudentAccount command = new CreateStudentAccount();
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute();
        });

        System.setOut(originalOut);

        assertFalse(outContent.toString().contains("Sua conta foi criada com sucesso!"));
        assertEquals("The username cannot be null or existing", exception.getMessage());
    }

    @Test
    public void testCreateStudentAccountNull2() {
        
        String input = "\n\nJohn Doe\npassword.ANA22\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CreateStudentAccount command = new CreateStudentAccount();
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            command.execute();
        });

        System.setOut(originalOut);

        assertFalse(outContent.toString().contains("Sua conta foi criada com sucesso!"));
        assertEquals("The name cannot be null", exception.getMessage());
    }
}
