public class Psi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Neuron neuron = new Neuron();
        LosowanieBezPowtorzenZUsuwaniem los = new LosowanieBezPowtorzenZUsuwaniem(800);
        neuron.LosujWagi();

        int[] losowe = new int[300];
        for (int i = 0; i < 300; i++) {
            losowe[i] = los.get();
        }

        Neuron[] neurony = new Neuron[3];
        for (int i = 0; i < 3; i++) {
            neurony[i] = new Neuron();
        }

        Neuron winner;
        int temp = 0;

        for (int k = 0; k < 30; k++) {
            neuron.blad = 0;
            neuron.info = 0;
            for (int i = 0; i < 900; i++) {
                winner = neurony[0];
                temp = 1;
                for (int m = 0; m < 3; m++) {
                    neurony[m].suma = 0;
                    neurony[m].WczytajWartosci(i);
                    neurony[m].Suma();
                    neurony[m].LosujWagi();
                    neurony[m].FunkcjaSigmoidalna();
                }
                if (neurony[1].odpowiedz > winner.odpowiedz) {
                    winner = neurony[1];
                    temp = 2;
                }
                if (neurony[2].odpowiedz > winner.odpowiedz) {
                    winner = neurony[2];
                    temp = 3;
                }
                winner.WTA(i);
                System.out.println("Aktywowano neuron nr " + temp);

            }
        }

    }

}
