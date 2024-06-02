package patterns;
//Паттерн Iterator дозволяє послідовно обходити елементи складових об'єктів. Використовується для обходу списків клиентів.

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Container {
    Iterator getIterator();
}

class ClientCollection implements Container {
    private String[] clients = {"Клієнт 1", "Клієнт 2", "Клієнт 3"};

    @Override
    public Iterator getIterator() {
        return new ClientIterator();
    }

    private class ClientIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < clients.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return clients[index++];
            }
            return null;
        }
    }
}