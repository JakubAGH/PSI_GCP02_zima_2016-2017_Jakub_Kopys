/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psi;

public class Record {

  double[] tab;

  int result;

  public Record(String line) {

    this.tab[0] = Double.parseDouble(line.charAt(0) + "") - 1;
    this.tab[1] = Double.parseDouble(line.charAt(2) + "") - 1;
    this.tab[2] = Double.parseDouble(line.charAt(4) + "") - 1;
    this.tab[3] = Double.parseDouble(line.charAt(6) + "") - 1;
    this.tab[4] = Double.parseDouble(line.charAt(8) + "") - 1;
    this.tab[5] = Double.parseDouble(line.charAt(10) + "") - 1;
    this.tab[6] = Integer.parseInt(line.charAt(12) + "");
    this.tab[7] = Integer.parseInt(line.charAt(14) + "");
    this.tab[8] = Integer.parseInt(line.charAt(16) + "");
    this.tab[9] = Integer.parseInt(line.charAt(18) + "");
  }

}
