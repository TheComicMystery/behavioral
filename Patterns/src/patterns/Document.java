package patterns;
//Мій інтерфейс Document має реалізації LegalDocument та FinancialDocument.
//Інтерфейс DocumentFactory в свою чергу має реалізації  LegalDocumentFactory та FinancialDocumentFactory.

interface Document {
    void create();
}

class LegalDocument implements Document {
    @Override
    public void create() {
        System.out.println("Створення юридичного документа");
    }
}

class FinancialDocument implements Document {
    @Override
    public void create() {
        System.out.println("Створення фінансового документа");
    }
}

interface DocumentFactory {
    Document createDocument();
}

class LegalDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new LegalDocument();
    }
}

class FinancialDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new FinancialDocument();
    }
}
