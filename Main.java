public class Main {
        public static void main(String[] args) {
	    import java.util.Scanner;

            public class InverterString {
                public static void main(String[] args) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Digite uma string: ");
                    String texto = scanner.nextLine();
                    scanner.close();

                    char[] caracteres = texto.toCharArray();
                    int tamanho = caracteres.length;
                    for (int i = 0; i < tamanho / 2; i++) {
                        char temp = caracteres[i];
                        caracteres[i] = caracteres[tamanho - 1 - i];
                        caracteres[tamanho - 1 - i] = temp;
                    }
                    String resultado = new String(caracteres);
                    System.out.println("String invertida: " + resultado);
                }
            }


        }
}
