public class Usuario {
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String id;
    private String nomeCompleto;
    private static int contador = 0;

    public Usuario(String nome, String nomeCompleto, String email, String senha, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.id = "USR" + contador++;
    }

     public boolean verificarSenha(String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getSobrenome() {
        return sobrenome;
    }
    public String getId(){
        return id;
    }
    public String getNomeCompleto(){ 
        return nome + " " + sobrenome;
    }
}
