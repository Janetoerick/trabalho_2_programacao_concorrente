package Users;

import java.util.Iterator;

import Lista.ListaEncadeadaC;
import Thread.ThreadB;
import Thread.ThreadI;
import Thread.ThreadR;

public class user1 {

	public static void main(String[] args) {
		ListaEncadeadaC list = new ListaEncadeadaC();
		
		for (int i = 0; i < 20; i++) {
			Thread threadI = new ThreadI(i, list);
			threadI.start();
			
		}
		
		for (int i = 0; i < 20; i++) {
			Thread threadB = new ThreadB(i, list);
			Thread threadR = new ThreadR(i, list);
			threadR.start();
			threadB.start();
			
//			try {
//				Thread.sleep(5);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list.listar();

	}

}
