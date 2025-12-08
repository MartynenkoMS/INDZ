/**
 * Абстрактний клас, що представляє учасника метеорологічної системи
 */
export abstract class WeatherSystemParticipant {
  private id: number;
  private name: string;

  /**
   * Конструктор для WeatherSystemParticipant
   * @param id - ідентифікатор учасника
   * @param name - ім'я учасника
   */
  constructor(id: number, name: string) {
    this.id = id;
    this.name = name;
  }

  /**
   * Отримати ім'я учасника
   * @returns ім'я учасника
   */
  public getName(): string {
    return this.name;
  }

  /**
   * Отримати ідентифікатор учасника
   * @returns ідентифікатор
   */
  public getId(): number {
    return this.id;
  }
}
