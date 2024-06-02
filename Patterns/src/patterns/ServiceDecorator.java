package patterns;
//Паттерн Decorator надає нові можливості для Service

class ServiceDecorator extends Service {
    protected final Service decoratedService;

    public ServiceDecorator(Service decoratedService) {
        this.decoratedService = decoratedService;
    }

    @Override
    public void serve() {
        decoratedService.serve();
    }
}

class AdditionalServiceDecorator extends ServiceDecorator {
    public AdditionalServiceDecorator(Service decoratedService) {
        super(decoratedService);
    }

    @Override
    public void serve() {
        super.serve();
        additionalServe();
    }

    private void additionalServe() {
        System.out.println("Додаткова функціональність");
    }
}
