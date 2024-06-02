package patterns;
//Chain of Responsibility дозволяє передавати запити по ланцюжку обробників, кожен з яких вирішує, чи може обробити запит самостійно. Використовується для створення ланцюга послуг у НК.

abstract class ServiceHandler {
    protected ServiceHandler nextHandler;

    public void setNextHandler(ServiceHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String request);
}

class LegalServiceHandler extends ServiceHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("Legal")) {
            System.out.println("Обробка юридичної послуги");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class FinancialServiceHandler extends ServiceHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("Financial")) {
            System.out.println("Обробка фінансової послуги");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
