package patterns;
//Singleton. Клас Database гарантує, що він має лише 1 екземпляр і надає глобальну точку доступу до нього через метод getInstance.

class Database {
    private static Database instance;

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Підключення до бази даних");
    }
}

