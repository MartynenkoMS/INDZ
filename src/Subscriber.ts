/**
 * Клас, що представляє підписника на сповіщення
 */
export class Subscriber {
  private name: string;

  /**
   * Конструктор для класу Subscriber
   * @param name - ім'я підписника
   */
  constructor(name: string) {
    this.name = name;
  }

  /**
   * Доставити повідомлення підписнику
   * @param text - текст повідомлення
   */
  public deliverMessage(text: string): void {
    console.log(`Підписник ${this.name} отримав повідомлення: ${text}`);
  }

  /**
   * Отримати ім'я підписника
   * @returns ім'я підписника
   */
  public getName(): string {
    return this.name;
  }
}
