package Thread;

import Lista.ListaEncadeadaC;

public class ThreadB extends Thread {

	private int position;
	private int value;
	private ListaEncadeadaC list;
	
	public ThreadB(int position, ListaEncadeadaC list) {
		this.position = position;
		this.list = list;
	}
	
	@Override
	public void run() {
		if(position < list.size()) {
			value = list.get(position);
			System.out.println("B"+ position +": Buscando... | Achou valor "
								+ value + " na posicao " + position);
		}
		
	}

	public int getValue() {
        return value;
    }
}