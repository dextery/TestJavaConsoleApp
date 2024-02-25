import java.util.Scanner;

public class ProjectMenu extends Menu{ //Menu for interacting with the ProjectList class
    private static ProjectMenu _instance = new ProjectMenu();

    public ProjectMenu(){
    }

    public static ProjectMenu GetInstance(){
        return _instance;
    }

    @Override
    public void ShowMenu(Printable printable) {
        Project project = (Project) printable;
        Scanner sc = new Scanner(System.in);
        int input=-2;

        do {
            System.out.println("Viewing project: "+ project.GetProjectName()+"\n");
            System.out.println("List of project's tasks. What would you like to do?");
            project.PrintOut();
            System.out.println("-1) Exit menu.");
            System.out.println("-2) Add new task.");
            System.out.println("-3) Delete existing task.");
            System.out.println("-4) Change task status.");
            boolean invalid;

            if(sc.hasNextInt()){
                input=sc.nextInt();
            }
            else{
                System.out.println("You have to input an INTEGER NUMBER!");
                input=-10000;
            }
            sc.nextLine();

            switch (input){
                case -1:
                    System.out.println("Goodbye.");
                    break;
                case -2:
                    System.out.println("Type in task content");
                    String taskname = "";
                    taskname=(String)sc.nextLine();
                    sc.nextLine();
                    if (!taskname.equals("")){
                        Task newTask = new Task(taskname);
                        project.AddTask(newTask);
                        System.out.println("Task had been added to task list! \n");
                    }
                    else{
                        System.out.println("Name of task can't be blank! \n");
                    }
                    break;
                case -3:
                    System.out.println("Type in the index of the task you wish to remove.");
                    if(sc.hasNextInt()){
                        input=sc.nextInt();
                        sc.nextLine();
                        invalid = (input-1 >= project.GetTaskList().size() || input-1<0);
                        if(!invalid){
                            project.RemoveTask(input-1);
                            System.out.println("Task deleted. \n");
                        }
                        else{
                            System.out.println("No such task exists! \n");
                        }
                        break;
                    }
                    else{
                        System.out.println("You have to input an INTEGER NUMBER!");
                        break;
                    }


                case -4:
                    System.out.println("Type in the index of the task you wish to alter.");
                    if(sc.hasNextInt()){

                        input=sc.nextInt();
                        sc.nextLine();

                        invalid = (input-1 >= project.GetTaskList().size() || input-1<0);
                        if(!invalid){

                            System.out.println("Type in the status you wish to give to the task:");
                            System.out.println("1 for Done, 0 for Not Done");
                            int index = input-1;
                            Task task = project.GetTaskList().get(index);
                            if(sc.hasNextInt()){
                                input=sc.nextInt();
                            }
                            else{
                                input=-1000;
                            }
                            switch(input){
                                case 1:
                                    task.SetDone(true);
                                    System.out.println("Task status altered.");
                                    break;
                                case 0:
                                    task.SetDone(false);
                                    System.out.println("Task status altered.");
                                    break;
                                default:
                                    System.out.println("Incorrect value inputted!");
                            }

                        }

                        else{
                            System.out.println("No such task exists! \n");
                        }

                    }
                    else{
                        System.out.println("You have to input an INTEGER NUMBER!");
                    }
                    break;
                default:
                    System.out.println("You didnt input a valid instruction!");
                    break;
            }
        }while (input!=-1);
    }
}
