import java.util.ArrayList;
import java.util.List;

public class MenuList { //Class, used for storing and fetching appropriate menus from it.
    private static MenuList _instance = new MenuList();
    private static MainMenu _mainMenu;
    private static ProjectMenu _projectMenu;

    public MenuList(MainMenu mainMenu, ProjectMenu projectMenu) {
        _mainMenu = mainMenu;
        _projectMenu = projectMenu;
    }

    public MenuList() {
        _mainMenu = new MainMenu();
        _projectMenu = new ProjectMenu();
    }

    public static MenuList GetInstance(){
        return _instance;
    }

    public void SetMainMenu(MainMenu mainMenu){
        _mainMenu=mainMenu;
    }
    public void SetProjectMenu(ProjectMenu projectMenu){
        _projectMenu=projectMenu;
    }

    public MainMenu GetMainMenu(){
        return _mainMenu;
    }
    public ProjectMenu GetProjectMenu(){
        return _projectMenu;
    }
}
