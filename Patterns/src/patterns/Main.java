//Я придумав таку предметну область - сервіс нотаріальної контори. Коротко про НК:
//Додаються дані про клієнтів (ПІБ, необхідна послуга, адреса і телефон), і на підставі цього їм надаються обрані послуги.

package patterns;

public class Main {
    public static void main(String[] args) {
        //Factory Method
        ServiceFactory legalServiceFactory = new LegalServiceFactory();
        Service legalService = legalServiceFactory.createService();
        legalService.serve();

        ServiceFactory financialServiceFactory = new FinancialServiceFactory();
        Service financialService = financialServiceFactory.createService();
        financialService.serve();

        //Abstract Factory
        DocumentFactory legalDocumentFactory = new LegalDocumentFactory();
        Document legalDocument = legalDocumentFactory.createDocument();
        legalDocument.create();

        DocumentFactory financialDocumentFactory = new FinancialDocumentFactory();
        Document financialDocument = financialDocumentFactory.createDocument();
        financialDocument.create();

        //Builder
        Agreement agreement = new AgreementBuilder()
                .setClientName("Клієнт 1")
                .setServiceType("Юридична")
                .setAmount(1000.0)
                .setCommission(100.0)
                .setDescription("Опис угоди")
                .build();
        System.out.println(agreement);

        //Prototype
        try {
            Client originalClient = new Client("Пономарчук Василь Романович", "Юридичні послуги", "вул. Лесі Українки, 42", "123456789");
            Client clonedClient = originalClient.clone();
            System.out.println("Оригінальний клієнт: " + originalClient);
            System.out.println("Клонований клієнт: " + clonedClient);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //Singleton
        Database database = Database.getInstance();
        database.connect();

        //Adapter
        DocumentServiceAdapter adapter = new DocumentServiceAdapter(legalDocument);
        adapter.serve();

        //Bridge
        AgreementImplementation legalImpl = new LegalAgreementImplementation();
        AgreementBridge legalAgreementBridge = new AgreementBridge(legalImpl);
        legalAgreementBridge.implement();

        AgreementImplementation financialImpl = new FinancialAgreementImplementation();
        AgreementBridge financialAgreementBridge = new AgreementBridge(financialImpl);
        financialAgreementBridge.implement();

        //Composite
        ComplexDocument complexDocument = new ComplexDocument();
        complexDocument.addDocument(new LegalDocument());
        complexDocument.addDocument(new FinancialDocument());
        complexDocument.create();

        //Decorator
        ServiceDecorator decoratedService = new AdditionalServiceDecorator(legalService);
        decoratedService.serve();

        //Facade
        AgreementFacade agreementFacade = new AgreementFacade(agreement);
        agreementFacade.executeAgreement();

        //Flyweight
        Service legalServiceFlyweight = ServiceFlyweightFactory.getService("Legal");
        Service financialServiceFlyweight = ServiceFlyweightFactory.getService("Financial");
        legalServiceFlyweight.serve();
        financialServiceFlyweight.serve();

        //Proxy
        DocumentProxy legalDocumentProxy = new DocumentProxy("Legal");
        legalDocumentProxy.create();

        DocumentProxy financialDocumentProxy = new DocumentProxy("Financial");
        financialDocumentProxy.create();

        //Chain of Responsibility
        ServiceHandler legalHandler = new LegalServiceHandler();
        ServiceHandler financialHandler = new FinancialServiceHandler();
        legalHandler.setNextHandler(financialHandler);
        legalHandler.handleRequest("Legal");
        legalHandler.handleRequest("Financial");

        //Command
        CommandInvoker invoker = new CommandInvoker();
        invoker.setCommand(new LegalServiceCommand(legalService));
        invoker.executeCommand();
        invoker.setCommand(new FinancialServiceCommand(financialService));
        invoker.executeCommand();

        //Iterator
        ClientCollection clients = new ClientCollection();
        Iterator iterator = clients.getIterator();
        while (iterator.hasNext()) {
            System.out.println("Клієнт: " + iterator.next());
        }

        //Mediator
        ConcreteMediator mediator = new ConcreteMediator();
        LegalServiceComponent legalComponent = new LegalServiceComponent(mediator);
        FinancialServiceComponent financialComponent = new FinancialServiceComponent(mediator);
        mediator.setLegalService(legalComponent);
        mediator.setFinancialService(financialComponent);
        legalComponent.request();
        financialComponent.request();

        //Memento
        Caretaker caretaker = new Caretaker();
        ClientOriginator client = new ClientOriginator();
        client.setState("Клієнт 1", "Юридичні послуги", "вул. Лесі Українки, 42", "123456789");
        caretaker.add(client.saveStateToMemento());
        client.setState("Клієнт 2", "Фінансові послуги", "вул. Шевченка, 21", "987654321");
        caretaker.add(client.saveStateToMemento());
        client.getStateFromMemento(caretaker.get(0));
        System.out.println("Перший стан клієнта: " + client.saveStateToMemento().getName());

        //Observer
        ServiceSubject serviceSubject = new ServiceSubject();
        ClientObserver observer1 = new ClientObserver("Клієнт 1");
        ClientObserver observer2 = new ClientObserver("Клієнт 2");
        serviceSubject.attach(observer1);
        serviceSubject.attach(observer2);
        serviceSubject.setMessage("Оновлення послуг");

        //State
        ServiceContext context = new ServiceContext();
        context.serve();
        context.serve();
        context.serve();

        //Strategy
        PaymentContext paymentContext = new PaymentContext();
        paymentContext.setPaymentStrategy(new CreditCardPayment());
        paymentContext.pay(200.0);
        paymentContext.setPaymentStrategy(new PayPalPayment());
        paymentContext.pay(300.0);

        //Template Method
        ServiceTemplate legalTemplate = new LegalServiceTemplate();
        legalTemplate.serve();
        ServiceTemplate financialTemplate = new FinancialServiceTemplate();
        financialTemplate.serve();
    }
}