import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Usuario user = new Usuario();
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Digite o nome do usuário: ");
        user.nome = scanner.nextLine();
        System.out.println("Hello, " + user.nome + "!");
        scanner.close();
    }
}
