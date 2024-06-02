package patterns;
//Adapter дозволяє об'єктам із несумісними інтерфейсами працювати разом. В мене це Document і Service.

class DocumentServiceAdapter extends Service {
    private final Document document;

    public DocumentServiceAdapter(Document document) {
        this.document = document;
    }

    @Override
    public void serve() {
        document.create();
    }
}