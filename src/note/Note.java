package note;

import utils.InputOutput;

public class Note {

    public static void fillNotes() {

        String[] notes = new String[5];

        boolean isNoteArrFull = false;

        while (!isNoteArrFull) {
//            String nullIndex= getNullIndex(notes);

            int index = InputOutput.getUserIntInput("Enter note index (empty indexes: " + getNullIndex(notes) + ") or '-1' to exit: ");

            checkExitCommand(index, notes);

            if (index < 0 || index >= notes.length) {
                InputOutput.printErrorText("Index must be between 0 and : " + (notes.length - 1) + " !");
                continue;
            }
            if (notes[index] != null) {
                InputOutput.printErrorText("Note already exists at index " + index + " !");
                continue;
            }



            String note = InputOutput.getUserTextInput("Enter note text: ");

            InputOutput.printText("Notes: ");


            addNote(notes, note, index);

            printNotes(notes);

            isNoteArrFull = isArrayFull(notes);

        }

    }

    public static void addNote(String[] notes, String note, int index) {
        notes[index] = note;
    }


    public static void printNotes(String ... notes) {
        InputOutput.printText("-------------");
        for (String s : notes) {
            InputOutput.printText(s);
                }
        InputOutput.printText("-------------");

    }




    public static boolean isArrayFull(String[] notes) {

        boolean nullChekingFlag = true;
        for (String s : notes) {
            if (s == null) {
                nullChekingFlag = false;
                break;
            }
        }
        return nullChekingFlag;
    }


    public static void checkExitCommand(int index, String[] notes) {
        if (index == -1) {
            printNotes(notes);
            InputOutput.printText("App is closing ...");
            System.exit(0);
        }
    }

    public static String getNullIndex(String[] notes) {
        String nullIndex="";
        for (int i = 0; i < notes.length; i++) {
            if (notes[i] == null) {
                nullIndex += i + ",";
            }
        }
        return nullIndex;

    }



}
