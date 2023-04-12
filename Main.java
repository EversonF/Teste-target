public class Main {
    public static void main(String[] args) {
	import java.util.Scanner;

        public class Fibonacci {
            public static void main(String[] args) {
                Scanner input = new Scanner(System.in);

                System.out.print("Digite um número inteiro: ");
                int numero = input.nextInt();

                int numeroAnterior = 0;
                int numeroAtual = 1;
                int proximoNumero = 0;

                while (proximoNumero < numero) {
                    proximoNumero = numeroAnterior + numeroAtual;
                    numeroAnterior = numeroAtual;
                    numeroAtual = proximoNumero;
                }

                if (proximoNumero == numero) {
                    System.out.println(numero + " pertence à sequência de Fibonacci.");
                } else {
                    System.out.println(numero + " não pertence à sequência de Fibonacci.");
                }
            }
        }

    }
}
