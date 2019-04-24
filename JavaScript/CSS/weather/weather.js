const API_KEY = '7e894a2c970923032fb7a77ad196a872';
const btn = document.getElementById('button');
const w1 = document.getElementById('w1');
const w2 = document.getElementById('w2');
const w3 = document.getElementById('w3');
const w4 = document.getElementById('w4');
const w5 = document.getElementById('w5');

const weatherDiv = [w1, w2, w3, w4, w5];

const ctx = document.getElementById('myChart');

const myChart = new Chart(ctx, {
  type: 'line',
  data: {
    // 날짜 5일
    labels: ['월요일', '화요일', '수요일', '목요일', '금요일'],
    datasets: [
      {
        label: 'My First dataset',
        backgroundColor: 'red',
        borderColor: 'red',
        data: [26, 21, 15, 19, 17],
        fill: false,
        pointRadius: 3,
        pointHoverRadius: 15,
        showLine: false, // no line shown
      },
      {
        label: 'My Second dataset',
        backgroundColor: 'blue',
        borderColor: 'blue',
        data: [16, 15, 8, 8, 10],
        fill: false,
        pointRadius: 3,
        pointHoverRadius: 5,
        showLine: false, // no line shown
      },
    ],
  },
  options: {
    layout: {
      padding: {
        left: 50,
        right: 50,
        top: 10,
        bottom: 10,
      },
    },
    responsive: false,
    scales: {
      xAxes: [
        {
          display: false,
        },
      ],
    },
    title: {
      display: true,
      text: '주간 날씨',
    },
    legend: {
      display: false,
    },
    elements: {
      point: {
        pointStyle: 'circle',
      },
    },
  },
});

function printWeather(weathers) {
  weathers.forEach((day, index) => {
    const temperature = day.main.temp;
    const weatherToday = day.weather[0].main;
    weatherDiv[index].innerHTML = `${temperature}℃ <br> ${weatherToday}`;
  });
}

function fetchWeather(latitude, longitude) {
  fetch(
    `https://api.openweathermap.org/data/2.5/forecast?lat=${latitude}&lon=${longitude}&appid=${API_KEY}&units=metric`,
  )
    .then(response => response.json())
    .then((json) => {
      const weatherList = json.list;
      const weathersAtNoon = weatherList.filter(
        weather => weather.dt_txt.split(' ')[1].slice(0, 2) === '12',
      );
      printWeather(weathersAtNoon);
    });
}

function getWeather() {
  navigator.geolocation.getCurrentPosition((position) => {
    const lat = position.coords.latitude;
    const lon = position.coords.longitude;
    fetchWeather(lat, lon);
  });
}

function init() {
  btn.addEventListener('click', getWeather);
}

init();
