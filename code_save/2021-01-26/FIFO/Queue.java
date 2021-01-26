package FIFO;

import java.util.LinkedList;

public class Queue {
    LinkedList<String> list = new LinkedList<>();

    public void add(String temp){
        list.addFirst(temp);
    }

    public void get(){
        list.removeLast();
    }

    public void show(){
        for (String s : list) {
            System.out.println(s);
        }
    }
}
