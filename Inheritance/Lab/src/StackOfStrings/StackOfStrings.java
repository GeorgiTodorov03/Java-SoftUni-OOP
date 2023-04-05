package StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;


    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        data.add(item);
    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        } else {
            return data.remove(data.size() - 1);
        }
    }

    public String peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        } else {
            String element = data.get(data.size() - 1);
            return element;
        }
    }



    public boolean isEmpty() {
        boolean flag = false;

        if (data.isEmpty()) {
            flag = true;
        }
        return flag;
    }
}
