package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class Main /*extends Application*/ {

    //public static Scene mainStage;

    //public static Controller mainController = new Controller();
    //jfeonix for later things
    /*@Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader mainLoader = new FXMLLoader(getClass().getClassLoader().getResource("sample/HackGUI2.fxml"));
        Parent mainScreen = mainLoader.load();
        mainController = mainLoader.getController();
        mainController.setMainController(this);
        mainStage = new Scene(mainScreen);

        primaryStage.setTitle("Music Generator");
        primaryStage.setIconified(true);
        primaryStage.setResizable(true);
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setScene(mainStage);

    }*/

//all major and minor keys allowed
    public static void main(String[] args) {

        Random generator = new Random(System.currentTimeMillis());
        //launch(args);
        String chordA[] = {"G", "C", "em", "am"};
        String chordB[] = {"em", "C", "G", "em", "D", "C", "G"};

        ArrayList<Integer> Apart = new ArrayList<Integer>();
        ArrayList<Integer> Bpart = new ArrayList<Integer>();
        //may want to create weighted heuristic

        System.out.println("A PART");

        for(int aMelody = 0; aMelody < chordA.length; aMelody++) {
            int noteNum = getBaseNote(chordA[aMelody].toLowerCase());
            int noteType = chordA[aMelody].length()-1;

            for(int create8 = 0; create8<8; create8++) {
                int note = (int) Math.floor(generator.nextDouble() * 4);
                int rest = (int) Math.floor(generator.nextDouble() * 10);
                int noteMult = (int) Math.floor(generator.nextDouble() * 3);

               // System.out.print("NOTE" + note);
                if(rest == 0){
                    System.out.print(-1);
                    Apart.add(-1);
                }
                else if (note == 1) {
                    if (noteType == 0) {
                        System.out.print(noteNum + 4 + 12*noteMult);
                        Apart.add(noteNum + 4 + 12*noteMult);
                    }
                    if (noteType == 1) {
                        System.out.print(noteNum + 3 + 12*noteMult);
                        Apart.add(noteNum + 3 + 12*noteMult);
                    }
                } else if (note == 2) {
                    System.out.print(noteNum + 7 + 12*noteMult);
                    Apart.add(noteNum + 7 + 12*noteMult);
                } else if (note == 3) {
                    if (noteType == 0) {
                        System.out.print(noteNum + 7+4 + 12*noteMult);
                        Apart.add(noteNum + 7+4 + 12*noteMult);
                    }
                    if (noteType == 1) {
                        System.out.print(noteNum + 7 + 3 + 12*noteMult);
                        Apart.add(noteNum + 7 + 3 + 12*noteMult);
                    }
                } else if(note == 0){
                    System.out.print(noteNum + 12*noteMult);
                    Apart.add(noteNum + 12*noteMult);
                }

                System.out.print(" ");
            }
        }
        System.out.println("");
        System.out.println("B PART");
        for(int bMelody = 0; bMelody < chordB.length; bMelody++) {
            int noteNum = getBaseNote(chordB[bMelody].toLowerCase());
            int noteType = chordB[bMelody].length()-1;

            for(int create8 = 0; create8<8; create8++) {
                int note = (int) Math.floor(generator.nextDouble() * 4);
                int rest = (int) Math.floor(generator.nextDouble() * 10);
                int noteMult = (int) Math.floor(generator.nextDouble() * 3);

                // System.out.print("NOTE" + note);
                if(rest == 0){
                    System.out.print(-1);
                    Bpart.add(-1);
                }
                else if (note == 1) {
                    if (noteType == 0) {
                        System.out.print(noteNum + 4 + 12*noteMult);
                        Bpart.add(noteNum + 4 + 12*noteMult);
                    }
                    if (noteType == 1) {
                        System.out.print(noteNum + 3 + 12*noteMult);
                        Bpart.add(noteNum + 3 + 12*noteMult);
                    }
                } else if (note == 2) {
                    System.out.print(noteNum + 7 + 12*noteMult);
                    Bpart.add(noteNum + 7 + 12*noteMult);
                } else if (note == 3) {
                    if (noteType == 0) {
                        System.out.print(noteNum + 7+4 + 12*noteMult);
                        Bpart.add(noteNum + 7+4 + 12*noteMult);
                    }
                    if (noteType == 1) {
                        System.out.print(noteNum + 7 + 3 + 12*noteMult);
                        Bpart.add(noteNum + 7 + 3 + 12*noteMult);
                    }
                } else if(note == 0){
                    System.out.print(noteNum + 12*noteMult);
                    Bpart.add(noteNum + 12*noteMult);
                }

                System.out.print(" ");
            }
        }
        try {
            FileWriter writer = new FileWriter("PlayNotes.csv");
            writer.write("");
            for (int note : Apart) {
                writer.append("" + note);
                writer.append(",");
            }
            writer.append("\n");
            for (int note : Bpart) {
                writer.append("" + note);
                writer.append(",");
            }
            writer.flush();
            writer.close();
        }catch(Exception e){
            System.out.println("ERR");
        }


    }

    public static int getBaseNote(String chord){

        int baseNote = -1;
        switch (""+ chord.charAt(0)) {
            case "c":
                baseNote = 7;
                break;
            case "d":
                baseNote = 9;
                break;
            case "e":
                baseNote = 11;
                break;
            case "f":
                baseNote = 0;
                break;
            case "g":
                baseNote = 2;
                break;
            case "a":
                baseNote = 4;
                break;
            case "b":
                baseNote = 6;
                break;
        }
        return baseNote;

//        sequencer.getSequence().createTrack();
    }

    /*@Override
    public void stop(){
        System.exit(0);
    }*/


}
