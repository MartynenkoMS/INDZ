import { WeatherSystemParticipant } from './WeatherSystemParticipant';
import { INotificationPlan } from './INotificationPlan';

/**
 * Клас, що представляє техніка
 */
export class Technician extends WeatherSystemParticipant implements INotificationPlan {
  private level: string;

  /**
   * Конструктор для класу Technician
   * @param id - ідентифікатор техніка
   * @param name - ім'я техніка
   * @param level - рівень кваліфікації
   */
  constructor(id: number, name: string, level: string) {
    super(id, name);
    this.level = level;
  }

  /**
   * Обслуговувати датчики
   */
  public maintainSensors(): void {
    console.log(`Технік ${this.getName()} обслуговує датчики`);
  }

  /**
   * Обслуговувати радар
   */
  public maintainRadar(): void {
    console.log(`Технік ${this.getName()} обслуговує радар`);
  }

  /**
   * Реалізація методу інтерфейсу INotificationPlan
   */
  public formNotification(): string {
    return `Сповіщення від техніка ${this.getName()} (${this.level})`;
  }
}
