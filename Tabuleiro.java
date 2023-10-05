package trabalhopooo2;
import java.util.ArrayList;
public class Tabuleiro {
	private ArrayList<Robo> robos;
	private ArrayList<Cor> cores;
	private int [][] posicoes =  new int [6][6];
	public Tabuleiro() {
		cores =  new ArrayList<Cor>();
		robos = new ArrayList<Robo>();
	}
	public void alimentoTabuleiro(int posicaoX, int posicaoY) {
		for(int i = 0; i<6; i++) {
			for( int j=0; j<6; j++) {
				if(i == posicaoX  && j== posicaoY ) {
					posicoes[i][j] = 1;

				}
				else {
					posicoes[i][j] = 0; 

				}
			}
		}
	}
	public void adicionarRobo(Robo r) {
		robos.add(r);
	}
	public Robo procurarRobo(int cont) {
		for(Robo r : robos) {
			if(r.getNumero()==cont) {
				return r;
			}
		}
		return null;
	}
	public void mostrarCampo() {
		System.out.println(posicoes[4][2]);
	}
	public boolean verificarRoboAcharComida(int num) {
		for(Robo r : robos) {
			if(r.getNumero()==num && posicoes[r.getPosicaoX()][r.getPosicaoY()]==1) {
				return true;
			}
		}
		return false;
	}
	public String corEscolhida(int num) {
		int i=1;
		for(Cor c : cores) {
			if(i==num) {
				cores.remove(c);
				i++;
				return c.getCor();
			}
			i++;
		}
		return null;
	}
	public void mostrarCoresDisponiveis() {
		int i=1;
		for (Cor c : cores) {
			System.out.println(i + " -> " + c.getCor());
			i++;
		}
	}
	public void adicionarCor(Cor c) {
		cores.add(c);
	}
}


