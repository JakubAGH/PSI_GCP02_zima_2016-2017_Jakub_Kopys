/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Psi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Neuron neuron = new Neuron();
        neuron.LosujWagi();
        double start = System.currentTimeMillis();
        for (int k = 0; k < 30; k++) {
            neuron.blad = 0;
            neuron.info = 0;
            for (int i = 0; i < 900; i++) {
                neuron.suma = 0;
                neuron.WczytajWartosci(i);
                neuron.Suma();
                neuron.FunkcjaSkokowa();
                neuron.UczenieWidrowa(i);

            }
            System.out.println(neuron.blad / 900.0);
        }
        System.out.println("Czas uczenia: " + (System.currentTimeMillis()-start) +"ms");

    }

}
