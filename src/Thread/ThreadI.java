package Thread;

import Lista.ListaEncadeadaC;

public class ThreadI extends Thread {

	// valor a ser adicionado na lista
	private int value;

	// referencia para lista (garantindo que mude a lista a partir da thread)
	private ListaEncadeadaC list;
	
	public ThreadI(int value, ListaEncadeadaC list) {
		this.value = value;
		this.list = list;
	}
	
	@Override
	public void run() {
		/*
		 * Verifica se existe uma threadR executando
		 * */
		while(list.avaliablePermits() == 0) { 
			try {
				if(getPriority() < 10) { 			// aumenta o valor da prioridade
					setPriority(getPriority()+1);  	// quanto mais a thread espera
													// 
				}
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.add(value); // adiciona o valor na lista
		System.out.println("I" + getId() + ": Adicionando " + value);
	}

}
