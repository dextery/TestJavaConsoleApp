import java.util.Scanner;

abstract public class Menu { //Abstract class, used as superclass for menu classes.
    private Scanner scanner = new Scanner(System.in);
    abstract public void ShowMenu(Printable printable);
    public Scanner GetScanner(){
        return scanner;
    }
}
