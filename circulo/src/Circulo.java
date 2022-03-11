import java.util.Locale;
import java.util.Scanner;

public class Circulo {
    private double x;
    private double y;
    private double raio;

    public Circulo(double x, double y, double raio) {
        setX(x);
        setY(y);
        setRaio(raio);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getRaio() {
        return this.raio;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public void alteraCentro(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getArea() {
        double area = Math.PI * Math.pow(this.raio, 2);
        return area;
    }

    public double getCircunferencia() {
        double circunferencia = (2 * Math.PI) * this.raio;
        return circunferencia;
    }

    public void aumentarRaio(double percentual) {
        this.raio = this.raio + (percentual / 100) * this.raio;
    }

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Scanner sc = new Scanner(System.in);

        double x, y, raio;
        int opcao;

        Util.clrscr();

        System.out.print("Digite o valor da cordenada X : ");
        x = sc.nextDouble();
        System.out.print("Digite o valor da cordenada Y : ");
        y = sc.nextDouble();
        System.out.print("Digite o valor do raio: ");
        raio = sc.nextDouble();

        Circulo meuCirculo = new Circulo(x, y, raio);

        do {
            System.out.println("\n\n");
            System.out.println("\tMenu Circulo");
            System.out.println("1. Aumentar Raio");
            System.out.println("2. Definir Centro");
            System.out.println("3. Mostrar Area");
            System.out.println("4. Mostrar Comprimento Circunferencia");
            System.out.println("Opcao: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Util.clrscr();
                    System.out.println("% a ser aumentado no raio: ");
                    double percentual = sc.nextDouble();
                    meuCirculo.aumentarRaio(percentual);
                    Util.clrscr();
                    System.out.println("Novo raio: " + meuCirculo.getRaio());
                    break;
                case 2:
                    Util.clrscr();
                    System.out.print("Digite o valor da cordenada X : ");
                    double xAlt = sc.nextDouble();
                    System.out.print("Digite o valor da cordenada Y : ");
                    double yAlt = sc.nextDouble();
                    meuCirculo.alteraCentro(xAlt, yAlt);
                    Util.clrscr();
                    System.out.println("Novo x: " + meuCirculo.getX());
                    System.out.println("Novo y: " + meuCirculo.getY());
                    break;
                case 3:
                    Util.clrscr();
                    double area = meuCirculo.getArea();
                    System.out.println("Area: " + area);
                    break;
                case 4:
                    Util.clrscr();
                    double circunferencia = meuCirculo.getCircunferencia();
                    System.out.println("Circunferencia: " + circunferencia);
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        sc.close();

    }

}