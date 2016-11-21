/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Warstwa {

    Neuron[] neurony;
    double[] wagi;
    Warstwa poprzedniaWarstwa;
    int liczbaNeuronow;

    public Warstwa(Neuron[] neurony, int liczbaNeuronow) {
        this.liczbaNeuronow = liczbaNeuronow;
        this.wagi = new double[9];
        this.neurony = new Neuron[liczbaNeuronow];

    }

    public void Delta(int k) {

        for (int i = 0; i < liczbaNeuronow; i++) {
            neurony[i].UczenieWidrowa(k);
        }
    }

    public void PropagacjaWsteczna() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                poprzedniaWarstwa.neurony[i].blad += neurony[j].blad * wagi[j];
            }
        }

    }

}