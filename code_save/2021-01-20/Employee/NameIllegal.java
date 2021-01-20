package Employee;

public class NameIllegal extends Throwable {
    public NameIllegal(){

    }

    public NameIllegal(String msg){
        super(msg);
    }

}