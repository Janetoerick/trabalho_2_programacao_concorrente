package Lista;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class ListaEncadeadaC {
	
	private volatile LinkedList<Integer> list;
	private volatile Semaphore s; 

	public ListaEncadeadaC() {
		list = new LinkedList<Integer>();
		s = new Semaphore(1);
	}
	
	public int get(int position) {
		return list.get(position);
	}
	
	public void add(int value) {
		synchronized(list) {
			try {
				list.add(value);
			} catch(Exception e) {
				System.out.println("aqui entrou bixo");
			}
		}
	}
	
	public synchronized void remove(int position) {
		list.remove(position);
	}	
	
	public void listar() {
		for (int i = 0; i < list.size(); i++) {
			System.out.print("| " + list.get(i));
		}
	}
	
	public int size() {
		return list.size();
	}
	
}
