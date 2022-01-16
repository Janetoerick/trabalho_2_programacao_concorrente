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
		
		if(position < list.size()) { // caso exista a posicao na lista
			
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
			int value = list.get(position); // pega o valor da lista
			if(value != -1)
				System.out.println("B"+ getId() +": Buscando... | Achou valor "
								+ value + " na posicao " + position);
		}
		
	}
}