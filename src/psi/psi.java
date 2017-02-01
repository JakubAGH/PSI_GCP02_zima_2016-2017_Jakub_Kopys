package psi;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class psi {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {

    Neuron neuron = new Neuron();
    Neuron neuron2 = new Neuron();
    Neuron neuron3 = new Neuron();
    Neuron neuron4 = new Neuron();

    FileReader fr = new FileReader("data1.txt");

    double sum = 0;

    FileWriter fw = null;
    FileWriter fw2 = null;
    try {
      fw = new FileWriter("1.txt");
      fw2 = new FileWriter("1m.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedWriter bw = new BufferedWriter(fw);
    BufferedWriter bw2 = new BufferedWriter(fw2);
    BufferedReader bfr = new BufferedReader(fr);

    int i = 50;
    for (int n = 0; n < 45; n++) {

      neuron2.gitcounter = 0;
      neuron3.gitcounter = 0;

      neuron4.wtf2(i);

      System.out.println(neuron4.niegitcounter);
      System.out.println("epoka nr " + n);

      sum = (neuron2.niegitcounter + neuron3.niegitcounter + neuron4.niegitcounter) / 7000.0;
      bw.write("" + sum);
      bw.newLine();
      bw2.write("" + (sum * 100.0));
      bw2.newLine();

      System.out.println("");
      neuron4.niegitcounter = 0;
    }

    try {
      bw.close();
      fw.close();
      bw2.close();
      fw2.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
