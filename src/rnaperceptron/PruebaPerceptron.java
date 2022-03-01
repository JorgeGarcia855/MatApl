package rnaperceptron;

public class PruebaPerceptron {

	public static void main(String[] args) {
		Perceptron p = new Perceptron();
		// Salidas esperadas - Compuerta OR
		double[] objetivos = { -1, 1, 1, 1 };
		// Entradas
		// x1, x2, &#952;
		double[][] entradas = { { -1, -1, 1 }, { -1, 1, 1 }, { 1, -1, 1 }, { 1, 1, 1 } };
		p.setEntradas(entradas);
		p.setObjetivos(objetivos);
		p.inicializarPesos();
		p.entrenar(); // Está es la primera fase - Fase de entrenamiento
		System.out.println("********** Pesos Finales **********");
		p.imprimirPesos();
	}
}