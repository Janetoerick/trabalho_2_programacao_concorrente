package Thread;

import Lista.ListaEncadeadaC;

public class ThreadI extends Thread {

	private int value;
	private ListaEncadeadaC list;
	
	public ThreadI(int value, ListaEncadeadaC list) {
		this.value = value;
		this.list = list;
	}
	
	@Override
	public void run() {
		list.add(value);
		System.out.println("I" + value + ": Adicionando " + value);
	}

}
