package Lista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ListaEncadeadaC {

	// lista para ser usada pelas threads
	private volatile LinkedList<Integer> list;

	 // semaforo ligado a "threadR", no qual garante que todas as threads
	 // de outros tipos parem para uma threadR executar
	private volatile Semaphore semaphore;
	
	private volatile Queue<Long> threadsR;
	

	public ListaEncadeadaC() {
		list = new LinkedList<Integer>();
		semaphore = new Semaphore(1);
		threadsR = new LinkedList<>();
	}
	
	/*
	 * metodo para retornar o valor especifico de uma posição na lista "list"
	 * */
	public int get(int position) {
		if(position < list.size())
			return list.get(position);
		else
			return -1;
	}

	/*
	 * metodo para adicionar um novo valor no final da lista "list"
	 * 		- O metodo eh synchronized, garantindo que apenas uma "threadI" sera executada
	 * 		por vez
	 * */
	public synchronized void add(int value) {
		try {
			list.add(value);
		} catch (Exception e) {
			System.out.println("aqui entrou bixo");
		}
	}

	/*
	 * Metodo que remove um valor de uma posicao desejada da lista "list"
	 * */
	public synchronized void remove(int position) {
		try {
			list.remove(position);
		}catch(IndexOutOfBoundsException e) {
			System.out.println("entrou aqui filhao ------------------------------------------------------------");
		}
	}

	/*
	 * Metodo para escrever a lista "list" inteira
	 * */
	public void listar() {
		for (int i = 0; i < list.size(); i++) {
			System.out.print("| " + list.get(i));
		}
	}

	/*
	 * Metodo para retornar o tamanho atual da lista "list"
	 * */
	public int size() {
		return list.size();
	}

	/*
	 * Metodo para preencher o semaphore
	 * 		\ utilizado apenas pela "threadR"
	 * */
	public void acquireSemaphore() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Metodo para liberar o semaphore
	 * 		\ utilizado apenas pela "threadR"
	 * */
	public void releaseSemaphore() {
		semaphore.release();
	}

	/*
	 * Metodo para preencher o semaphore
	 * 		\ utilizado pelas threads "threadB" e "threadI"
	 * */
	public int avaliablePermits() {
		return semaphore.availablePermits();
	}
	
	public void addThreadR(Long getId) {
		threadsR.add(getId);
	}
	
	public Long firstThreadR() {
		if(threadsR.peek() != null)
			return threadsR.peek();
		else
			return (long) -1;
		
	}
	
	public void removeThreadR() {
		threadsR.remove();
	}
	
	public Boolean ContainsThreadR(Long id) {
		return threadsR.contains(id);
	}
}
