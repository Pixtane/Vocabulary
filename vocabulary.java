import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.Map.Entry;

public class vocabulary {

    public static HashMap<String, String> slovar = new HashMap<>(); // HashMap
    public static Scanner scanner = new Scanner(System.in); // Scanner

    //Adding translete
    public static void adding(){
        System.out.print("\nEnter word > ");
        String word = scanner.nextLine();

        System.out.print("Enter translete > ");
        String translete = scanner.nextLine();

        slovar.put(word, translete);
        System.out.println("\nAdded!");
    }

    // Deleating translete
    public static void deleating(){
        System.out.print("\nEnter word > ");
        String word = scanner.nextLine();

        slovar.remove(word);
        System.out.println("\nDeleated!");
    }

    // Printing whole map
    public static void printing(){
        System.out.println("\n");

        for (Map.Entry word : slovar.entrySet()) {
            System.out.println(word.getKey() + " - " + word.getValue());
        }
    }

    // Searching translete
    public static void translate(){

        System.out.print("\nSearch translete by word or transleted word? (w, t) > ");
        String versionOfSearching = scanner.nextLine();

        System.out.print("Enter word > ");
        String word = scanner.nextLine();

        // Searching by key
        if (versionOfSearching.toLowerCase().equals("w")){
            String translete = slovar.get(word);
            System.out.println("\n" + word + " - " + translete);
        }

        // Searching by value
        if (versionOfSearching.toLowerCase().equals("t")){

            // iterate each entry of hashmap

            for (Entry<String, String> key : slovar.entrySet()) {
                if (key.getValue().equals(word)) {
                    System.out.println(word + " - " + key.getKey());
                }
            }
        }
    }

    // Divides function of saving/importing
    public static void fileMap() throws Exception{
        System.out.print("Save or import? (s, i) > ");
        String chooseOfSaveOrImport = scanner.nextLine();

        // Save 
        if (chooseOfSaveOrImport.toLowerCase().equals("s")){
            saveInFile();
        }
        // Import 
        else if (chooseOfSaveOrImport.toLowerCase().equals("i")){
            importFromFile();
        }
        // Incorrect entry
        else {
            System.out.println("Error! Incorrect entry");
        }
    }

    // Saves map in file 
    public static void saveInFile() throws Exception{
        System.out.print("Filename > ");
        String filename = scanner.nextLine();
        FileWriter savingFile = new FileWriter(filename);

        for(Entry<String, String> entry : slovar.entrySet()) {
            savingFile.write(entry.getKey() + " - " + entry.getValue() + "\n");
        }

        savingFile.close();
    }

    // Import data from file
    public static void importFromFile() throws Exception{
        System.out.print("Filename > ");
        String filename = scanner.nextLine();
        FileReader importFile = new FileReader(filename);
        Scanner readingFile = new Scanner(importFile);
        String word, translete, line;

        while (readingFile.hasNext()){
            line = readingFile.nextLine();
            String[] wordAndTranslete = line.split(" - ");
            slovar.put(wordAndTranslete[0], wordAndTranslete[1]);
        }

        readingFile.close();
        importFile.close();
    }


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Boolean notExit = true;
        int menu = 0;

        System.out.println("Vocabulary");
        while (notExit){
            System.out.println("\n------------ Menu ------------\n");
            System.out.println("1. Add Translate");
            System.out.println("2. Delete Translate");
            System.out.println("3. Show all map");
            System.out.println("4. Show translate");
            System.out.println("5. Save/Import map in file");
            System.out.println("6. Exit");

            System.out.print("\nEnter > ");
            try{
                menu = scanner.nextInt();
            } 
            catch (Exception e) {
                System.out.println("Enter rightly!");
                System.out.println("Error : " + e);
            }

            if (menu == 1){
                adding();
            } 
            else if (menu == 2){
                deleating();
            }
            else if (menu == 3){
                printing();
            }
            else if (menu == 4){
                translate();
            }
            else if (menu == 5){
                fileMap();
            }
            else{
                notExit = false;
            }

        }

    }
}
