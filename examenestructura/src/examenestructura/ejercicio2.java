package examenestructura;

//2
import java.util.Stack;
import java.util.Random;
		
public class ejercicio2{
	public static void main(String[] args) {
		Stack<Integer> pila= new Stack<>();
		Random random = new Random();
		int sum = 0;
		boolean encontrado50 = false;
		
		while (!encontrado50) {
			int numAlt = random.nextInt(100)+1;
			pila.push(numAlt);
			System.out.println("Num: " + numAlt + " a la pila");
			
			if (numAlt == 50) {
				encontrado50 = true;
				System.out.println(".50. reinicio suma");
				
				while (!pila.isEmpty()) {
					sum += pila.pop();
					System.out.println("numero fuera de la pila");
				}
			}
		}	
	}
}
