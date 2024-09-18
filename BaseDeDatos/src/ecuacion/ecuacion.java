package ecuacion;

import java.util.Scanner;
import java.util.Stack;

public class ecuacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Resolver ecuacion");
            System.out.println("2. Salir");

            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la ecuación: ");
                    String ecuacion = scanner.next();
                    double resultado = resolverEcuacion(ecuacion);
                    System.out.println("Resultado: " + resultado);
                    break;
                case 2:
                    System.out.println("Adiós!");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    public static double resolverEcuacion(String ecuacion) {
        Stack<Double> pilaNumeros = new Stack<>();
        Stack<Character> pilaOperadores = new Stack<>();

        for (int i = 0; i < ecuacion.length(); i++) {
            char caracter = ecuacion.charAt(i);

            if (Character.isDigit(caracter)) {
                double numero = caracter - '0';
                pilaNumeros.push(numero);
            } else if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/') {
                while (!pilaOperadores.isEmpty() && getPrecedencia(caracter) <= getPrecedencia(pilaOperadores.peek())) {
                    procesarOperador(pilaNumeros, pilaOperadores);
                }
                pilaOperadores.push(caracter);
            }
        }

        while (!pilaOperadores.isEmpty()) {
            procesarOperador(pilaNumeros, pilaOperadores);
        }

        return pilaNumeros.pop();
    }

    private static void procesarOperador(Stack<Double> pilaNumeros, Stack<Character> pilaOperadores) {
        double numero2 = pilaNumeros.pop();
        double numero1 = pilaNumeros.pop();
        char operador = pilaOperadores.pop();

        double resultado = 0;

        switch (operador) {
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                resultado = numero1 / numero2;
                break;
        }

        pilaNumeros.push(resultado);
    }

    private static int getPrecedencia(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        }
        return 0;
    }
}