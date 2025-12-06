// API базовий URL
// Визначаємо URL в залежності від середовища
const API_URL = window.location.hostname === 'localhost' 
    ? 'http://localhost:8080/api'
    : 'https://automatic-garbanzo-9765wxqrpg79c46g-8080.app.github.dev/api';

// Завантажуємо дані при завантаженні сторінки
document.addEventListener('DOMContentLoaded', function() {
    // Ініціалізуємо навігацію
    initNavigation();
    
    // Завантажуємо дані
    loadStatus();
    loadSubscribers();
    loadWeatherForecast();
    
    // Оновлюємо дані кожні 5 секунд
    setInterval(() => {
        loadStatus();
        loadSubscribers();
        loadWeatherForecast();
    }, 5000);
});

/**
 * Ініціалізує навігаційні кнопки
 */
function initNavigation() {
    const navButtons = document.querySelectorAll('.nav-btn');
    
    navButtons.forEach(button => {
        button.addEventListener('click', function() {
            const sectionId = this.getAttribute('data-section');
            showSection(sectionId);
            
            // Оновлюємо активну кнопку
            navButtons.forEach(btn => btn.classList.remove('active'));
            this.classList.add('active');
        });
    });
}

/**
 * Завантажує прогноз погоди на 5 днів
 */
function loadWeatherForecast() {
    const weatherData = [
        {
            date: getDateString(0),
            day: getDayName(0),
            temp: '+18°C',
            condition: 'Переважно хмарно',
            humidity: '65%',
            wind: '10 км/год',
            icon: '⛅'
        },
        {
            date: getDateString(1),
            day: getDayName(1),
            temp: '+16°C',
            condition: 'Дощ',
            humidity: '80%',
            wind: '15 км/год',
            icon: '🌧️'
        },
        {
            date: getDateString(2),
            day: getDayName(2),
            temp: '+12°C',
            condition: 'Грозі',
            humidity: '85%',
            wind: '20 км/год',
            icon: '⛈️'
        },
        {
            date: getDateString(3),
            day: getDayName(3),
            temp: '+15°C',
            condition: 'Хмарно',
            humidity: '70%',
            wind: '12 км/год',
            icon: '☁️'
        },
        {
            date: getDateString(4),
            day: getDayName(4),
            temp: '+20°C',
            condition: 'Сонячно',
            humidity: '55%',
            wind: '8 км/год',
            icon: '☀️'
        }
    ];
    
    const forecastDiv = document.getElementById('weatherForecast');
    const html = weatherData.map(day => `
        <div class="weather-day">
            <div class="weather-day-header">
                <span class="weather-icon">${day.icon}</span>
                <div class="weather-day-info">
                    <p class="weather-day-name">${day.day}</p>
                    <p class="weather-day-date">${day.date}</p>
                </div>
            </div>
            <div class="weather-day-details">
                <div class="weather-detail-item">
                    <span class="detail-label">Температура:</span>
                    <span class="detail-value">${day.temp}</span>
                </div>
                <div class="weather-detail-item">
                    <span class="detail-label">Умови:</span>
                    <span class="detail-value">${day.condition}</span>
                </div>
                <div class="weather-detail-item">
                    <span class="detail-label">Вологість:</span>
                    <span class="detail-value">${day.humidity}</span>
                </div>
                <div class="weather-detail-item">
                    <span class="detail-label">Вітер:</span>
                    <span class="detail-value">${day.wind}</span>
                </div>
            </div>
        </div>
    `).join('');
    
    forecastDiv.innerHTML = html;
}

/**
 * Отримує дату в форматі DD.MM.YYYY для заданої кількості днів
 * @param {number} daysOffset - кількість днів від сьогодні
 * @returns {string} дата в форматі DD.MM.YYYY
 */
function getDateString(daysOffset) {
    const date = new Date();
    date.setDate(date.getDate() + daysOffset);
    const day = String(date.getDate()).padStart(2, '0');
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const year = date.getFullYear();
    return `${day}.${month}.${year}`;
}

/**
 * Отримує назву дня тижня
 * @param {number} daysOffset - кількість днів від сьогодні
 * @returns {string} назва дня
 */
function getDayName(daysOffset) {
    const days = ['Неділя', 'Понеділок', 'Вівторок', 'Середа', 'Четвер', 'П\'ятниця', 'Субота'];
    const date = new Date();
    date.setDate(date.getDate() + daysOffset);
    return days[date.getDay()];
}

/**
 * Показує обраний розділ та приховує решту
 * @param {string} sectionId - ID розділу для показу
 */
function showSection(sectionId) {
    const sections = document.querySelectorAll('.section');
    
    sections.forEach(section => {
        if (section.id === sectionId) {
            section.classList.add('active');
        } else {
            section.classList.remove('active');
        }
    });
}

/**
 * Завантажує статус системи з API
 */
function loadStatus() {
    fetch(`${API_URL}/status`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            const statusDiv = document.getElementById('status-content');
            statusDiv.innerHTML = `
                <div class="status-content">
                    <p><strong>Сервіс:</strong> ${data.service}</p>
                    <p><strong>Версія:</strong> ${data.version}</p>
                    <p><strong>Статус:</strong> <span class="status-ok">${data.status}</span></p>
                    <p><strong>Кількість підписників:</strong> ${data.subscribers_count}</p>
                </div>
            `;
        })
        .catch(error => {
            console.error('Помилка при завантаженні статусу:', error);
            const statusDiv = document.getElementById('status-content');
            statusDiv.innerHTML = '<p class="error">Помилка підключення до сервера: переконайтесь, що сервер запущено</p>';
        });
}

/**
 * Завантажує список підписників з API
 */
function loadSubscribers() {
    fetch(`${API_URL}/subscribers`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(subscribers => {
            displaySubscribers(subscribers);
        })
        .catch(error => {
            console.error('Помилка при завантаженні підписників:', error);
            const tableBody = document.getElementById('tableBody');
            tableBody.innerHTML = '<tr><td colspan="2" class="error">Помилка завантаження даних</td></tr>';
        });
}

/**
 * Відображає список підписників у таблиці
 * @param {Array} subscribers - масив підписників
 */
function displaySubscribers(subscribers) {
    const tableBody = document.getElementById('tableBody');
    
    if (!subscribers || subscribers.length === 0) {
        tableBody.innerHTML = '<tr><td colspan="2" class="empty-state">Немає підписників</td></tr>';
        return;
    }
    
    // Генеруємо HTML для кожного підписника
    const html = subscribers.map((subscriber, index) => `
        <tr>
            <td>${index + 1}</td>
            <td>${escapeHtml(subscriber.name)}</td>
        </tr>
    `).join('');
    
    tableBody.innerHTML = html;
}

/**
 * Екранує HTML спеціальні символи для безпеки
 * @param {string} text - текст для екранування
 * @returns {string} екранований текст
 */
function escapeHtml(text) {
    const map = {
        '&': '&amp;',
        '<': '&lt;',
        '>': '&gt;',
        '"': '&quot;',
        "'": '&#039;'
    };
    return text.replace(/[&<>"']/g, m => map[m]);
}