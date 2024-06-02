//Паттерн Proxy дозволяє підставляти замість реальних об'єктів спеціальні об'єкти-замінники (тут для Document).
package patterns;

class DocumentProxy implements Document {
    private final String documentType;
    private Document realDocument;

    public DocumentProxy(String documentType) {
        this.documentType = documentType;
    }

    private Document getRealDocument() {
        if (realDocument == null) {
            switch (documentType) {
                case "Legal":
                    realDocument = new LegalDocument();
                    break;
                case "Financial":
                    realDocument = new FinancialDocument();
                    break;
                default:
                    throw new IllegalArgumentException("Невідомий тип документа: " + documentType);
            }
        }
        return realDocument;
    }

    @Override
    public void create() {
        getRealDocument().create();
    }
}