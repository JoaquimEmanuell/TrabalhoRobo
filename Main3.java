package trabalhopooo2;

import java.util.Scanner;

public class Main3 {
	static Tabuleiro cores = new Tabuleiro();
	static Tabuleiro t3 = new Tabuleiro();
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
		Scanner input = new Scanner(System.in);	
		do {
			if(cont==0) {
				cont++;
				System.out.println("Escolha a cor do Robo comum");
				cores.mostrarCoresDisponiveis();
				int num = input.nextInt();
				String cor = cores.corEscolhida(num);
				System.out.println(cont);
				Robo p1 = new Robo(cor, cont);	
				t3.adicionarRobo(p1);
				p1.mostrarPosicao();
				//input.close();
			}
			else if(cont==1) {
				cont++;
				System.out.println("Escolha a  cor do Robo inteligente");
				cores.mostrarCoresDisponiveis();
				int num = input.nextInt();
				String cor = cores.corEscolhida(num);
				Robo p1= new RoboInteligente(cor,cont);	
				t3.adicionarRobo(p1);
				p1.mostrarPosicao();
			}
		}while(cont<2);
	}
	public static void posicaoAlimento() {
		Scanner input = new Scanner(System.in);	
		System.out.println("Digite a posicao em que o alimento se encontra no eixo X \n");
		int posicaoX = input.nextInt();
		System.out.println("Digite a posicao em que o alimento se encontra no eixo Y \n");
		int posicaoY = input.nextInt();
		t3.alimentoTabuleiro(posicaoX, posicaoY);
	}
	public static void comecarPartida(){
		Scanner input = new Scanner(System.in);
		while(j<2){
			System.out.println("oi");
			for(int i=0; i<cont; i++) {
				Robo r = t3.procurarRobo(i+1);
				if(r.getVencedor()==0) {
				System.out.println(r.getCor());
				r.mostrarPosicao();
				int acao = (int)(Math.random()*4) +1;				
				try {
					r.moverRobo(acao);
				}
				catch(BusinessException e) {
					System.out.println(e.getMessage());
					//i--;
				}

				r.mostrarPosicao();
				if(t3.verificarRoboAcharComida(r.getNumero())) {
					r.mostrarPosicao();
					System.out.println("Parabens robo da cor " + r.getCor() + " voce achou o alimento!\n");
					r.mostrarMovimento();
					r.setVencedor(1);
					op=0;
					j++;
				}
				
				System.out.println("Aperte enter para continuar.");
				String acao1= input.nextLine();
				}
				else {
					System.out.println("-------------");
				}
			}
			
		}

	}
}
