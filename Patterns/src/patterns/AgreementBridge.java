package patterns;
//Паттерн Bridge дозволяє розділити абстракцію та реалізацію, дозволяючи їм змінюватись незалежно

interface AgreementImplementation {
    void implement();
}

class LegalAgreementImplementation implements AgreementImplementation {
    @Override
    public void implement() {
        System.out.println("Реалізація юридичної угоди");
    }
}

class FinancialAgreementImplementation implements AgreementImplementation {
    @Override
    public void implement() {
        System.out.println("Реалізація фінансової угоди");
    }
}

class AgreementBridge {
    private final AgreementImplementation implementation;

    public AgreementBridge(AgreementImplementation implementation) {
        this.implementation = implementation;
    }

    public void implement() {
        implementation.implement();
    }
}