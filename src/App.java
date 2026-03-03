
import java.util.Scanner;

public class App{
   public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.println("================");
    System.out.println("=  Bem Vindo!  =");
    System.out.println("================");

    boolean rodando = true;
    while (rodando) {
        System.out.println("===================");
        System.out.println("=       MENU      =");
        System.out.println("= 1.Listar Acervo =");
        System.out.println("=      0.Sair     =");
        System.out.println("===================");
    }
    System.out.println("Escolha uma poção: ");
    String opcao = scanner.nextLine().trim();
    switch (opcao) {
        case "1":
            System.out.println("Acervo");
            break;
        case "0":
            rodando = false;
            System.out.println("Até a próxima!");
            break;
        default:
            System.out.println("Opção inválida");
            break;
    }
   }
}