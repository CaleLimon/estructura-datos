package parentesis;

import java.util.Scanner;
import java.util.Stack;

public class parentesis {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.println("Menu:");
			    System.out.println("1. Reconocer parentesis");
			    System.out.println("2. Salir");
			    System.out.print("Seleccione su opcion: ");
			    int option = scanner.nextInt();
			    scanner.nextLine(); // Consume el salto de línea
			    switch (option) {
			        case 1:
			            System.out.print("Ingrese una cadena con parentesis: ");
			            String input = scanner.nextLine();
			            recognizeParenthesis(input);
			            break;
			        case 2:
			            System.out.println("Hasta luego");
			            return;
			        default:
			            System.out.println("Opción invalida");
			    }
			}
		}
    }

    public static void recognizeParenthesis(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                System.out.println("Se abrio un parentesis");
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    System.out.println("Se cerro un parentesis");
                } else {
                    System.out.println("Error: Parentesis sin abrir");
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Error: Parentesis sin cerrar");
        } else {
            System.out.println("Ordenamiento correcto");
        }
    }
}