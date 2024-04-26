package gestao_de_tarefas;

public class ExcecaoTarefa extends Exception {
	
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "A tarefa não existe";
	}
}
