import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static int id;
    private static String nome;
    private static int codigo;
    private static int proprietario;
    private static String cor;
    private static Float valor;
    private static int categoria;
    private static int modelo;
    private static int comprador;
    private static int vendedor;
    private static boolean validar;
    private static int opcao;
    private static String status;
    private static int contadorNegociacoes = 0;

    private static ArrayList<Cliente> cliente = new ArrayList<Cliente>();
    private static ArrayList<Negociacao> negociacao = new ArrayList<Negociacao>();
    private static ArrayList<Veiculo> veiculo = new ArrayList<Veiculo>();

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int opcao = 0;
        do{
            System.out.println("Revenda Veiculos!\n");
            System.out.println("1. Cadastrar Cliente\n");
            System.out.println("2. Cadastrar Veiculo\n");
            System.out.println("3. Registrar Negociação\n");
            System.out.println("4. Sair\n");
            opcao = scan.nextInt();

            switch(opcao){
                case 1: 
                    if(cadastroCliente()){
                        System.out.println("Sucesso!\n");
                    }else{
                        System.out.println("Erro ao cadastrar cliente\n");
                    }
                    break;
                case 2:  
                    if(cliente.isEmpty()){
                        System.out.println("Nao cadastrado.\n");
                    }else{
                        cadastroVeiculo();
                    }
                    break;        
                case 3: 
                    if(cliente.isEmpty()){
                        System.out.println("Nao cadastrado.\n");
                    }else{
                        registrarNegociacao();
                    } 
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
            
        } while(opcao != 4);
    }

    private static boolean cadastroCliente(){
        try{
            while(!validar){
                System.out.println("Codigo do Cliente: ");
                codigo = scan.nextInt();
                
                for (int i = 0; i < cliente.size(); i++ ){
                    if(cliente.get(i).getCodigo() == codigo){
                        System.out.println("Cliente ja cadastrado");
                        validar = false;
                    }else{
                        validar = true;
                    }
                }
                System.out.println("Digite o nome do Cliente:");
                nome = scan.nextLine();
        
                cliente.add(new Cliente(codigo, nome));
                return false;
            }   
        }catch(Exception e){
            e.printStackTrace();

            return true;
        }
        return false;
    }

    private static int cadastroVeiculo(){
        try{
            System.out.println("Placa:");
            id = scan.nextInt();
            scan.nextLine();
     
            validar = false;
            while(!validar){
                System.out.println("Proprietario do Veículo:");
                proprietario = scan.nextInt();
                
                if(validarProprietario(proprietario) != -1){
                    for(int x = 0; x <= cliente.size()-1; x++){
                        if(cliente.get(x).getCodigo() == proprietario){
                            cliente.get(x).setNovoCarro(id);
                        }
                    }
                    validar = true;
                }else{
                    System.out.println("\nNao Cadastrado");
                    validar = false;
                }
            }

            System.out.println("\nDigite a cor do Veículo:");
            cor = scan.nextLine();

            System.out.println("\nDigite o Valor do Veículo:");
            valor = scan.nextFloat();   
            status =  "D";
            veiculo.add(new Veiculo(id, proprietario, cor, valor, status));

            categoria = 0;
            while(categoria != 1 && categoria != 2){
                System.out.println("\nSelecione o Tipo de Veículo:");
                System.out.println("\n1 - Carro");
                System.out.println("\n2 - Moto");
                categoria = scan.nextInt();
                scan.nextLine();

                if(categoria != 1 && categoria != 2){
                    System.out.println("\nOpção incorreta\n");
                }else if(categoria == 1){
                    veiculo.get(veiculo.size()-1).setCategoria(Categoria.CARRO);
                }else if(categoria == 2){
                    veiculo.get(veiculo.size()-1).setCategoria(Categoria.MOTO);
                }
            }

            if(veiculo.get(veiculo.size()-1).getCategoria().toString().equals(Categoria.CARRO.toString())){
                validar = false;
                categoria = 0;
                while(!validar){
                    System.out.println("Modelo:\n");
                    System.out.println("1 - HATCH\n");
                    System.out.println("2 - SEDAN\n");
                    System.out.println("3 - CAMINHONETE\n");
                    System.out.println("4 - SUV\n");

                    modelo = scan.nextInt();
                    scan.nextLine();
        
                    if(modelo < 1 && modelo > 5){
                        System.out.println("Opção incorreta\n");
                        validar = false;

                    }else{
                        validar = true;
                        switch(modelo){
                            
                            case 1:
                                veiculo.get(veiculo.size()-1).setModelo(Modelo.HATCH);
                                break;
                            case 2:
                                veiculo.get(veiculo.size()-1).setModelo(Modelo.SEDAN);

                            case 3: 
                                veiculo.get(veiculo.size()-1).setModelo(Modelo.CAMINHONETE);
                                break;
                            case 4:
                                veiculo.get(veiculo.size()-1).setModelo(Modelo.SUV);
                                break;
                        }
                    }
                }
            }else{
                veiculo.get(veiculo.size()-1).setModelo(Modelo.MOTO);
            }
        }catch(Exception e){
            e.getStackTrace();
            return 1;
        }
        return 0;
    }

    private static int validarProprietario(int proprietario) {
        
        for(int x = 0; x <= cliente.size()-1; x++){
            if(cliente.get(x).getCodigo() == proprietario){
                return x;
            }
        }
        return -1;
    }

    private static void registrarNegociacao() throws InterruptedException, IOException {
        validar = false;

        while(!validar){
            System.out.println("Codigo Comprador:\n");
            comprador = scan.nextInt();
            if(validarProprietario(comprador) != -1){
                validar = true;
            }else{
                System.out.println("Nao Cadastrado\n");
                validar = false;
            }
            if(validar){
                System.out.println("Vendedor:\n");
                vendedor = scan.nextInt();

                if(comprador == vendedor){
                    System.out.println("Comprador e vendedor nao podem ser a mesma pessoa.\n");
                    validar = false;
                }else if(validarProprietario(vendedor) == -1){
                    System.out.println("Nao Cadastrado\n");
                    validar = false;
                }else{
                    System.out.println("Digite a placa do Veículo:\n");
                    id = scan.nextInt();
                    
                    if(!cliente.get(validarProprietario(vendedor)).checkPlacasCliente(id)){
                        System.out.println("Veiculo nao cadastrado\n");
                        validar = false;
                    }else{
                        for(int x = 0; x < veiculo.size(); x++){
                            if(veiculo.get(x).getProprietario() == vendedor){

                                veiculo.get(x).alterarProprietario(comprador);
                                status = "V";
                                veiculo.get(x).alterarStatus(status);
                            }    
                        }
                        cliente.get(validarProprietario(vendedor)).excluirPlaca(id);
                        cliente.get(validarProprietario(comprador)).setNovoCarro(id);

                        contadorNegociacoes++;

                    }
                }
            }
        }
    }
}





