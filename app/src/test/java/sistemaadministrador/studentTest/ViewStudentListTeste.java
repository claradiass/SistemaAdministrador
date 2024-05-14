package sistemaadministrador.studentTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command.ViewStudentList;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.StudentRepository;
import sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.repository.FileService;


public class ViewStudentListTeste {
    @BeforeEach
    public void setUp() {
        TestSetup.setup();
    }

    @Test // indica que é métodoé um caso de teste Junit
    public void testViewS() {

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

        ViewStudentList command = new ViewStudentList(); // Criando uma instância 
        command.execute(); // executando o método 
        System.out.println(outContent);

        System.setOut(originalOut);
        //  Esta linha restaura a saída padrão do sistema para o valor original (normalmente o console).
        // Basicamente, restaurar a saída padrão do sistema após o teste é uma medida de precaução para garantir que seu ambiente de teste permaneça limpo e 
        // não afete o funcionamento de outros testes ou do próprio código em execução.

        assertTrue(outContent.toString().contains("teste"));
        // Aqui, você está verificando se a saída capturada pelo outContent contém a mensagem de sucesso esperada. Se a mensagem estiver presente na saída, 
        //o teste será considerado bem-sucedido; caso contrário, será considerado falha.
    }
}
