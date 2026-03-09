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
}
