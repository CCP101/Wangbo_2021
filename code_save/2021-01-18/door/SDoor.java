package door;

public class SDoor extends Door{

    @Override
    public void openDoor() {
        System.out.println("转三，开门");
    }

    @Override
    public void closeDoor() {
        System.out.println("转三圈，关门");
    }

    public void photo(){
        System.out.println("照片存储");
    }

}
