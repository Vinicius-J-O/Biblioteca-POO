import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean rodando = true;
        ArrayList<Usuario> usuarios = new ArrayList<>();

        System.out.println("=================================");
        System.out.println("==           Bem Vindo         ==");
        System.out.println("=================================");
        do {
            System.out.println("==============================================");
            System.out.println("==          1.Cadastrar                     ==");
            System.out.println("==          2.Login                         ==");
            System.out.println("==          3.Informações de login          ==");
            System.out.println("==          0.Sair                          ==");
            System.out.println("==============================================");
            System.out.println("R:");
            String resp = sc.nextLine().trim();

            switch (resp) {
                case "1":
                    System.out.println("Digite o seu nome");
                    String nome = sc.nextLine().trim();
                    System.out.println("Digite o seu sobrenome");
                    String sobrenome = sc.nextLine();
                    String nomeCompleto = nome + " " + sobrenome;
                    System.out.println("Digite a senha");
                    String senha = sc.nextLine().trim();
                    System.out.println("Digite o seu email");
                    String email = sc.nextLine().trim();
                    Usuario novoUsuario = new Usuario(nome, nomeCompleto, email, senha, sobrenome);
                    usuarios.add(novoUsuario);
                    System.out.println("Novo usuário cadastrado com sucesso! ID: " + novoUsuario.getId());
                    break;
                
                case "2":
                     if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado ainda!");
                        break;
                    }

                    System.out.println("Email:");
                    String loginEmail = sc.nextLine();
                    System.out.println("Senha:");
                    String loginSenha = sc.nextLine();
                    Usuario usuarioLogado = null;
                     for (Usuario u : usuarios) {
                        if (u.getEmail().equals(loginEmail) && u.verificarSenha(loginSenha)) {
                            usuarioLogado = u;
                            break;
                        }
                    }
                     if (usuarioLogado != null) {
                        System.out.println("Login realizado com sucesso!");
                        System.out.println("Bem-vindo(a), " + usuarioLogado.getNomeCompleto() + "!");
                    } else {
                        System.out.println(" Email ou senha inválidos!");
                    }
                break;
                case "0":
                    rodando = false;
                default:
                    System.out.println(" Opção inválida! Digite 0, 1 ou 2.");
                    break;
            }

        } while (rodando);

        sc.close();
    }
}
