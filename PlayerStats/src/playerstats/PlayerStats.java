/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playerstats;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author slwells
 */
public class PlayerStats {

    public static void main(String[] args) {
        String[] names = new String[80]; //Array for the names read from the file
        int[] scores = new int[80]; //Array of the scores from the text file.

        readData(names, scores, args[0]);
        
    }

    public static void displayPlayerStats(String[] names, int[] scores) {
        for (int i = 0; i < names.length; i++) {
            System.out.println(String.format("%s %d", names[i], scores[i]));
        }
                System.out.println(calculateAverage(scores));

    }

    public static double calculateAverage(int[] scores) {
        double sum = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        return sum / scores.length;
    }

    public static void readData(String[] names, int[] scores, String filename) {
        try {
            Scanner reader = new Scanner(new File(filename)); //Creates a scanner object

            int currentIndex = 0; //Varaible for the index
            while (reader.hasNext()) {
                String[] line = reader.nextLine().split(" ");

                names[currentIndex] = line[0];
                scores[currentIndex] = Integer.parseInt(line[1]); //Used to parse an integer

                currentIndex++; //Adds 1 everytime it loop
            }
        } catch (FileNotFoundException ex) { //Catch used to catch mistakes made
            System.err.println("Unable to read file in readData"); //The error message when the catch is used
        }

        /**
         * @param args the command line arguments
         */
    }
} //End of the program
