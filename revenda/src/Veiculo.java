

public class Veiculo {

    private int id;
    private Integer proprietario;
    private String cor;
    private Float valor;
    private Categoria categoria;
    private Modelo modelo;
    private String status;

    Veiculo( int id, int proprietario, String cor, Float valor, String status){
        this.id = id;
        this.proprietario = proprietario;
        this.cor = cor;
        this.valor = valor;
        this.status = status;
    }

    
    public int getId() {
        
        return id;
    }

    
    public Integer getProprietario() {
        
        return proprietario;
    }

    public void alterarProprietario(int comprador) {
        this.proprietario =  comprador;
    }
    public String getCor() {
       
        return cor;
    }

    
    public Float getValor() {
       
        return valor;
    }

    public Categoria getCategoria(){
        return categoria;
    }
    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public Modelo getModelo(){
        return modelo;
    }

    public void setModelo(Modelo modelo){
        this.modelo =  modelo;
    }

    public String getStatus(){
        return status;
    }

    public void alterarStatus(String status){
        this.status =  status;
    }
    
}

