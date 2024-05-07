package sistemaadministrador.br.edu.ifpb.esperanca.padroes.editais.command;

public class CommandExecute {
    public void execute(Command c){
        c.execute(); // Invoker (Invocador):
        //Responsável por solicitar que os comandos sejam executados.
        //Não precisa saber como o comando é executado ou quem o executa, apenas envia a solicitação para um objeto Command.
    }
}
