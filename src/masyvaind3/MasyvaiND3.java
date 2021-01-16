/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masyvaind3;

/**
 *
 * @author Laimonas
 */
public class MasyvaiND3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int size = 5;
//        char[][][] gameTable = new char[10000][size][size];

        char[][] field = new char[10][10];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (Math.random() < 0.22) {
                    field[i][j] = 'X';
                } else {
                    field[i][j] = '.';
                }
            }
        }
        // pirmine iteracija--------------------
        System.out.println("----------pirmine iteracija----------");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("----------pirmine iteracija----------");
        for (int c = 0; c < 50; c++) {
            char[][] nextField = new char[field.length][field.length];
            // pirminio lauko nustatymas
            for (int g = 0; g < field.length; g++) {
                for (int h = 0; h < field.length; h++) {
                    //kaimynu skaiciaus kaupimas
                    int count = 0;
                    //kaimynu skaiciavimo lauko nustatymas
                    for (int m = g - 1; m <= g + 1; m++) {
                        for (int n = h - 1; n <= h + 1; n++) {
                            // elementu uz ribos atmetimas
                            if ((m > -1 && m < field.length) && (n > -1 && n < field.length)) {
                                // kaimynu skaiciavimas
                                if (field[m][n] == 'X') {
                                    count++;
                                }
                            }
                        }
                    }
                    // saves ismetimas, jei pirminiam lauke buvo gyvenama
                    if (field[g][h] == 'X') {
                        count--;
                    }
                    // elementu rasymas naujam lauke pagal zaidimo taisykles
                    if (count < 2 || count > 3) {
                        nextField[g][h] = '.';
                    }
                    if (count == 3) {
                        nextField[g][h] = 'X';
                    }
                    if (field[g][h] == 'X' && count == 2) {
                        nextField[g][h] = 'X';
                    }
                    if (count == 2 && field[g][h] == '.') {
                        nextField[g][h] = '.';
                    }
                }
            }
            System.out.println("-------------------");
//             naujo lauko spausdinimas
            for (int i = 0; i < nextField.length; i++) {
                for (int j = 0; j < nextField.length; j++) {
                    System.out.print(nextField[i][j] + " ");
                }
                System.out.println("");
            }
//             nextField prilyginu pirminei iteracijai (tam, kad kartotusi nuo naujo statinio lauko, 
//             o ne nuo random sugeneruojamo)
               field = nextField;
        }

    }

}
