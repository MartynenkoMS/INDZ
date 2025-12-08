import { Warning } from './Warning';

/**
 * Клас, що представляє регіон для відправлення попереджень
 */
export class Region {
  private name: string;
  private warnings: Warning[] = [];

  /**
   * Конструктор для класу Region
   * @param name - назва регіону
   */
  constructor(name: string) {
    this.name = name;
  }

  /**
   * Додати попередження до регіону
   * @param warning - попередження для додавання
   */
  public addWarning(warning: Warning): void {
    this.warnings.push(warning);
    console.log(`Попередження додано до регіону ${this.name}`);
  }

  /**
   * Отримати назву регіону
   * @returns назва регіону
   */
  public getName(): string {
    return this.name;
  }

  /**
   * Отримати список попереджень
   * @returns список попереджень
   */
  public getWarnings(): Warning[] {
    return this.warnings;
  }
}
