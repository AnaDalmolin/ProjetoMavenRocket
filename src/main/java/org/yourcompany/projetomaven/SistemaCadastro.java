package org.yourcompany.projetomaven;

public class SistemaCadastro {
    public static void main(String[] args) {
        FabricaConexao.conectar();
        CadastroRepository cadastroRepository = new CadastroRepository();
        Cadastro cadastro = new Cadastro();
        cadastro.setNome("Tonico");
        cadastro.setIdade(30);
        cadastro.setId(3);
        cadastroRepository.buscar(4);
        
    }
}
