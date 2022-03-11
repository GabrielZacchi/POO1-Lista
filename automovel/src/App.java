import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Carro carro = new Carro(45, 12, 140, 3);
        Scanner scan = new Scanner(System.in);
        short option;
        do {
            Util.clrscr();
            System.out.println("1. Abastecer");
            System.out.println("2. Acelerar");
            System.out.println("3. Frear");
            System.out.println("4 - Velocidade");
            System.out.println("5 - Combustivel");
            option = scan.nextShort();
            switch (option) {
                case 1:
                    System.out.println("Preco do litro do combustivel: ");
                    double custoLitro = scan.nextDouble();
                    System.out.println("Valor pago: ");
                    double valorPago = scan.nextDouble();  
                    carro.abastecer(custoLitro, valorPago);
                    break;

                case 2:
                    System.out.println("Tempo em segundos acelerando: ");
                    double tempoAcelerando = scan.nextDouble();
                    carro.acelerar(tempoAcelerando);
                    break;
                
                case 3:
                    System.out.println("Tempo em segundos freiando: ");
                    double tempoFreiando = scan.nextDouble();
                    carro.frear(tempoFreiando);
                    break;

                case 4:
                    System.out.println("Velocidade atual: " + carro.getVelocidadeAtual());
                    break;

                case 5:
                    System.out.println("Combustivel no tanque: " + carro.getVolumeCombustivel());
                    break;
            
                default:
                    System.out.println("Opcao Invalida!");
                    break;
            }

        } while(option != 0);
        scan.close();
        
    }
}