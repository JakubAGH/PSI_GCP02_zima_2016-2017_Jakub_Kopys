/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Siec {

    Warstwa[] warstwy;
    int iloscWarstw;

    void uczenieDelta(int k) {
        for (int i = 0; i < iloscWarstw; i++) {
            warstwy[i].Delta(k);
        }
    }

    void Propagacja() {
        warstwy[iloscWarstw - 1].PropagacjaWsteczna();
    }

}
