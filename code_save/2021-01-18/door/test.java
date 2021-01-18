package door;

public class test {
    public static void main(String[] args) {
        Door door = new SDoor();
        door.closeDoor();
        door.openDoor();
        SDoor sdoor = (SDoor) door;
        sdoor.photo();
    }
}
