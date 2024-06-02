package patterns;
//Паттерн Mediator зменшує зв'язаність класів, переміщуючи їх зв'язки до одного посередника, в мене з послугами.

interface Mediator {
    void notify(Component sender, String event);
}

class ConcreteMediator implements Mediator {
    private LegalServiceComponent legalService;
    private FinancialServiceComponent financialService;

    public void setLegalService(LegalServiceComponent legalService) {
        this.legalService = legalService;
    }

    public void setFinancialService(FinancialServiceComponent financialService) {
        this.financialService = financialService;
    }

    @Override
    public void notify(Component sender, String event) {
        if (event.equals("LegalRequest")) {
            legalService.serve();
        } else if (event.equals("FinancialRequest")) {
            financialService.serve();
        }
    }
}

abstract class Component {
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }
}

class LegalServiceComponent extends Component {
    public LegalServiceComponent(Mediator mediator) {
        super(mediator);
    }

    public void request() {
        System.out.println("Юридична послуга запитана");
        mediator.notify(this, "LegalRequest");
    }

    public void serve() {
        System.out.println("Надання юридичної послуги через посередника");
    }
}

class FinancialServiceComponent extends Component {
    public FinancialServiceComponent(Mediator mediator) {
        super(mediator);
    }

    public void request() {
        System.out.println("Фінансова послуга запитана");
        mediator.notify(this, "FinancialRequest");
    }

    public void serve() {
        System.out.println("Надання фінансової послуги через посередника");
    }
}