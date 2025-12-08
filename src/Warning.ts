import { EventThreshold } from './EventThreshold';

/**
 * Клас, що представляє метеорологічне попередження
 */
export class Warning {
  private text: string;
  private time: Date;
  private threshold: EventThreshold;

  /**
   * Конструктор для класу Warning
   * @param text - текст попередження
   * @param time - час видання попередження
   * @param threshold - поріг небезпеки
   */
  constructor(text: string, time: Date, threshold: EventThreshold) {
    this.text = text;
    this.time = time;
    this.threshold = threshold;
  }

  /**
   * Отримати деталі попередження
   * @returns детальна інформація про попередження
   */
  public getDetails(): string {
    return `Попередження: ${this.text}, час: ${this.time.toISOString()}, поріг: ${this.threshold.getLevel()}`;
  }

  /**
   * Отримати час попередження
   * @returns час видання попередження
   */
  public getTime(): Date {
    return this.time;
  }

  /**
   * Отримати поріг небезпеки
   * @returns поріг небезпеки
   */
  public getThreshold(): EventThreshold {
    return this.threshold;
  }
}
