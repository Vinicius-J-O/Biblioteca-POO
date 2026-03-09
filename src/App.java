import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Livros> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuarioLogado = null;

        System.out.println("=================================");
        System.out.println("==           Bem Vindo         ==");
        System.out.println("=================================");

        boolean rodandoMenu = true;
        do {
            System.out.println("==============================================");
            System.out.println("==              MENU PRINCIPAL              ==");
            System.out.println("==                                          ==");
            System.out.println("==          1.Gerenciar Usuarios            ==");
            System.out.println("==          2.Gerenciar livros              ==");
            System.out.println("==          0.Sair                          ==");
            System.out.println("==                                          ==");
            System.out.println("==============================================");
            System.out.println("Resposta (0 a 2.):");
            String respMenu = sc.nextLine().trim();
            switch (respMenu) {

                case "1":
                    boolean rodandoUser = true;
                    do {
                        System.out.println("==============================================");
                        System.out.println("==                                          ==");
                        System.out.println("==            GERENCIAR USUÁRIOS            ==");
                        System.out.println("==          1.Cadastrar                     ==");
                        System.out.println("==          2.Login                         ==");
                        System.out.println("==          3.Informações de login          ==");
                        System.out.println("==          4.Listar Usuarios               ==");
                        System.out.println("==          0.Voltar                        ==");
                        System.out.println("==                                          ==");
                        System.out.println("==============================================");
                        System.out.println("Resposta (0 a 4.):");
                        String respUser = sc.nextLine().trim();

                        switch (respUser) {
                            case "1":
                                System.out.println("=== FAZER CADASTRO ===");
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
                                System.out.println("=== FAZER LOGIN ===");
                                if (usuarios.isEmpty()) {
                                    System.out.println("Nenhum usuário cadastrado ainda!");
                                    break;
                                }

                                System.out.println("Email:");
                                String loginEmail = sc.nextLine();
                                System.out.println("Senha:");
                                String loginSenha = sc.nextLine();

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
                            case "3":
                                System.out.println("=== INFORMAÇÕES DO USUÁRIO LOGADO ===");
                                if (usuarioLogado == null) {
                                    System.out.println(" Nenhum usuário logado!");
                                } else {
                                    System.out.println("Nome: " + usuarioLogado.getNomeCompleto());
                                    System.out.println("Email: " + usuarioLogado.getEmail());
                                    System.out.println("Número de Registro: " + usuarioLogado.getId());
                                }
                                break;
                            case "4":
                                System.out.println("=== USUÁRIOS CADASTRADOS ===");
                                if (usuarios.isEmpty()) {
                                    System.out.println("Nenhum usuário cadastrado!");
                                } else {
                                    for (int i = 0; i < usuarios.size(); i++) {
                                        Usuario u = usuarios.get(i);
                                        System.out.println((i + 1) + ". " + u.getNomeCompleto() + " - " + u.getEmail());
                                    }
                                }
                                break;
                            case "0":
                                rodandoUser = false;
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println(" Opção inválida!");
                                break;
                        }

                    } while (rodandoUser);

                case "2":
                    boolean rodandoLivros = true;
                    do {
                        System.out.println("==============================================");
                        System.out.println("==                                          ==");
                        System.out.println("==             GERENCIAR LIVROS             ==");
                        System.out.println("==          1.Cadastrar Livro               ==");
                        System.out.println("==          2.Listar Livros                 ==");
                        System.out.println("==          3.Buscar Livro                  ==");
                        System.out.println("==          4.Editar Livro                  ==");
                        System.out.println("==          5.Remover Livro                 ==");
                        System.out.println("==          6.Controle de Estoque           ==");
                        System.out.println("==          7.Empréstimos                   ==");
                        System.out.println("==          8.Devoluções                    ==");
                        System.out.println("==          9.Histórico                     ==");
                        System.out.println("==          0.Voltar                        ==");
                        System.out.println("==                                          ==");
                        System.out.println("==============================================");
                        System.out.println("Resposta (0 a 9): ");
                        String respLvr = sc.nextLine().trim();
                        switch (respLvr) {
                            case "1":
                                System.out.println("=== CADASTRAR LIVRO(S) ===");
                                System.out.println("Titulo: ");
                                String titulo = sc.nextLine();
                                System.out.println("Autor: ");
                                String autor = sc.nextLine();
                                System.out.println("Ano de Publicação: ");
                                int ano = sc.nextInt();
                                System.out.println("Gênero/ Categoria: ");
                                String gereno = sc.nextLine();
                                System.out.println("ISBN: ");
                                String isbn = sc.nextLine().trim();
                                System.out.println("Editora: ");
                                String editora = sc.nextLine();
                                System.out.println("Números de Páginas: ");
                                int numPag = sc.nextInt();
                                System.out.println("Quantidade em Estoque: ");
                                int estoque = sc.nextInt();

                                Livros novoLivro = new Livros(titulo, autor, ano, gereno, isbn, editora, numPag,
                                        estoque);

                                livros.add(novoLivro);

                                System.out.println("Novo livro cadastrado com sucesso! ID: " + novoLivro.getId());
                                break;
                            case "2":
                                System.out.println("=== LISTAR LIVROS ===");
                                if (livros.isEmpty()) {
                                    System.out.println("Nenhum livro cadastrado!");
                                } else {
                                    for (int i = 0; i < livros.size(); i++) {
                                        Livros u = livros.get(i);
                                        System.out.println((i + 1) + "Titulo: " + u.getTitulo());
                                    }
                                }

                            default:
                                break;
                        }

                    } while (rodandoLivros);

                    break;
                case "0":
                    rodandoMenu = false;
                    System.out.println("Saindo, até a próxima!");
                    break;

                default:
                    System.out.println(" Opção inválida! Digite 0, 1, ou 3.");
                    break;
            }
        } while (rodandoMenu);

        sc.close();
    }
}
