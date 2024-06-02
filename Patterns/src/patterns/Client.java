package patterns;
//Prototype. Тут інтерфейс Cloneable, який дає можливість клонувати об'єкти, наприклад юридичні послуги.

class Client implements Cloneable {
    private String name;
    private String type;
    private String address;
    private String phone;

    public Client(String name, String type, String address, String phone) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.phone = phone;
    }

    @Override
    protected Client clone() throws CloneNotSupportedException {
        return (Client) super.clone();
    }

    @Override
    public String toString() {
        return "Client [name=" + name + ", type=" + type + ", address=" + address + ", phone=" + phone + "]";
    }
}
