public class Carro {
    private double quilometragem;
    private double capacidadeTanque;
    private double volumeCombustivel;
    private double consumoMedio;
    private double velocidadeAtual;
    private double velocidadeMax;
    private double aceleracaoMedia;

    public Carro(
            double capacidadeTanque,
            double consumoMedio,
            double velocidadeMax,
            double aceleracaoMedia ) {
        setCapacidadeTanque(capacidadeTanque);
        setConsumoMedio(consumoMedio);
        setVelocidadeMax(velocidadeMax);
        setAceleracaoMedia(aceleracaoMedia);
        setVelocidadeAtual(0);
        setVolumeCombustivel(0);
        setQuilometragem(0);
    }

    public void setAceleracaoMedia(double aceleracaoMedia){
            this.aceleracaoMedia = aceleracaoMedia;
    }

    public void setVelocidadeMax(double velocidadeMax){
            this.velocidadeMax = velocidadeMax;
    }

    public void setVelocidadeAtual(double velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public void setConsumoMedio(double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    public void setVolumeCombustivel(double volumeCombustivel) {
        this.volumeCombustivel = volumeCombustivel;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getAceleracaoMedia(){
        return this.aceleracaoMedia;
    }

    public double getVelocidadeMax() {
        return this.velocidadeMax;
    }

    public double getVelocidadeAtual() {
        return this.velocidadeAtual;
    }

    public double getConsumoMedio() {
        return this.consumoMedio;
    }

    public double getVolumeCombustivel() {
        return this.volumeCombustivel;
    }

    public double getCapacidadeTanque() {
        return this.capacidadeTanque;
    }

    public double getQuilometragem() {
        return this.quilometragem;
    }

    public void abastecer(double custoLitro, double valorPagoFrentista) {
        double litros = valorPagoFrentista / custoLitro;
        double valLitros = this.volumeCombustivel + litros;

        if (valLitros > this.capacidadeTanque){
            System.out.println("Não é possivel abastecer, valor pedido ultrapassa capacidade do tanque.");
        } else {
            this.volumeCombustivel = valLitros;
            System.out.println("Abastecimento realizado com sucesso!");
        }
    }

    public void acelerar(double tempo) throws Exception {
        double distancia = (this.velocidadeAtual * tempo) + ((this.aceleracaoMedia * (tempo * tempo)) / 2);
        double distanciaAutonomia = this.volumeCombustivel * this.consumoMedio;

        if (distanciaAutonomia >= distancia) {
            double velocidade = this.velocidadeAtual + (this.aceleracaoMedia * tempo);
            if (velocidadeAtual <= this.velocidadeMax){
                this.volumeCombustivel -= distancia / this.consumoMedio;
                this.quilometragem += distancia / 1000;
                this.velocidadeAtual = velocidade;
            } else {
                double tempoPerc = (this.velocidadeMax - this.velocidadeAtual) / this.aceleracaoMedia;
                double distanciaPerc = (this.velocidadeAtual * (tempoPerc)) + ((this.aceleracaoMedia * (tempoPerc * tempoPerc)) / 2);
                double distanciaVelConst = 0;
                this.velocidadeAtual = this.velocidadeMax;
                if (distanciaPerc < distancia) {
                    distanciaVelConst = (tempo - tempoPerc) * this.velocidadeMax;
                }
                this.volumeCombustivel -= (distanciaPerc + distanciaVelConst) / this.aceleracaoMedia;
                this.quilometragem += (distanciaVelConst + distanciaPerc) / this.consumoMedio;
            }
        }
    }

    public void frear(double tempo){
        if(this.velocidadeAtual > 0) {
            double velocidade = this.velocidadeAtual + ((this.aceleracaoMedia * -1) * tempo);
            if (velocidade >= 0){
                this.velocidadeAtual = velocidade;
            } else {
                this.velocidadeAtual = 0;
            }
            double distancia = ((this.velocidadeAtual * tempo) + (((this.aceleracaoMedia * -1) * (tempo * tempo)) / 2)) * -1;
            this.quilometragem += distancia / 1000;
        } else {
            System.out.println("O veiculo esta parado!");
        }
    }
}