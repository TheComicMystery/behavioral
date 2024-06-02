package patterns;
import java.util.*;
//Паттерн Observer створює механізм підписки для стеження та реагування на події

interface Observer {
    void update(String message);
}

class ClientObserver implements Observer {
    private String name;

    public ClientObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " отримав повідомлення: " + message);
    }
}

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

class ServiceSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}