public class Livros {
    private String titulo;
    private String autor;
    private int ano;
    private String genero;
    private String isbn;
    private String editora;
    private int numPag;
    private int estoque;
    private static int contador = 1;
    private String id;

    public Livros(String titulo, String autor, int ano, String genero, String isbn, String editora, int numPag,
            int estoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.genero = genero;
        this.isbn = isbn;
        this.editora = editora;
        this.numPag = numPag;
        this.estoque = estoque;
        this.id = "LVR" + contador++;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEditora() {
        return editora;
    }

    public int getNumPag() {
        return numPag;
    }

    public int getEstoque() {
        return estoque;
    }

    public String getId() {
        return id;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        } else {
            System.out.println("Título não pode ser vazio!");
        }
    }

    public void setAutor(String autor) {
        if (autor != null && !autor.trim().isEmpty()) {
            this.autor = autor;
        } else {
            System.out.println("Autor não pode ser vazio!");
        }
    }

    public void setAno(int ano) {
        // Validação básica: ano entre 1400 (primeiros livros) e ano atual + 1
        int anoAtual = java.time.Year.now().getValue();
        if (ano >= 1400 && ano <= anoAtual + 1) {
            this.ano = ano;
        } else {
            System.out.println("Ano inválido! Digite um ano entre 1400 e " + (anoAtual + 1));
        }
    }

    public void setGenero(String genero) {
        if (genero != null && !genero.trim().isEmpty()) {
            this.genero = genero;
        } else {
            System.out.println("Gênero não pode ser vazio!");
        }
    }

    public void setIsbn(String isbn) {
        if (isbn != null && !isbn.trim().isEmpty()) {
            // Remove espaços e hífens para padronizar
            this.isbn = isbn.trim().replaceAll("[- ]", "");
        } else {
            System.out.println("ISBN não pode ser vazio!");
        }
    }

    public void setEditora(String editora) {
        if (editora != null && !editora.trim().isEmpty()) {
            this.editora = editora;
        } else {
            System.out.println("Editora não pode ser vazia!");
        }
    }

    public void setNumPag(int numPag) {
        if (numPag > 0) {
            this.numPag = numPag;
        } else {
            System.out.println("Número de páginas deve ser maior que zero!");
        }
    }

    public void setEstoque(int estoque) {
        if (estoque >= 0) {
            this.estoque = estoque;
        } else {
            System.out.println("Estoque não pode ser negativo!");
        }
    }

    public void adicionarEstoque(int quantidade) {
        this.estoque += quantidade;
    }

    public boolean removerEstoque(int quantidade) {
        if (this.estoque >= quantidade) {
            this.estoque -= quantidade;
            return true;
        }
        return false;
    }
}
