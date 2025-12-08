/**
 * Інтерфейс для формування сповіщень
 */
export interface INotificationPlan {
  /**
   * Метод для формування сповіщення
   * @returns текст сповіщення
   */
  formNotification(): string;
}
