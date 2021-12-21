package behavior.observe;

import java.util.ArrayList;
import java.util.List;

public class ObserveTest {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Task1 task1 = new Task1();
        subject.addObserve(task1);
        Task2 task2 = new Task2();
        subject.addObserve(task2);

        subject.notifyObserver("1");
        subject.notifyObserver("2");

        subject.remove(task1);

        subject.notifyObserver("3");


    }
}

class Subject {
    List<Observer> observers = new ArrayList<>();

    public void addObserve(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver(Object object) {
        for (Observer observer : observers) {
            observer.update(object);
        }
    }
}

interface Observer {
    void update(Object subject);
}


class Task1 implements Observer {

    @Override
    public void update(Object subject) {
        System.out.println("Task1 receive " + subject);
    }
}

class Task2 implements Observer {

    @Override
    public void update(Object subject) {
        System.out.println("Task2 receive " + subject);
    }
}
