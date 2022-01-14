package Thread;

import Lista.ListaEncadeadaC;

public class ThreadB extends Thread {

	private int position;
	private ListaEncadeadaC list;
	
	public ThreadB(int position, ListaEncadeadaC list) {
		this.position = position;
		this.list = list;
	}
	
	@Override
	public void run() {
		
		int count = 0; // variavel auxiliar que garante que nao ocorra deadlock
		
		/*
		 * Verifica se existe uma threadR executando
		 * */
		if(position < list.size()) { // caso exista a posicao na lista
			
			/*
			 * Verifica se existe uma threadR executando
			 * */
			while(list.avaliablePermits() == 0) {
				try {
					if(getPriority() < 10) { 			// aumenta o valor da prioridade
						setPriority(getPriority()+1);  	// quanto mais a thread espera
						Thread.sleep(5);				// garantindo que nao ocorra starvation
					} else {
						count++; // aumenta o valor, caso esteja demorando demais, tendo um alto risco
						 		 // de estar entrando em deadlock
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(count == 3) // quebra o while, garantindo a parada do estado de deadlock
					break;
			}
			int value = list.get(position);
			if(value != -1)
				System.out.println("B"+ getId() +": Buscando... | Achou valor "
								+ value + " na posicao " + position);
		}
		
	}
}