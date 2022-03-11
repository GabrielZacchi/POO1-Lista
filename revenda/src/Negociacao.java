public class Negociacao {
    private int id;
    private int vendedor;
    private int comprador;
    private int veiculo;
    
    Negociacao(int id, int vendedor, int comprador, int veiculo){
        this.id = id;
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.veiculo = veiculo;

    }
    public int getId() {
        return id;
    }
    public int geComprador() {
        return comprador;
    }
    public int getVendedor() {
        return vendedor;
    }
    public int getVeiculo() {
        return veiculo;
    }
}