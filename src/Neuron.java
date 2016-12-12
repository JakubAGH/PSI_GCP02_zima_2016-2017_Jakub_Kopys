/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.exp;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Neuron {

    double[] wagi;
    double[] wartosci;
    double suma;
    double blad;
    double info;
    double odpowiedz;
    public static double[][] dane;

    Neuron() {
        FileReader fr = null;
        String line = "";
        try {
            fr = new FileReader("data.txt");
        } catch (FileNotFoundException e) {
            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
        }
        BufferedReader bfr = new BufferedReader(fr);
        this.wagi = new double[10];
        this.wartosci = new double[9];
        this.suma = 0;
        this.blad = 0;
        this.info = 0;
        this.odpowiedz = 0;
        Neuron.dane = new double[9000][10];
        for (int i = 0; i < 900; i++) {
            try {
                String parts[] = bfr.readLine().split(",");
                for (int j = 0; j < 10; j++) {
                    Neuron.dane[i][j] = Double.parseDouble(parts[j]);
                }
            } catch (IOException ex) {
                Logger.getLogger(Neuron.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    void WczytajWartosci(int i) {
        for (int j = 0; j < 9; j++) {
            this.wartosci[j] = Neuron.dane[i][j];
        }
    }

    void Suma() {
        this.suma = 0;
        for (int i = 0; i < 9; i++) {
            this.suma += wagi[i] * wartosci[i];
        }
        this.suma += 1 * wagi[9];

    }

    void LosujWagi() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            wagi[i] = rand.nextInt(11) / 10.0;
        }
    }

    void FunkcjaSkokowa() {
        if (this.suma >= 0) {
            this.odpowiedz = 1;
        } else {
            this.odpowiedz = 0;
        }
    }

    void FunkcjaSigmoidalna() {
        this.odpowiedz = 2 / (1 + exp(-this.suma)) - 1;
    }
    void Weryfikacja(int k) {
        if (this.odpowiedz != Neuron.dane[k][9]) {
            blad++;
        }
    }


    void UczeniePerceptron(int k) {
        if (this.odpowiedz > Neuron.dane[k][9]) {

            blad++;
            for (int i = 0; i < 9; i++) {
                this.wagi[i] += this.wartosci[i];
            }
        } else if (this.odpowiedz < Neuron.dane[k][9]) {
            blad++;
            for (int i = 0; i < 9; i++) {
                this.wagi[i] -= this.wartosci[i];
            }
        }
    }

    void UczenieWidrowa(int k) {

        double roznica = Neuron.dane[k][9] - this.odpowiedz;
        if (roznica != 0) {
            blad++;
        }
        if (roznica == 1) {
            info++;
        }
        double n = 0.01;

        for (int i = 0; i < 9; i++) {
            this.wagi[i] += n * roznica * Neuron.dane[k][i];

        }
        this.wagi[9] += n * roznica;
    }
    void WTA(int k) {

        double n = 0.1;

        for (int i = 0; i < 9; i++) {
            this.wagi[i] += n * (Neuron.dane[k][i] - this.wagi[i]);

        }
    }


}
