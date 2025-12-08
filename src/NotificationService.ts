import { Subscriber } from './Subscriber';

/**
 * Клас для надсилання сповіщень
 */
export class NotificationService {
  private recipients: string[] = [];
  private subscribers: Subscriber[] = [];

  /**
   * Конструктор для класу NotificationService
   */
  constructor() {
    // Ініціалізація завершена
  }

  /**
   * Додати адресата до списку
   * @param recipient - адреса електронної пошти або ім'я адресата
   */
  public addRecipient(recipient: string): void {
    this.recipients.push(recipient);
  }

  /**
   * Додати підписника
   * @param subscriber - об'єкт підписника
   */
  public addSubscriber(subscriber: Subscriber): void {
    this.subscribers.push(subscriber);
  }

  /**
   * Надіслати сповіщення
   * @param text - текст сповіщення
   * @returns результат відправлення (true - успішно, false - помилка)
   */
  public send(text: string): boolean {
    if (this.recipients.length === 0 && this.subscribers.length === 0) {
      console.log('Немає отримувачів або підписників для надсилання сповіщення.');
      return false;
    }

    // Надіслати адресатам
    for (const recipient of this.recipients) {
      console.log(`Надсилання сповіщення: '${text}' до ${recipient}`);
    }

    // Надіслати підписникам
    for (const subscriber of this.subscribers) {
      subscriber.deliverMessage(text);
    }

    return true;
  }

  /**
   * Отримати список адресатів
   * @returns список адресатів
   */
  public getRecipients(): string[] {
    return this.recipients;
  }

  /**
   * Отримати список підписників
   * @returns список підписників
   */
  public getSubscribers(): Subscriber[] {
    return this.subscribers;
  }
}
