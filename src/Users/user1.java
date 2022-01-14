package Users;

import java.util.Iterator;

import Lista.ListaEncadeadaC;
import Thread.ThreadB;
import Thread.ThreadI;
import Thread.ThreadR;

public class user1 {

	public static void main(String[] args) {
		ListaEncadeadaC list = new ListaEncadeadaC();
		
		for (int i = 0; i < 100; i++) {
			Thread threadI = new ThreadI(i, list);
			threadI.start();
			
		}
		
		for (int i = 0; i < 100; i++) {
			Thread threadB = new ThreadB(i, list);
			Thread threadR = new ThreadR(i, list);
			threadR.start();
			threadB.start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list.listar();

	}

}
