import java.util.ArrayList;

public class Cliente {
    private int codigo;
    private String nome;
    ArrayList<Integer> carros =  new ArrayList<Integer>();

    Cliente(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public ArrayList<Integer> Carros() {
        return carros;
    }

    public void setNovoCarro(int placa){
        carros.add(placa);
    }

    public void excluirPlaca(int placa){
        for(int x = 0; x< carros.size(); x++){
            if(carros.get(x) == placa){
                carros.remove(x);
            }
        }
    }

    public boolean checkPlacasCliente(int placa){

        for(int x = 0; x < carros.size(); x++){
            if(carros.get(x).equals(placa)){
                return true;
            } 
        }
        return false;
    }      
}
