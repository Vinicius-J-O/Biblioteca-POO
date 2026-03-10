import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Livros> livros = new ArrayList<>();
        livros.add(new Livros(
                "Dom Casmurro",
                "Machado de Assis",
                1899,
                "Romance",
                "978-85-01-00001-2",
                "Editora Garnier",
                256,
                5));

        livros.add(new Livros(
                "1984",
                "George Orwell",
                1949,
                "Ficção Distópica",
                "978-85-01-00002-9",
                "Companhia das Letras",
                328,
                3));

        livros.add(new Livros(
                "O Pequeno Príncipe",
                "Antoine de Saint-Exupéry",
                1943,
                "Infantil/Filosofia",
                "978-85-01-00003-6",
                "Agir",
                96,
                8));

        livros.add(new Livros(
                "Harry Potter e a Pedra Filosofal",
                "J.K. Rowling",
                1997,
                "Fantasia",
                "978-85-01-00004-3",
                "Rocco",
                208,
                4));

        livros.add(new Livros(
                "O Hobbit",
                "J.R.R. Tolkien",
                1937,
                "Fantasia",
                "978-85-01-00005-0",
                "HarperCollins",
                336,
                2));

        livros.add(new Livros(
                "A Revolução dos Bichos",
                "George Orwell",
                1945,
                "Sátira Política",
                "978-85-01-00006-7",
                "Companhia das Letras",
                152,
                6));

        livros.add(new Livros(
                "O Código Da Vinci",
                "Dan Brown",
                2003,
                "Suspense",
                "978-85-01-00007-4",
                "Sextante",
                432,
                3));

        livros.add(new Livros(
                "O Alquimista",
                "Paulo Coelho",
                1988,
                "Ficção",
                "978-85-01-00008-1",
                "Paralela",
                208,
                7));

        livros.add(new Livros(
                "A Menina que Roubava Livros",
                "Markus Zusak",
                2005,
                "Drama Histórico",
                "978-85-01-00009-8",
                "Intrínseca",
                480,
                2));

        livros.add(new Livros(
                "It: A Coisa",
                "Stephen King",
                1986,
                "Terror",
                "978-85-01-00010-4",
                "Suma",
                1104,
                1));

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
                    break;
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
                        System.out.println("==          7.Controle de Emprestimos       ==");
                        System.out.println("==          0.Voltar                        ==");
                        System.out.println("==                                          ==");
                        System.out.println("==============================================");
                        System.out.println("Resposta (0 a 8): ");
                        String respLvr = sc.nextLine().trim();
                        switch (respLvr) {
                            case "1":
                                if(usuarioLogado == null){
                                    System.out.println("Logue com um usuario primeiro");
                                    break;
                                }
                                System.out.println("=== CADASTRAR LIVRO(S) ===");
                                System.out.println("Titulo: ");
                                String titulo = sc.nextLine();
                                System.out.println("Autor: ");
                                String autor = sc.nextLine();
                                System.out.println("Gênero/ Categoria: ");
                                String genero = sc.nextLine();
                                System.out.println("Ano de Publicação: ");
                                int ano = Integer.parseInt(sc.nextLine());
                                System.out.println("Editora: ");
                                String editora = sc.nextLine();
                                System.out.println("Números de Páginas: ");
                                int numPag = Integer.parseInt(sc.nextLine());
                                System.out.println("Quantidade em Estoque: ");
                                int estoque = Integer.parseInt(sc.nextLine());
                                System.out.print("ISBN: ");
                                String isbn = sc.nextLine().trim();

                                boolean duplicado = false;
                                for (Livros u : livros) {
                                    if (u.getIsbn().equalsIgnoreCase(isbn)) {
                                        System.out.println("ERRO: ISBN já cadastrado para o livro:");
                                        System.out.println(u.getTitulo() + " de " + u.getAutor());
                                        duplicado = true;
                                        break;
                                    }
                                }
                                if (duplicado) {
                                    System.out.println("Cadastro cancelado!");
                                    break;
                                }

                                Livros novoLivro = new Livros(titulo, autor, ano, genero, isbn, editora, numPag,
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
                                        System.out.println((i + 1) + "º: " + u.getTitulo() + "; " + u.getAutor() + "; "
                                                + u.getGenero() +"; ISBN: "+ u.getIsbn()+ "; Quantidade em estoque: " + u.getEstoque() + ".");
                                    }
                                }
                                break;
                            case "3":
                                System.out.println("=== BUSCAR LIVRO ===");

                                if (livros.isEmpty()) {
                                    System.out.println("Nenhum livro cadastrado ainda!");
                                    break;
                                }
                                

                                ArrayList<Livros> livroAchado = new ArrayList<>();

                                System.out.print("Digite título ou autor: ");
                                String termoBusca = sc.nextLine().toLowerCase().trim();

                                for (Livros livro : livros) {
                                    if (livro.getTitulo().toLowerCase().contains(termoBusca) ||
                                            livro.getAutor().toLowerCase().contains(termoBusca)) {
                                        livroAchado.add(livro);
                                    }
                                }

                                if (!livroAchado.isEmpty()) {
                                    System.out.println("Livro(s) encontrado(s):");

                                    for (int i = 0; i < livroAchado.size(); i++) {
                                        Livros livro = livroAchado.get(i);
                                        System.out.println("--- Livro " + (i + 1) + "º ---");
                                        System.out.println("Título: " + livro.getTitulo());
                                        System.out.println("Autor: " + livro.getAutor());
                                        System.out.println("Gênero: " + livro.getGenero());
                                        System.out.println("Ano: " + livro.getAno());
                                        System.out.println("Editora: " + livro.getEditora());
                                        System.out.println("Páginas: " + livro.getNumPag());
                                        System.out.println("Estoque: " + livro.getEstoque());
                                        System.out.println("ISBN: " + livro.getIsbn());
                                        System.out.println("ID: " + livro.getId());
                                    }

                                    System.out.println(" Total encontrado: " + livroAchado.size() + " livro(s)");

                                } else {
                                    System.out.println("Nenhum livro encontrado para: " + termoBusca);
                                }
                                break;
                            case "4":
                                System.out.println("=== EDITAR LIVRO ===");

                                if (livros.isEmpty()) {
                                    System.out.println("Nenhum livro cadastrado ainda!");
                                    break;
                                }
                                if(usuarioLogado == null){
                                    System.out.println("Logue com um usuario primeiro");
                                    break;
                                }

                                System.out.print("Digite o ISBN: ");
                                String isbnBusca = sc.nextLine().toLowerCase().trim();

                                for (Livros u : livros) {
                                    if (u.getIsbn().toLowerCase().contains(isbnBusca)) {
                                        System.out.println("Título: ");
                                        String novoTitulo = sc.nextLine();
                                        if (!novoTitulo.isEmpty()) {
                                            u.setTitulo(novoTitulo);
                                        }
                                        System.out.println("Autor: ");
                                        String novoAutor = sc.nextLine();
                                        if (!novoAutor.isEmpty()) {
                                            u.setAutor(novoAutor);
                                        }
                                        System.out.println("Gênero: ");
                                        String novoGenero = sc.nextLine();
                                        if (!novoGenero.isEmpty()) {
                                            u.setGenero(novoGenero);
                                        }
                                        System.out.println("Ano: ");
                                        String novoAno = sc.nextLine();
                                        if (!novoAno.isEmpty()) {
                                            u.setAno(Integer.parseInt(novoAno));
                                        }
                                        System.out.println("Editora: ");
                                        String novoEditora = sc.nextLine();
                                        if (!novoEditora.isEmpty()) {
                                            u.setEditora(novoEditora);
                                        }
                                        System.out.println("Número de páginas: ");
                                        int novaPag = Integer.parseInt(sc.nextLine());
                                        if (novaPag >= 1) {
                                            u.setNumPag(novaPag);
                                        }

                                        System.out.println("Estoque: ");
                                        int novoEstoque = Integer.parseInt(sc.nextLine());
                                        u.setEstoque(novoEstoque);

                                        System.out.println("Livro editado!");
                                        break;
                                    } else {
                                        System.out.println("ISBN errado ou livro inexistente.");
                                        break;
                                    }
                                }
                                break;
                            case "5":
                                System.out.println("=== REMOVER LIVRO ===");

                                if (livros.isEmpty()) {
                                    System.out.println("Nenhum livro cadastrado ainda!");
                                    break;
                                }
                                if(usuarioLogado == null){
                                    System.out.println("Logue com um usuario primeiro");
                                    break;
                                }

                                System.out.print("Digite o ISBN: ");
                                String isbnRemover = sc.nextLine().toLowerCase().trim();

                                for (int i = 0; i < livros.size(); i++) {
                                    Livros livro = livros.get(i);
                                    if (livro.getIsbn().equalsIgnoreCase(isbnRemover)) {
                                        System.out.println("Você tem certeza que deseja remover esse livro: (s/n): ");
                                        System.out.println(livro.getTitulo() + " de " + livro.getAutor());
                                        String respRemover = sc.nextLine().toLowerCase().trim();
                                        if (respRemover.equals("s")) {
                                            livros.remove(i);
                                            System.out.println("Livro deletado com sucesso!");
                                            break;
                                        } else {
                                            System.out.println("Voltando para o menu.");
                                            break;
                                        }
                                    }
                                }
                                break;
                            case "6":
                                System.out.println("=== CONTROLE DE ESTOQUE ===");
                                if (livros.isEmpty()) {
                                    System.out.println("Nenhum livro cadastrado ainda!");
                                    break;
                                }
                                if(usuarioLogado == null){
                                    System.out.println("Logue com um usuario primeiro");
                                    break;
                                }

                                System.out.print("Digite o ISBN: ");
                                String isbnEstoque = sc.nextLine().toLowerCase().trim();

                                for (int i = 0; i < livros.size(); i++) {
                                    Livros livro = livros.get(i);
                                    if (livro.getIsbn().equalsIgnoreCase(isbnEstoque)) {
                                        System.out.println("====================");
                                        System.out.println("==   1.Adicionar  ==");
                                        System.out.println("==   2.Remover    ==");
                                        System.out.println("==   0.Voltar     ==");
                                        System.out.println("====================");
                                        System.out.println(livro.getTitulo() + " de " + livro.getAutor());
                                        System.out.println("Estoque: " + livro.getEstoque());
                                        String respEstoque = sc.nextLine().trim();
                                        switch (respEstoque) {
                                            case "1":
                                                System.out.println("Quantos você deseja adicionar?");
                                                int add = Integer.parseInt(sc.nextLine());
                                                livro.adicionarEstoque(add);
                                                break;
                                            case "2":
                                                System.out.println("Quantos você deseja remover?");
                                                int remove = Integer.parseInt(sc.nextLine());
                                                livro.removerEstoque(remove);
                                                break;
                                            case "0":
                                                System.out.println("Voltando...");
                                                break;
                                            default:
                                                System.out.println(" Opção inválida! ");
                                                break;
                                        }

                                    }else{
                                        System.out.println("ISBN errado ou livro inexistente.");
                                        break;

                                    }

                                }
                                break;
                            case "7":
                                System.out.println("=== CONTROLE DE EMPRÉSTIMOS ===");
                                if (livros.isEmpty()) {
                                    System.out.println("Nenhum livro cadastrado ainda!");
                                    break;
                                }
                                if(usuarioLogado == null){
                                    System.out.println("Logue com um usuario primeiro");
                                    break;
                                }
                                System.out.println("Quantos livros deseja pegar emprestado ou devolver?");
                                int qtd = Integer.parseInt(sc.nextLine());
                                for(int i = 0; i < qtd; i++){
                                System.out.print("Digite o ISBN do "+(i+1)+"º livro: ");
                                String isbnEmprestimo = sc.nextLine().toLowerCase().trim();
                                for (int j = 0; j < livros.size(); j++) {
                                    Livros livro = livros.get(j);
                                    if (livro.getIsbn().equalsIgnoreCase(isbnEmprestimo)) {
                                        System.out.println("===============================");
                                        System.out.println("==   1.Pedir empréstimo      ==");
                                        System.out.println("==   2.realizar devolução    ==");
                                        System.out.println("==   0.Voltar                ==");
                                        System.out.println("===============================");
                                        System.out.println(livro.getTitulo() + " de " + livro.getAutor());
                                        String respEmprestimo = sc.nextLine().trim();
                                        switch (respEmprestimo) {
                                            case "1":
                                                System.out.println("O livro "+livro.getTitulo() + " de " + livro.getAutor()+ " foi emprestado para "+usuarioLogado.getNomeCompleto());
                                                int remove = 1;
                                                livro.removerEstoque(remove);
                                                break;
                                            case "2":
                                                System.out.println("O livro "+livro.getTitulo() + " de " + livro.getAutor()+ " foi devolvido por "+usuarioLogado.getNomeCompleto());
                                                int add = 1;
                                                livro.adicionarEstoque(add);
                                                break;
                                            case "0":
                                                System.out.println("Voltando...");
                                                break;
                                            default:
                                                System.out.println(" Opção inválida! ");
                                                break;
                                        }

                                    }
                                }
                                }
                               

                            case "0":
                                rodandoLivros = false;
                                System.out.println("Voltando...");
                                break;
                            default:
                                System.out.println(" Opção inválida!");
                                break;
                        }

                    } while (rodandoLivros);

                    break;
                case "0":
                    rodandoMenu = false;
                    System.out.println("Saindo, até a próxima!");
                    break;

                default:
                    System.out.println(" Opção inválida! ");
                    break;
            }
        } while (rodandoMenu);

        sc.close();
    }
}
