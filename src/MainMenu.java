import java.util.Scanner;
public class MainMenu extends Menu{
    private static MainMenu _instance = new MainMenu();
    public static MainMenu GetInstance(){
        return _instance;
    }

    @Override
    public void ShowMenu(Printable projectPrint) {
        Scanner sc = new Scanner(System.in);
        int input = -2;
        do {
            System.out.println("Project list:");
            ProjectList projectList = (ProjectList) projectPrint;
            projectList.PrintOut();
            System.out.println("Press the number of the project to select it.");
            System.out.println("-1) Exit menu.");
            System.out.println("-2) Add new project.");
            System.out.println("-3) Delete an existing project.");
            if (sc.hasNextInt()){
                input = sc.nextInt();
            }
            else{
                System.out.println("You have to input an INTEGER NUMBER!");
                input=-10000;
            }
            input = sc.nextInt();
            sc.nextLine();
            //boolean invalid = (input-1 >= projectList.GetProjectList().size() || input-1<0);
            boolean invalid;
            switch(input){
                case -1:
                    System.out.println("Goodbye.");
                    break;
                case -2:
                    System.out.println("Type in a name for your new project");
                    String projname = "";
                    projname=(String)sc.nextLine();
                    sc.nextLine();
                    if (!projname.equals("")){
                        Project newProject = new Project(projname);
                        projectList.AddToProjectList(newProject);
                        System.out.println("Project has been added to list! \n");
                    }
                    else{
                        System.out.println("Project name can't be blank! \n");
                    }
                    break;
                case -3:
                    System.out.println("Input the index of the project you wish to delete.");
                    System.out.println("0) Cancel.");
                    if (sc.hasNextInt()){
                        input = sc.nextInt();
                    }
                    else{
                        System.out.println("You have to input an INTEGER NUMBER!");
                        input=-10000;
                    }
                    sc.nextLine();
                    invalid = (input-1 >= projectList.GetProjectList().size() || input-1<0);
                    if(!invalid){
                        projectList.RemoveProject(input-1);
                        System.out.println("Project deleted! \n");
                    }
                    else{
                        System.out.println("There is no such project!");
                    }
                    break;

                default:
                    invalid = (input-1 >= projectList.GetProjectList().size() || input-1<0);
                    if (!invalid){
                        System.out.println("Opening project menu...");
                        MenuList.GetInstance().GetProjectMenu().
                                ShowMenu(projectList.GetProjectList().get(input-1));
                    }
                    break;
            }
        } while (input!=-1);
        System.out.println("Going back...");
    }
}
