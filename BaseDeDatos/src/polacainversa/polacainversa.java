package polacainversa;

import java.util.Stack;
import java.util.Scanner;

public class polacainversa {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] historial = new String[10];
    private static int indiceHistorial = 0;

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    convertirANotacionPolacaInversa();
                    break;
                case 2:
                    mostrarHistorial();
                    break;
                case 3:
                    System.out.println("Hastaluego");
                    return;
                default:
                    System.out.println("Opcion inválida, intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú de Conversor a Notación Polaca Inversa");
        System.out.println("1. Ingresar ecuacion");
        System.out.println("2. Historial");
        System.out.println("3. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private static void convertirANotacionPolacaInversa() {
        System.out.println("Ingrese su ecuacion:");
        String ecuacion = scanner.nextLine();
        String rpn = convertir(ecuacion);
        System.out.println("Notacion polaca inversa: " + rpn);

        if (indiceHistorial < historial.length) {
            historial[indiceHistorial++] = ecuacion;
        }
    }													//preguntar al profe como arreglar las pilas

    private static String convertir(String ecuacion) {
        Stack<Character> pila = new Stack<>();
        StringBuilder rpn = new StringBuilder();

        for (char c : ecuacion.toCharArray()) {
            if (Character.isDigit(c)) {
                rpn.append(c).append(" ");
            } else if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                while (pila.peek() != '(') {
                    rpn.append(pila.pop()).append(" ");
                }
                pila.pop();
            } else if (c == '+' || c == '-') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    rpn.append(pila.pop()).append(" ");
                }
                pila.push(c);
            } else if (c == '*' || c == '/') {
                while (!pila.isEmpty() && (pila.peek() == '*' || pila.peek() == '/')) {
                    rpn.append(pila.pop()).append(" ");
                }
                pila.push(c);
            }
        }

        while (!pila.isEmpty()) {
            rpn.append(pila.pop()).append(" ");
        }

        return rpn.toString().trim();
    }

    private static void mostrarHistorial() {
        System.out.println("\nHistorial:");
        for (int i = 0; i < indiceHistorial; i++) {
            System.out.println((i + 1) + ". " + historial[i]);
        }
    }
}