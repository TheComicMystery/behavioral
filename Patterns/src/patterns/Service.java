package patterns;
//Конкретні реалізації LegalService та FinancialService абстрактного класу Service, та 2 реалізації абстрактного ServiceFactory.

abstract class Service {
    public abstract void serve();
}

class LegalService extends Service {
    @Override
    public void serve() {
        System.out.println("Надання юридичної послуги");
    }
}

class FinancialService extends Service {
    @Override
    public void serve() {
        System.out.println("Надання фінансової послуги");
    }
}

abstract class ServiceFactory {
    public abstract Service createService();
}

class LegalServiceFactory extends ServiceFactory {
    @Override
    public Service createService() {
        return new LegalService();
    }
}

class FinancialServiceFactory extends ServiceFactory {
    @Override
    public Service createService() {
        return new FinancialService();
    }
}