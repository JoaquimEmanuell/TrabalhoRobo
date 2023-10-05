package trabalhopooo2;

public class Robo {
	protected String cor;
	protected int posicaoX;
	protected int posicaoY;
	protected int numero;
	protected int movimentosValidos;
	protected int movimentosInvalidos;
	protected int vencedor;
	public Robo(String cor, int num) {
		this.cor = cor;
		this.posicaoX = 0;
		this.posicaoY = 0;
		this.numero = num;
		movimentosValidos = 0;
		movimentosInvalidos = 0;
		this.vencedor=0; 
	}
	public boolean moverRobo(int acao) {
		if(acao==1) {
			this.posicaoY++;
			validarMovimento();
			movimentosValidos++;
			return true;
		}
		if(acao==2) {
			this.posicaoY--;
			validarMovimento();
			movimentosValidos++;
			return true;

		}
		if(acao==3) {
			this.posicaoX++;	
			validarMovimento();
			movimentosValidos++;
			return true;
		}

		if(acao==4) {
			this.posicaoX--;
			validarMovimento();
			movimentosValidos++;
			return true;
		}
		return false;
	}
	public boolean moverRobo(String acao) {
		if(acao.equals("up")) {
			this.posicaoY++;
			validarMovimento();
			movimentosValidos++;
			return true;
		}
		else if(acao.equals("down")) {
			this.posicaoY--;
			validarMovimento();
			movimentosValidos++;
			return true;

		}
		else if(acao.equals("right")) {
			this.posicaoX++;	
			validarMovimento();
			movimentosValidos++;
			return true;
		}

		else if(acao.equals("left")) {
			this.posicaoX--;
			validarMovimento();
			movimentosValidos++;
			return true;
		}
		return false;
	}
	private void validarMovimento() {
		if(posicaoY<0) {
			this.posicaoY++;
			movimentosInvalidos++;
			throw new BusinessException ("Movimento invalido no eixo y");
		}
		if(posicaoX<0) {
			this.posicaoX++;
			movimentosInvalidos++;
			throw new BusinessException("Movimento invalido no eixo x");
		}
		if(posicaoY>5) {
			this.posicaoY--;
			movimentosInvalidos++;
			throw new BusinessException ("Movimento invalido no eixo y");
		}
		if(posicaoX>5) {
			this.posicaoX--;
			movimentosInvalidos++;
			throw new BusinessException("Movimento invalido no eixo x");
		}
	}
	public void mostrarPosicao() {
		System.out.println("Robo da cor " + cor + " Posicao eixo x: " + posicaoX + " Posicao eixo y " + posicaoY);
	}
	public void mostrarMovimento() {
		System.out.println("Robo da cor " + cor + "Movimento validos: " + movimentosValidos + " Movimentos invalidos " + movimentosInvalidos);
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getPosicaoX() {
		return posicaoX;
	}
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}
	public int getPosicaoY() {
		return posicaoY;
	}
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getMovimentosValidos() {
		return movimentosValidos;
	}
	public void setMovimentosValidos(int movimentosValidos) {
		this.movimentosValidos = movimentosValidos;
	}
	public int getMovimentosInvalidos() {
		return movimentosInvalidos;
	}
	public void setMovimentosInvalidos(int movimentosInvalidos) {
		this.movimentosInvalidos = movimentosInvalidos;
	}
	public int getVencedor() {
		return vencedor;
	}
	public void setVencedor(int vencedor) {
		this.vencedor = vencedor;
	}
}

