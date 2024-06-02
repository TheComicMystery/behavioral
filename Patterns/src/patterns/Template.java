package patterns;
//Паттерн Template Method реалізує підкласи для їх використання з метою оптимізації.

abstract class ServiceTemplate {
    public final void serve() {
        prepare();
        execute();
        finish();
    }

    protected abstract void prepare();
    protected abstract void execute();
    protected abstract void finish();
}

class LegalServiceTemplate extends ServiceTemplate {
    @Override
    protected void prepare() {
        System.out.println("Підготовка до надання юридичної послуги");
    }

    @Override
    protected void execute() {
        System.out.println("Виконання юридичної послуги");
    }

    @Override
    protected void finish() {
        System.out.println("Завершення юридичної послуги");
    }
}

class FinancialServiceTemplate extends ServiceTemplate {
    @Override
    protected void prepare() {
        System.out.println("Підготовка до надання фінансової послуги");
    }

    @Override
    protected void execute() {
        System.out.println("Виконання фінансової послуги");
    }

    @Override
    protected void finish() {
        System.out.println("Завершення фінансової послуги");
    }
}