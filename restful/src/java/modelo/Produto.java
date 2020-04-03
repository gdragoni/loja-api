package modelo;

/**
 *
 * @author gdragoni
 */
public class Produto {
    private int codigo;
    private String nome;
    private float preco;
    
    public Produto(int codigo, String nome, float preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }
}
