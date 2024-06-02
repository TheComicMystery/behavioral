package patterns;
//Strategy визначає сімейство алгоритмів та дозволяє замінювати їх під час виконання програми. Використовується для механіки оплати послуг.

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата кредитною карткою: " + amount);
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата через PayPal: " + amount);
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        strategy.pay(amount);
    }
}