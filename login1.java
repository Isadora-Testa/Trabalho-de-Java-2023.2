package Telas;

public class login1 {
    private String nome;
    private String senha;

    public login1(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public login1() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static void main(String[] args) {
        // Exemplo: Criando um objeto login1
        login1 cadastro = new login1();
        cadastro.setNome("Nome do Cliente");
        cadastro.setSenha("senha123");

        // Imprimindo informações do cadastro
        System.out.println("Nome: " + cadastro.getNome());
        System.out.println("Senha: " + cadastro.getSenha());

        // Qualquer outra operação que você deseje realizar aqui
    }
}
