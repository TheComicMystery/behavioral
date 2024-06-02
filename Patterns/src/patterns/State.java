package patterns;
//Паттерн State дозволяє об'єктам (послуги) змінювати поведінку в залежності від стану.

interface ServiceState {
    void serve(ServiceContext context);
}

class NewState implements ServiceState {
    @Override
    public void serve(ServiceContext context) {
        System.out.println("Послуга нова");
        context.setState(new InProgressState());
    }
}

class InProgressState implements ServiceState {
    @Override
    public void serve(ServiceContext context) {
        System.out.println("Послуга в процесі");
        context.setState(new CompletedState());
    }
}

class CompletedState implements ServiceState {
    @Override
    public void serve(ServiceContext context) {
        System.out.println("Послуга завершена");
    }
}

class ServiceContext {
    private ServiceState state;

    public ServiceContext() {
        state = new NewState();
    }

    public void setState(ServiceState state) {
        this.state = state;
    }

    public void serve() {
        state.serve(this);
    }
}
