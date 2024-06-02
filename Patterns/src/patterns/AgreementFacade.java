package patterns;
//Facade - паттерн для простого інтерфейса до складної системи класів Agreement.

class AgreementFacade {
    private final Agreement agreement;

    public AgreementFacade(Agreement agreement) {
        this.agreement = agreement;
    }

    public void executeAgreement() {
        System.out.println("Виконання угоди: " + agreement.toString());
    }
}