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
		int contador, numeroAleatorio, repeticao, menor, maior;

		System.out.println("*** Loteria-Simulador ************************************************************************************"
		+ "\n* Este programa tem o objetivo de testar estatísticas de loterias jogando número aleatórios até acertar. *"
		+ "\n* Para abortar, pressione Ctrl+C                                                                         *"
		+ "\n\nInsira os números a serem testados separando-os por vírgula:\n");

		entrada = teclado.nextLine();
		dezenas = entrada.split(",");

		for (String numero : dezenas) numeros.add(Integer.parseInt(numero));

		System.out.println("\nInsira o intervalo de números que podem ser sorteados separando-os por vírgula (menor, maior):");
		entrada = teclado.nextLine();
		intervalo = entrada.split(",");
		menor = Integer.parseInt(intervalo[0]);
		maior = Integer.parseInt(intervalo[1]);

		System.out.println("\nInsira o número de testes:");
		entrada = teclado.nextLine();
		repeticao = Integer.parseInt(entrada);

		teclado.close();

		numeros.sort(null);

		for (int i=1; i<=repeticao; i++) {

			contador = 1;
			aleatorio.clear();

			while (aleatorio.equals(numeros)==false) {

				aleatorio.clear();
				while (aleatorio.size()<numeros.size()) {
					numeroAleatorio = dezenaAleatoria.nextInt(maior) + menor;
					if (!aleatorio.contains(numeroAleatorio)) aleatorio.add(numeroAleatorio);
				}
				aleatorio.sort(null);
				System.out.println(i+") " + contador + ") " + aleatorio.toString());
				contador++;

			}

			resultados += "\nTeste " + i + ", acertou na aposta " + String.format("%,d",contador-1);

		}

		System.out.print("\nGanhou na(s) aposta(s) de número(s): "+resultados);

	}

}
