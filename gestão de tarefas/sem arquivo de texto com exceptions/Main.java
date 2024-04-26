package gestao_de_tarefas;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		FilaTarefa tarefas = new FilaTarefa();
		Scanner entrada = new Scanner(System.in);
		inicio(entrada, tarefas);
		entrada.close();
	}
	
	// @SuppressWarnings("unused")
	static void inicio(Scanner entrada, FilaTarefa tarefas) {
		System.out.println("Selecione o que deseja fazer:");
		System.out.println("1: Adicionar tarefa");
		System.out.println("2: Mostrar todas as tarefas");
		System.out.println("3: Retirar uma tarefa");
		System.out.println("4: Concluir uma tarefa");
		System.out.println("5: Sair");
		int escolha  = entrada.nextInt();
		while(escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4 && escolha != 5) {
			System.out.println("Por favor, selecione um dos valores válidos");
			escolha = entrada.nextInt();
		}
		switch(escolha) {
		case 1:
			adicionaTarefa(entrada, tarefas);
			break;
		case 2:
			mostrarTarefa(entrada, tarefas);
			break;
		case 3:
			try {
			retirarTarefa(entrada, tarefas);
			} catch(Exception ExecaoTarefa) {
				System.out.println("A tarefa não existe");
			}
			break;
		case 4:
			try {
				concluirTarefa(entrada, tarefas);
			}catch(Exception ExcecaoTarefa) {
				System.out.println("A tarefa não existe");
			}
			break;
		default:
			return;
		}
	}
	
	static void adicionaTarefa(Scanner entrada, FilaTarefa tarefas) {
		String resposta = "sim";
		while(resposta.equals("sim") || resposta.equals("Sim") || resposta.equals("SIM")) {
			System.out.println("Por favor, digite o título da tarefa");
			String titulo = entrada.next();
			System.out.println("Agora digite a descrição");
			String descricao = entrada.next();
			tarefas.enqueue(titulo, descricao);
			System.out.println("Deseja adicionar mais uma tarefa?(Sim ou Não)");
			resposta = entrada.next();
			while(!resposta.equals("sim") && !resposta.equals("Sim") && !resposta.equals("SIM") 
			      && !resposta.equals("não") && !resposta.equals("Não") && !resposta.equals("NÃO")
			      && !resposta.equals("nao") && !resposta.equals("Nao") && !resposta.equals("NAO")) {
				System.out.println("Por favor, de uma resposta válida");
				resposta = entrada.next();
			}
		}
		inicio(entrada, tarefas);
	}
	
	static void mostrarTarefa(Scanner entrada, FilaTarefa tarefas) {
		tarefas.imprimeFila();
		inicio(entrada, tarefas);
	}
	
	static void retirarTarefa(Scanner entrada, FilaTarefa tarefas) throws ExcecaoTarefa {
		System.out.println("Por favor, digite o título da tarefa que deverá ser removida");
		String titulo = entrada.next();
		int resultado = tarefas.dequeue(titulo);
		if(resultado == -1){
			throw new ExcecaoTarefa();
		}else if(resultado == 2) {
			System.out.println("Ainda não existem tarefas");
		}
		inicio(entrada, tarefas);
	}
	
	static void concluirTarefa(Scanner entrada, FilaTarefa tarefas) throws ExcecaoTarefa{
		System.out.println("Por favor, digite o título da tarefa que deverá ser concluída");
		String titulo = entrada.next();
		if(tarefas.concluirTarefa(titulo) == -1){
			throw new ExcecaoTarefa();
		}
		inicio(entrada, tarefas);
	}
}
