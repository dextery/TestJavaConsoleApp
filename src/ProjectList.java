import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProjectList implements Printable, Serializable { //Class for storing and fetching projects
    private List<Project> _projectList;
    public ProjectList(){
        _projectList = new ArrayList<>();
    }

    public ProjectList(List<Project> projectList){
        _projectList=projectList;
    }

    public List<Project> GetProjectList(){
        return _projectList;
    }
    //JUST IN CASE
    public void SetProjectList(List<Project> projectList){
         _projectList=projectList;
    }

    public void AddToProjectList(Project project){
        _projectList.add(project);
    }
    public void RemoveProject(int index){
        _projectList.remove(index);
    }

    @Override
    public void PrintOut(){
        if(_projectList.isEmpty()){
            System.out.println("There are no projects in list!");
        }
        else {
            int k = 1;
            for (Project project : _projectList) {
                System.out.println(k + ") " + project.GetProjectName());
                k++;
            }
        }
    }
}
