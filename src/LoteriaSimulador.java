import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LoteriaSimulador {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		ArrayList<Integer> numeros = new ArrayList<Integer>(), aleatorio = new ArrayList<Integer>();
		String entrada = "", resultados = "";
		String[] dezenas, intervalo;
		Random dezenaAleatoria = new Random();
		int contador, numeroAleatorio, repeticao, menor, maior, provisorio;

		System.out.println("*** Loteria-Simulador *************************************************************************************"
		+ "\n* Este programa tem o objetivo de testar estatísticas de loterias jogando números aleatórios até acertar. *"
		+ "\n* Para abortar, pressione Ctrl+C                                                                          *"
		+ "\n\nInsira os números a serem testados separando-os por vírgula:\n");

		entrada = teclado.nextLine();
		dezenas = entrada.split(",");

		for (String numero : dezenas) {
			if (!numeros.contains(Integer.parseInt(numero)) && Integer.parseInt(numero)>=0) numeros.add(Integer.parseInt(numero));
			else {
				System.out.println("\nNúmero a ser testado repetido ou negativo.\n\n");
				System.exit(0);
			}
		}

		System.out.println("\nInsira o intervalo de números que podem ser sorteados separando o menor e o maior número por vírgula:");
		entrada = teclado.nextLine();
		intervalo = entrada.split(",");
		menor = Integer.parseInt(intervalo[0]);
		maior = Integer.parseInt(intervalo[1]);

		if (menor>maior) {
			provisorio = menor;
			menor = maior;
			maior = provisorio;
		} else if (menor==maior) {
			System.out.println("\nIntervalo inválido.\n\n");
			System.exit(0);
		} else if (menor<0 || maior <0) {
			System.out.println("\nIntervalo negativo.\n\n");
			System.exit(0);
		}

		for (int numero : numeros) {
			if (!(numero>=menor && numero<=maior)) {
				System.out.println("\nNúmero a ser testado fora do intervalo.\n\n");
				System.exit(0);
			}
		}

		System.out.println("\nInsira quantas vezes testar:");
		entrada = teclado.nextLine();
		repeticao = Integer.parseInt(entrada);

		if (repeticao<1) {
			System.out.println("\nRepetição menor que 1.\n\n");
			System.exit(0);
		}

		teclado.close();

		numeros.sort(null);

		for (int i=1; i<=repeticao; i++) {

			contador = 1;
			aleatorio.clear();

			while (aleatorio.equals(numeros)==false) {

				aleatorio.clear();
				while (aleatorio.size()<numeros.size()) {
					numeroAleatorio = dezenaAleatoria.nextInt((maior+1)-menor) + menor;
					if (!aleatorio.contains(numeroAleatorio)) aleatorio.add(numeroAleatorio);
				}
				aleatorio.sort(null);
				System.out.println(i+") " + contador + ") " + aleatorio.toString());
				contador++;

			}

			resultados += "\nTeste " + i + ", acertou na aposta " + String.format("%,d",contador-1);

		}

		System.out.print("\nGanhou na(s) aposta(s) de número(s): "+resultados+"\n\n");

	}

}
