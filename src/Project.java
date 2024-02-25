import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Project implements Printable, Serializable { //Stores project name and an ArrayList of Tasks
    private List<Task> _taskList;
    private String _projectName;
    public Project(){
        _taskList=new ArrayList<>();
        _projectName="";
    }

    public Project(String str){
        _taskList=new ArrayList<>();
        _projectName=str;
    }
    public Project(List<Task> tasksList){
        _taskList=tasksList;
    }

    public void AddTask(Task task){
        _taskList.add(task);
    }

    public void RemoveTask(int index){
        _taskList.remove(index);
    }

    public List<Task> GetTaskList(){
        return _taskList;
    }

    //JUST IN CASE
    public void SetTaskList(List<Task> tasksList) {
        _taskList = tasksList;
    }

    public String GetProjectName(){
        return _projectName;
    }
    public void SetProjectName(String str){
        _projectName=str;
    }
    @Override
    public void PrintOut(){
        if(_taskList.isEmpty()){
            System.out.println("There are no tasks in the project!");
        }
        else {
            int k = 1;
            for (Task task : _taskList) {
                System.out.print(k + ") ");
                task.PrintOut();
                k++;
            }
        }
    }
}
