package patterns;
//Builder. Клас Agreement представляє складний об'єкт, а AgreementBuilder допомагає створювати об'єкти Agreement покроково.
class Agreement {
    private String clientName;
    private String serviceType;
    private double amount;
    private double commission;
    private String description;

    public Agreement(String clientName, String serviceType, double amount, double commission, String description) {
        this.clientName = clientName;
        this.serviceType = serviceType;
        this.amount = amount;
        this.commission = commission;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Agreement [clientName=" + clientName + ", serviceType=" + serviceType + ", amount=" + amount +
                ", commission=" + commission + ", description=" + description + "]";
    }
}

class AgreementBuilder {
    private String clientName;
    private String serviceType;
    private double amount;
    private double commission;
    private String description;

    public AgreementBuilder setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    public AgreementBuilder setServiceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public AgreementBuilder setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public AgreementBuilder setCommission(double commission) {
        this.commission = commission;
        return this;
    }

    public AgreementBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Agreement build() {
        return new Agreement(clientName, serviceType, amount, commission, description);
    }
}
