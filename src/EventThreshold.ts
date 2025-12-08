/**
 * Клас, що представляє порог небезпеки événтю
 */
export class EventThreshold {
  private dangerLevel: number;

  /**
   * Конструктор для класу EventThreshold
   * @param level - рівень небезпеки
   */
  constructor(level: number) {
    this.dangerLevel = level;
  }

  /**
   * Отримати рівень небезпеки
   * @returns рівень небезпеки
   */
  public getLevel(): number {
    return this.dangerLevel;
  }
}
