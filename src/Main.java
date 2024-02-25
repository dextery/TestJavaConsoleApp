import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Initialization
        Scanner sc = new Scanner(System.in);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ProjectList projectList = new ProjectList();
        MenuList menuList = new MenuList(); //Class used to store and call singleton pattern menus.
        Path currentRelativePath = Paths.get("output"); //Getting directory path for output of the file
        try {
            Files.createDirectories(currentRelativePath); //Check if directory exists, create if it doesn't
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //File f = new File(currentRelativePath.toAbsolutePath().toString());
        try {//Try to load contents of the file if it exists...
            Reader reader = Files.newBufferedReader(Paths.get("output/SavedProjects.json"));
            projectList = gson.fromJson(reader, ProjectList.class);
        } catch (IOException e) {//Create a new save file if it doesn't exist
            try {
                Writer writer = new FileWriter("output/SavedProjects.json");
                gson.toJson(projectList, writer);
                writer.flush();
                writer.close();
            } catch (IOException f) {
                //throw new RuntimeException(e);
            }
        }

//        String s = currentRelativePath.toAbsolutePath().toString();
//        System.out.println("Current absolute path is: " + s);

        //Interaction starts
        System.out.println("Welcome to Project Management!");
        int input = -1;
        do {
            System.out.println("Main menu:");
            System.out.println("1) Open list of projects");
            System.out.println("0) Exit.");

            if(sc.hasNextInt()){ //Safety check to make sure that user inputs an actual int number
                input=sc.nextInt();
            }
            else{
                System.out.println("You have to input an INTEGER NUMBER!");
                input=-10000; //Arbitrary small number that triggers default switch case
            }
            sc.nextLine();
            switch(input){
                case 1:
                    menuList.GetInstance().
                            GetMainMenu().
                            GetInstance().ShowMenu(projectList); //Fetching appropriate menu from menu list
                    break;
                case 0: //End of interaction.
                    //input=0;
                    System.out.println("Goodbye.");
                    break;
                default: //Case for wrongful input
                    System.out.println("You did not input valid instruction!");
                    break;
            }
        } while (input!=0); //Interaction ends

        String myJson = gson.toJson(projectList); //Creating/Overwriting save file with new/updated data.
        try {
            Writer writer = new FileWriter("output/SavedProjects.json");
            gson.toJson(projectList, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(myJson);

    }
}