package gestao_de_tarefas;

public class FilaTarefa {
	
	private int size;
	private Tarefa head;
	private Tarefa tail;
	
	public FilaTarefa() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	public void enqueue(String titulo, String descricao) {
		Tarefa no_trab = new Tarefa(titulo, descricao);
		Tarefa no_valida = this.head;
		if(this.size == 0) {
			this.head = no_trab;
			this.tail = no_trab;
		}else {
			while(no_valida != null) {
				if(no_valida.getTitulo().equals(titulo)) {
					System.out.println("Já existe uma tarefa com esse nome");
					return;
				}
				no_valida = no_valida.getNext();
			}
			no_trab.setPrev(this.tail);
			this.tail.setNext(no_trab);
			this.tail = no_trab;
		}
		this.size++;
	}
	
	public int dequeue(String titulo) {
		Tarefa no_trab;
		Tarefa no_valida = this.head;
		if(this.size == 0) {
			return 2;
		}else if(this.size == 1) {
				if(this.head.getTitulo().equals(titulo)) {
				this.head = null;
				this.tail = null;
				this.size--;
				return 1;
			}else {
				return -1;
			}
		}else {
			while(no_valida != null) {
				if(no_valida.getTitulo().equals(titulo)) {
					no_trab = no_valida.getPrev();
					if(no_valida.getNext() != null) {
						no_valida.getNext().setPrev(no_trab);				
						no_valida = no_valida.getNext();
					}else {
						this.tail = no_trab;
					}
					if(no_trab != null) {
						no_trab.setNext(no_valida.getNext());						
					}else {
						this.head = no_valida;
					}
					this.size--;
					return 1;
				}
				no_valida = no_valida.getNext();
			}
			return -1;
		}
	}
	
	public void imprimeFila() {
		Tarefa no_trab = this.head;
		String status;
		if(this.size == 0) {
			System.out.println("Fila vazia");
		}else {
			while(no_trab != null) {
				if(no_trab.getStatus()) {
					status = "Concluído";
				}else {
					status = "Não concluído";
				}
				System.out.printf("Título: " + no_trab.getTitulo() + "\nDescrição: " + no_trab.getDescricao() + "\nStatus: " + status);
				System.out.println();
				System.out.println();
				no_trab = no_trab.getNext();
			}
		}
	}
	
	public int concluirTarefa(String titulo) {
		Tarefa no_trab = this.head;
		while(no_trab != null) {
			if(no_trab.getTitulo().equals(titulo)){
				no_trab.setStatus(true);
				return 1;
			}
			no_trab = no_trab.getNext();
		}
		return -1;
	}
	
	void setHead(Tarefa head) {
		this.head = head;
	}
	
	void setTail(Tarefa tail) {
		this.tail = tail;
	}
	
	int getSize() {
		return this.size;
	}
	
	Tarefa getHead() {
		return this.head;
	}
	
	Tarefa getTail(){
		return this.tail;
	}
}
