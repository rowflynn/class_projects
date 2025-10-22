
//Author: Rowan Flynn

//This program takes in forest sounds and outputs which sounds were made by a fox
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class Fox {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lines = Integer.parseInt(sc.nextLine());
        String line = "";
        LinkedList<String> sounds = new LinkedList<String>();
        ArrayList<String> recSounds = new ArrayList<String>();

        // This for loop takes in the lines of the forest sounds
        for (int i = 0; i < lines; i++) {
            if (i != 0)
                line += (" n " + sc.nextLine());
            else
                line += (sc.nextLine());
        }
        
        // This for loop splits the string of sounds and adds them to a linked list
        String[] split = line.split(" ");
        for (int i = 0; i < split.length; i++) {
            sounds.add(split[i]);
        }
        
        // This while loop records what sounds are not made by a fox
        boolean flag = true;
        while (flag == true) {
            String nextLine = sc.nextLine();
            if (nextLine.equals("what does the fox say?"))
                flag = false;
            else {
                String[] lineList = nextLine.split(" ");
                recSounds.add(lineList[2]);
            }
        }
        
        // This for loop removes the non-fox sounds from the linked list of forest sounds
        for (int i = 0; i < recSounds.size(); i++) {
            for (int j = 0; j < sounds.size(); j++) {
                if (recSounds.get(i).equals(sounds.get(j))) {
                    sounds.remove(j);
                    j--;
                }
            }
        }
        
        // This for loop prints the fox sounds in the correct format with no extra spaces or new lines
        for (int i = 0; i < sounds.size(); i++) {
            if (sounds.get(i).equals("n"))
                continue;
            else if (i+1<sounds.size()){
                if(sounds.get(i+1).equals("n"))
                   System.out.println(sounds.get(i));
                else
                    System.out.print(sounds.get(i) + " ");
            }
            else if(i+1==sounds.size())
                System.out.println(sounds.get(i));
            else
                System.out.print(sounds.get(i) + " ");
        }
        sc.close();
    }
}