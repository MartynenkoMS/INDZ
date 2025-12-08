import { Meteorologist } from './Meteorologist';
import { Technician } from './Technician';
import { NotificationService } from './NotificationService';
import { Subscriber } from './Subscriber';
import { Warning } from './Warning';
import { Region } from './Region';
import { EventThreshold } from './EventThreshold';

/**
 * Головний клас для демонстрації роботи системи метеорологічного сервісу
 */
class Main {
  public static main(): void {
    console.log('=== Демонстрація роботи метеорологічного сервісу ===\n');

    // Створення об'єктів системи
    const meteorologist = new Meteorologist(1, 'Петро Іванов', 'Синоптик');
    const technician = new Technician(2, 'Іван Петренко', 'Старший технік');
    const notificationService = new NotificationService();

    // Додавання підписників та адресатів
    notificationService.addSubscriber(new Subscriber('Іван Смит'));
    notificationService.addSubscriber(new Subscriber('Марія Коваленко'));
    notificationService.addRecipient('weather@example.com');

    // Демонстрація роботи
    console.log('--- Опублікування прогнозу ---');
    meteorologist.publishForecast();

    console.log('\n--- Опублікування попередження ---');
    meteorologist.publishWarning();

    console.log('\n--- Аналіз точності ---');
    meteorologist.analyzeAccuracy();

    console.log('\n--- Обслуговування обладнання ---');
    technician.maintainSensors();
    technician.maintainRadar();

    console.log('\n--- Формування сповіщень ---');
    const meteorologistNotification = meteorologist.formNotification();
    const technicianNotification = technician.formNotification();
    console.log('1. ' + meteorologistNotification);
    console.log('2. ' + technicianNotification);

    console.log('\n--- Надсилання сповіщень ---');
    notificationService.send(meteorologistNotification);

    console.log('\n--- Робота з регіонами та попередженнями ---');
    const region = new Region('Київ');
    const threshold = new EventThreshold(5);
    const warning = new Warning('Сильна гроза', new Date(), threshold);
    
    region.addWarning(warning);
    console.log('Деталі попередження: ' + warning.getDetails());

    console.log('\n=== Демонстрація завершена ===');
  }
}

// Запуск головної програми
Main.main();
