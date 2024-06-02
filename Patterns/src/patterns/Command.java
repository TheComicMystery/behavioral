package patterns;
//Паттерн Command перетворює запити на об'єкти, дозволяючи передавати їх як аргументи методів.

interface Command {
    void execute();
}

class LegalServiceCommand implements Command {
    private Service service;

    public LegalServiceCommand(Service service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.serve();
    }
}

class FinancialServiceCommand implements Command {
    private Service service;

    public FinancialServiceCommand(Service service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.serve();
    }
}

class CommandInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}