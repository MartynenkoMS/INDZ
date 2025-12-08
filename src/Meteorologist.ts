import { WeatherSystemParticipant } from './WeatherSystemParticipant';
import { INotificationPlan } from './INotificationPlan';

/**
 * Клас, що представляє метеоролога
 */
export class Meteorologist extends WeatherSystemParticipant implements INotificationPlan {
  private specialization: string;

  /**
   * Конструктор для класу Meteorologist
   * @param id - ідентифікатор метеоролога
   * @param name - ім'я метеоролога
   * @param specialization - спеціалізація метеоролога
   */
  constructor(id: number, name: string, specialization: string) {
    super(id, name);
    this.specialization = specialization;
  }

  /**
   * Опублікувати прогноз погоди
   */
  public publishForecast(): void {
    console.log(`Метеоролог ${this.getName()} публікує прогноз погоди`);
  }

  /**
   * Опублікувати попередження про небезпечні явища
   */
  public publishWarning(): void {
    console.log(`Метеоролог ${this.getName()} публікує попередження про небезпечні явища`);
  }

  /**
   * Фінальний метод для аналізу точності прогнозів
   */
  public analyzeAccuracy(): void {
    console.log(`Метеоролог ${this.getName()} аналізує точність прогнозів`);
  }

  /**
   * Реалізація методу інтерфейсу INotificationPlan
   */
  public formNotification(): string {
    return `Сповіщення від метеоролога ${this.getName()} (${this.specialization})`;
  }
}
