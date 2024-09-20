package examenestructura;

//3
import java.util.Stack;
//import java.util.Random;

public class ejercicio3 {
    public static void main(String[] args) {
    	//Stack<Integer> pila=new Stack<>();
        int[] num = new int[10];
        for (int n = 0; n < 10; n++) {
            num[n] = (int) (Math.random() * 100) + 1;
        }

        System.out.println("num:");
        for (int n = 0; n < 10; n++) {
            System.out.println(num[n] + " ");
        }
        System.out.println();

        Stack<Integer> pila = new Stack<>();
        for (int n = 0; n < 10; n += 2) {
            int suma = num[n] + num[n + 1];
            pila.push(suma);
            System.out.println(num[n] + " + " + num[n + 1] + " = " + suma);
        }

        System.out.println("\nPila después de sumar en parejas:");
        for (int i = 0; i < pila.size(); i++) {
            System.out.print(pila.get(i) + " ");
        }

        System.out.println();
        
		//int ult = pila.pop();
        //int penul = pila.pop();
        //int res = ult - penul;
        //System.out.println(ult + " - " + penul + " = " + res);
        //int mult = res * pila.peek();
		//System.out.println(res + " * " + pila.peek() + " = " + mult);
        //int suma2 = mult + pila.pop();
        //System.out.println(mult + " + " + pila.peek() + " = " + suma2);
        //int res2 = suma2 - pila.pop();
        //System.out.println(suma2 + " - " + pila.peek() + " = " + res2);
        //System.out.println("\nResultado final: " + res2);

        if (pila.size() >= 2) {
            int ult = pila.pop();
            int penul = pila.pop();
            int res = ult - penul;
            System.out.println(ult + " - " + penul + " = " + res);

            if (!pila.isEmpty()) {
                int mult = res * pila.peek();
                System.out.println(res + " * " + pila.peek() + " = " + mult);
                int suma2 = mult + pila.pop();

                if (!pila.isEmpty()) {
                    int res2 = suma2 - pila.pop();
                    System.out.println(suma2 + " - " + pila.peek() + " = " + res2);
                    System.out.println("\nResultado final: " + res2);
                } 
                
                else
                {
                   
                	System.out.println("No hay suficientes elementos en la pila");
                }
            } 
            
            else
            {
                
            	System.out.println("No hay suficientes elementos en la pila");
            }
        } 
        
        else
        {
            
        	System.out.println("No hay suficientes elementos en la pila");
            
        }
    }
}	


