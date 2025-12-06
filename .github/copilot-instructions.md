# Weather Service - Copilot Instructions

## Project Overview
Метеосервіс - це навчальний проект, який демонструє принципи об'єктно-орієнтованого програмування (OOP) в Java. Проект реалізує систему управління метеорологічними даними, розповсюджування попереджень і сповіщень для підписників.

**Ключові технології**: Java 11, Maven, Google Guice (DI), SQLite JDBC

## Architecture & Key Components

### Class Hierarchy
```
WeatherSystemParticipant (abstract)
├── Meteorologist (extends, implements INotificationPlan)
└── Technician (extends)

INotificationPlan (interface)
└── Meteorologist (implements)

Core Services
├── ServiceNotifier (composition: List<Subscriber>)
├── NotificationService 
├── SubscriberService (depends on DB Connection)
└── weatherserviceModule (Guice DI configuration)
```

### OOP Patterns Used
1. **Inheritance**: `Meteorologist` & `Technician` extend `WeatherSystemParticipant`
2. **Interface Implementation**: `Meteorologist` implements `INotificationPlan`
3. **Composition**: `ServiceNotifier` contains `List<Subscriber>` 
4. **Dependency Injection**: Guice injects `SubscriberService` & `Connection` via setter injection

### Four Relationship Types (Method Requirement)
1. **Наслідування** (Inheritance): Classes extend `WeatherSystemParticipant`
2. **Реалізація** (Implementation): `Meteorologist` implements `INotificationPlan`
3. **Залежність** (Dependency): `SubscriberService` depends on DB `Connection`
4. **Агрегація/Композиція** (Composition): `ServiceNotifier` owns `List<Subscriber>`

## Data Flow
1. `Main.java` creates Guice injector with `weatherserviceModule`
2. `weatherserviceModule` provides SQLite `Connection` singleton
3. `Meteorologist` publishes forecast/warnings via `INotificationPlan.formNotification()`
4. `ServiceNotifier` sends notifications to `Subscriber` list via composition
5. `SubscriberService` saves subscriber data to SQLite via `Connection`

## Build & Test

### Build Command
```bash
cd weatherservice
mvn clean install
```

### Important Notes
- **Java Version**: Project requires Java 11+ (configured in `pom.xml`)
- **Dependencies**: 
  - `com.google.inject:guice:5.1.0` (Dependency Injection)
  - `org.xerial:sqlite-jdbc:3.36.0.3` (Database)
  - `junit:junit:4.13.2` (Testing)

### File Naming Convention
- Class names must match file names (e.g., `EventThreshold.java` for class `EventThreshold`)
- Package structure: `com.weatherservice.*`

## Code Conventions

### Class Requirements (from Assignment)
✅ Minimum 3 classes (has 14)  
✅ At least 1 interface & 1 abstract class  
✅ Each class has attributes/methods  
✅ Constructor initialization required  
✅ Final method: `Meteorologist.analyzeAccuracy()` is `final`

### Dependency Injection Pattern
- Use **setter injection** instead of constructor injection
- Annotate with `@Inject` on setter methods
- Example from `ServiceNotifier`:
```java
@Inject
public void setSubscriberService(SubscriberService subscriberService) {
    this.subscriberService = subscriberService;
}
```

### Database
- SQLite automatically creates `subscribers` table on first connection
- File location: `target/weatherservice.db`
- Configured in `weatherserviceModule.java`

## Key Files & Their Roles

| File | Purpose |
|------|---------|
| `Main.java` | Entry point, demonstrates full workflow |
| `WeatherSystemParticipant.java` | Abstract base class (id, name attributes) |
| `Meteorologist.java` | Extends WeatherSystemParticipant, implements INotificationPlan, has `final` method |
| `INotificationPlan.java` | Interface for notification formation |
| `ServiceNotifier.java` | Manages subscribers (composition), uses setter injection |
| `SubscriberService.java` | Saves subscribers to SQLite via injected Connection |
| `weatherserviceModule.java` | Guice module: binds Connection & JDBC URL |
| `Subscriber.java` | Data class representing subscriber |
| `NotificationService.java` | Sends notifications to recipients |

## Common Workflows

### Adding New Subscriber Type
1. Extend `WeatherSystemParticipant`
2. Implement required constructors
3. Optionally implement `INotificationPlan` if notification-capable
4. Add instance creation in `Main.java`

### Extending Notification System
1. Modify `INotificationPlan.formNotification()` return logic
2. Update `ServiceNotifier.send()` if custom behavior needed
3. Ensure `SubscriberService` saves to correct database table

### Running the Application
```bash
cd weatherservice
mvn compile exec:java -Dexec.mainClass="com.weatherservice.Main"
```

## Testing
- Test class: `AppTest.java` in `src/test/java`
- Run tests: `mvn test`
- Current coverage: Basic smoke tests for injection

## Known Patterns to Preserve
- Always use Guice's `@Inject` annotation for dependency injection
- Keep SQLite initialization in `weatherserviceModule`
- Maintain abstract class hierarchy for system participants
- Use composition for subscriber collection (don't use static collections)
