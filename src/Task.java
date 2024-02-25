import java.io.Serializable;

public class Task implements Printable, Serializable {
    private String _content;
    private boolean _done;

    public Task(){
        _content = "";
        _done = false;
    }
    public Task(String str){
        _content = str;
        _done = false;
    }

    public String GetContent(){
        return this._content;
    }
    public void SetContent(String str){
        this._content=str;
    }

    public boolean GetDone(){
        return this._done;
    }
    public void SetDone(boolean bool){
        this._done=bool;
    }

    @Override
    public void PrintOut(){
        System.out.print(_content + " ");
        if(_done){
            System.out.println("Done.");
        }
        else{
            System.out.println("Not done.");
        }
    }
}
