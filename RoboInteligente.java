package trabalhopooo2;

public class RoboInteligente extends Robo {
	private int estado;
	private int movimentoAnterior;
	public RoboInteligente(String cor, int num) {
		super(cor, num);
		estado =1;
		vencedor =0;
		// TODO Auto-generated constructor stub
	}
	public boolean moverRobo(int acao) {
		if(estado == 0) {
			switch(movimentoAnterior) {
			case 1:
				this.posicaoY--;
				estado = 1; 
				break;	
			case 2:
				this.posicaoY++;
				estado = 1;
				break;
			case 3:
				this.posicaoX--;
				estado = 1;
				break;
			case 4:
				this.posicaoX++;
				estado = 1;
			    break;
		}
		}
			else if(estado == 1) {
			if(acao==1) {
				this.posicaoY++;
				movimentoAnterior =  acao;
				validarMovimento();
				movimentosValidos++;
				estado = 1;
				return true;
			}
			if(acao==2) {
				this.posicaoY--;
				movimentoAnterior =  acao;
				validarMovimento();
				movimentosValidos++;
				estado = 1;
				return true;

			}
			if(acao==3) {
				this.posicaoX++;	
				movimentoAnterior =  acao;
				validarMovimento();
				movimentosValidos++;
				estado = 1;
				return true;
			}

			if(acao==4) {
				this.posicaoX--;
				movimentoAnterior =  acao;
				validarMovimento();
				movimentosValidos++;
				estado = 1;
				return true;
			}
		}
		
	
		return false;
	}
	private void validarMovimento() {
		if(posicaoY<0) {
			this.posicaoY++;
			movimentosInvalidos++;
			estado = 0;
			throw new BusinessException ("Movimento invalido no eixo y");
		}
		if(posicaoX<0) {
			this.posicaoX++;
			movimentosInvalidos++;
			estado = 0;
			throw new BusinessException("Movimento invalido no eixo x");
		}
		if(posicaoY>5) {
			this.posicaoY--;
			movimentosInvalidos++;
			estado = 0;
			throw new BusinessException ("Movimento invalido no eixo y");
		}
		if(posicaoX>5) {
			this.posicaoX--;
			movimentosInvalidos++;
			estado = 0;
			throw new BusinessException("Movimento invalido no eixo x");
		}
	}
}
