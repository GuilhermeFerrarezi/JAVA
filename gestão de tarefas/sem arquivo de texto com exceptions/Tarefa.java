package gestao_de_tarefas;

public class Tarefa {
	
	private String titulo;
	private String descricao;
	private boolean status;
	private Tarefa next;
	private Tarefa prev;
	
	Tarefa(String titulo, String descricao){
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = false;
		this.next = null;
		this.prev = null;
	}	
	
	void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	void setStatus(boolean status) {
		this.status = status;
	}
	
	void setNext(Tarefa next) {
		this.next = next;
	}
	
	void setPrev(Tarefa prev) {
		this.prev = prev;
	}
	
	String getTitulo() {
		return this.titulo;
	}
	
	String getDescricao() {
		return this.descricao;
	}
	
	boolean getStatus() {
		return this.status;
	}
	
	Tarefa getNext() {
		return this.next;
	}
	
	Tarefa getPrev() {
		return this.prev;
	}
}
