package patterns;
import java.util.HashMap;
import java.util.Map;
//Flyweight - патерн розділяє спільний стан об'єктів для Service, щоб забезпечити єдиний екземпляр кожного типу.

class ServiceFlyweightFactory {
    private static final Map<String, Service> services = new HashMap<>();

    public static Service getService(String serviceType) {
        return services.computeIfAbsent(serviceType, type -> {
            switch (type) {
                case "Legal":
                    return new LegalService();
                case "Financial":
                    return new FinancialService();
                default:
                    throw new IllegalArgumentException("Невідомий тип документа: " + type);
            }
        });
    }
}