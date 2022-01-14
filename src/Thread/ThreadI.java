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
		int count = 0; // variavel auxiliar que garante que nao ocorra deadlock
		
		/*
		 * Verifica se existe uma threadR executando
		 * */
		while(list.avaliablePermits() == 0) { 
			try {
				if(getPriority() < 10) { 			// aumenta o valor da prioridade
					setPriority(getPriority()+1);  	// quanto mais a thread espera
													// garantindo que nao ocorra starvation
				} else {
					count++; // aumenta o valor, caso esteja demorando demais, tendo um alto risco
							 // de estar entrando em deadlock
				}
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(count == 3) // quebra o while, garantindo a parada do estado de deadlock
				break;
		}
		list.add(value);
		System.out.println("I" + getId() + ": Adicionando " + value);
	}

}
