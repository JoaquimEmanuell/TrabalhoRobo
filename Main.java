package trabalhopooo2;

import java.util.Scanner;
public class Main {
	static Tabuleiro cores = new Tabuleiro();
	static Tabuleiro t1 = new Tabuleiro();
	static int op;
	static int cont=0;
	static int j=0;
	public static void main(String[] args) {
		Cor c1 = new Cor("Preto");
		Cor c2 = new Cor("Azul");
		Cor c3 = new Cor("Branco");
		Cor c4 = new Cor("Verde"); 
		Cor c5 = new Cor("Vermelho");
		Cor c6 = new Cor("Amarelo");
		cores.adicionarCor(c1);
		cores.adicionarCor(c2);
		cores.adicionarCor(c3);
		cores.adicionarCor(c4);
		cores.adicionarCor(c5);
		cores.adicionarCor(c6);

		do {		
			Scanner input = new Scanner(System.in);
			System.out.println(" __________________________________");
			System.out.println("|                                 |");	
			System.out.println("| --Bem Vindos ao jogo do ROBO!-- |");
			System.out.println("|_________________________________|");
			System.out.println("|Opcao 1 ->  Adicionar robo       |");
			System.out.println("|Opcao 2 ->  Posicao do alimento  |");
			System.out.println("|Opcao 3 ->  Comecar a partida    |");
			System.out.println("|_________________________________|");
			op = input.nextInt();
			switch(op) {
			case 1:
				adicionarRobo();
				break;
			case 2: 
				posicaoAlimento();
				break;
			case 3:
				comecarPartida();
				break;
			}

		} while(op!=0);
	}
	public static void adicionarRobo() {
		cont++;
		Scanner input = new Scanner(System.in);	
		System.out.println("Escolha a sua cor");
		cores.mostrarCoresDisponiveis();
		int num = input.nextInt();
		String cor = cores.corEscolhida(num);
		Robo p1 = new Robo(cor, cont);	
		t1.adicionarRobo(p1);
		p1.mostrarPosicao();
		//input.close();
	}
	public static void posicaoAlimento() {
		Scanner input = new Scanner(System.in);	
		System.out.println("Digite a posicao em que o alimento se encontra no eixo X");
		int posicaoX = input.nextInt();
		System.out.println("Digite a posicao em que o alimento se encontra no eixo Y");
		int posicaoY = input.nextInt();
		t1.alimentoTabuleiro(posicaoX, posicaoY);

		//input.close();

	}
	public static void comecarPartida(){
		Scanner input = new Scanner(System.in);
		while(j<1){
			//tabuleiro.mostrarCampo();
			Robo r = t1.procurarRobo(cont);
			System.out.println("Digite a sua acao:\n");
			System.out.println("up\ndown\nleft\nright");
			String acao = input.nextLine();
			try {
				r.moverRobo(acao);
			}
			catch(BusinessException e) {
				System.out.println(e.getMessage());
			}
			r.mostrarPosicao();
			if(t1.verificarRoboAcharComida(r.getNumero())) {
				r.mostrarPosicao();
				System.out.println("Parabens robo da cor " + r.getCor() + " voce achou o alimento!");
				op=0;
				j++;
			}

		}
	}
}
