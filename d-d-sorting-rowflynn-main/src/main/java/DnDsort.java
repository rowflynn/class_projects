import java.util.*;
import java.io.*;

//Author: Rowan Flynn
//Date: 2021-09-30
//This program reads a file of DnD characters and sorts them by a stat

class Character {
    String nameAndClass;
    HashMap<String, Integer> stats;

    public Character(String name, HashMap<String, Integer> stats) {
        this.nameAndClass = name;
        this.stats = stats;
    }
}

public class DnDsort {

    // This method reads the file and creates a list of characters
    public static ArrayList<Character> readFile() throws FileNotFoundException {
        File file = new File("characters.txt");
        Scanner sc = new Scanner(file);
        int cnt = 0;
        String nameAndClass = "";
        List<HashMap<String, Integer>> hashMapsList = new ArrayList<>();
        ArrayList<Character> chars = new ArrayList<Character>();
        // This while loop reads the file and creates a list of characters
        while (sc.hasNextLine()) {
            String line;
            String[] split;
            nameAndClass = sc.nextLine();
            line = sc.nextLine();
            hashMapsList.add(createNewHashMap(cnt));
            HashMap<String, Integer> currentMap = hashMapsList.get(cnt);

            // This while loop reads the stats and adds them to the current HashMap
            do {
                split = line.split(":");
                currentMap.put(split[0].toLowerCase(), Integer.parseInt(split[1]));
                line = sc.nextLine();
            } while (line.length() > 0 && sc.hasNextLine());
            chars.add(new Character(nameAndClass, currentMap));
            cnt++;
        }
        sc.close();
        return chars;
    }

    // This method creates a new HashMap
    public static HashMap<String, Integer> createNewHashMap(int cnt) {
        return new HashMap<>();
    }

    // This method gets the stat to sort by
    public static String getStat() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String stat;
        System.out.println("What stat would you like to sort by?");
        do{
            flag = true;
            stat = sc.nextLine().toLowerCase();
            // This switch statement checks if the stat is valid
            switch (stat) {
                case "strength":
                case "dexterity":
                case "constitution":
                case "intelligence":
                case "wisdom":
                case "charisma":
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter a valid stat");
                    break;
            }

        }while(flag);
        sc.close();
        return stat;
    }

    // This method sorts the characters by the stat
    public static List<Map.Entry<String, Integer>> sortByStat(ArrayList<Character> chars, String stat) {
        HashMap<String, Integer> stats = new HashMap<String, Integer>();
        for (Character c : chars) {
            stats.put(c.nameAndClass, c.stats.get(stat));
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(stats.entrySet());
        
        // Sorting code from
        // 'https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/'
        // modified by chatGPT for legibility
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return list;
    }

    // This method prints the sorted characters
    public static void printStats(List<Map.Entry<String, Integer>> sorted, String stat) {
        System.out.println("The characters are in ascending order of their " + stat + ":");
        for (Map.Entry<String, Integer> entry : sorted) {
            System.out.println(entry.getKey() + " (" + entry.getValue() + ")");
        }
    }

    public static void main(String[] args) {
        try {
            ArrayList<Character> chars = readFile();
            String stat = getStat();
            List<Map.Entry<String, Integer>> sorted = sortByStat(chars, stat);
            printStats(sorted, stat);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
