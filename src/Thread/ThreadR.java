package Thread;

import Lista.ListaEncadeadaC;

public class ThreadR extends Thread {

	private int position;
	private ListaEncadeadaC list;
	
	public ThreadR(int position, ListaEncadeadaC list) {
		this.position = position;
		this.list = list;
	}
	
	@Override
	public void run() {
		if(position < list.size()) {
			list.remove(position);
			System.out.println("R" + position + ": Removeu valor da posicao " + position);
		}
	}

}