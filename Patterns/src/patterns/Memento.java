package patterns;
import java.util.*;
//Memento дозволяє зберігати та відновлювати минулі стани клієнтов НК.
class ClientMemento {
    private String name;
    private String type;
    private String address;
    private String phone;

    public ClientMemento(String name, String type, String address, String phone) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}

class ClientOriginator {
    private String name;
    private String type;
    private String address;
    private String phone;

    public void setState(String name, String type, String address, String phone) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.phone = phone;
    }

    public ClientMemento saveStateToMemento() {
        return new ClientMemento(name, type, address, phone);
    }

    public void getStateFromMemento(ClientMemento memento) {
        name = memento.getName();
        type = memento.getType();
        address = memento.getAddress();
        phone = memento.getPhone();
    }
}

class Caretaker {
    private List<ClientMemento> mementoList = new ArrayList<>();

    public void add(ClientMemento state) {
        mementoList.add(state);
    }

    public ClientMemento get(int index) {
        return mementoList.get(index);
    }
}