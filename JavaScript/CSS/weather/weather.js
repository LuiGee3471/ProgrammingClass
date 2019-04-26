const API_KEY = '7e894a2c970923032fb7a77ad196a872';
const w1 = document.getElementById('w1');
const w2 = document.getElementById('w2');
const w3 = document.getElementById('w3');
const main = document.getElementById('main');
const chart24h = document.getElementById('chart24h');
const chartDays = document.getElementById('chartDays');

function getWeatherNow(weatherList) {
  const now = new Date();
  const weatherInfo = weatherList[3];
  const temp = weatherInfo.main.temp;
  const weatherNow = weatherInfo.weather[0].main;
  const tempText = w1.querySelector('.temp');
  const weatherText = w1.querySelector('.weather');
  const advice = w1.querySelector('.advice');
  tempText.innerText = `${Math.round(temp)}℃`;
  if (weatherNow === 'Rains') {
    main.style.backgroundImage = "url('images/rain.jpg')";
    weatherText.innerText = '비가 오는 날입니다';
    advice.innerText = '나갈 때는 우산을 잊지 말고 챙기세요';
  } else if (weatherNow === 'Clouds') {
    main.style.backgroundImage = "url('images/cloud.jpg')";
    weatherText.innerText = '구름이 많이 끼어 있어요';
    advice.innerText = '생각보다 쌀쌀할 수도 있으니 옷을 챙기세요';
  } else if (now.getHours < 19 && now.getHours > 6) {
    main.style.backgroundImage = "url('images/sunny.jpg')";
    weatherText.innerText = '화창한 날입니다';
    advice.innerText = '따뜻한 날씨를 마음껏 만끽하세요';
  } else {
    main.style.backgroundImage = "url('images/night.jpg')";
    weatherText.innerText = '달이 맑게 보이는 날입니다';
    advice.innerText = '창문을 열어놔도 시원한 밤바람이 불어요';
  }
}

function getWeather24h(weatherList) {
  const weather24hrs = weatherList.filter(
    (weather, index) => index >= 3 && index <= 10,
  );
  const hourStrings = [];
  const tempData = [];
  weather24hrs.forEach((weather) => {
    hourStrings.push(`${weather.dt_txt.split(' ')[1].slice(0, 2)}시`);
    tempData.push(Math.round(weather.main.temp));
  });
  const chart = new Chart(chart24h, {
    plugins: [ChartDataLabels],
    type: 'line',
    data: {
      labels: hourStrings,
      datasets: [
        {
          data: tempData,
          fill: false,
          showLine: false,
          pointBorderColor: '#EF534F',
          pointBorderWidth: 3,
          pointBackgroundColor: 'white',
          datalabels: {
            align: 'top',
            font: {
              size: 18,
            },
          },
        },
      ],
    },
    options: {
      legend: false,
      responsive: false,
      scales: {
        xAxes: [
          {
            gridLines: {
              display: false,
              drawBorder: false,
            },
            ticks: {
              fontSize: 16,
              fontFamily: "'Jeju Gothic', sans-serif",
            },
          },
        ],
        yAxes: [
          {
            gridLines: {
              display: false,
              drawBorder: false,
            },
            ticks: {
              display: false,
              min: Math.min(...tempData) - 1,
              max: Math.max(...tempData) + 1,
              stepSize: 1,
            },
          },
        ],
      },
    },
  });
}

function getWeatherDays(weatherList) {
  const now = new Date();
  const dates = [];
  const minTemp = [];
  const maxTemp = [];
  for (let i = 1; i <= 4; i++) {
    const day = new Date();
    day.setDate(now.getDate() + i);
    dates.push(`${day.getDate()}일`);
    const weathers = weatherList.filter(
      weather => +weather.dt_txt.split(' ')[0].slice(8, 10) === day.getDate(),
    );
    const temps = [];
    weathers.forEach((weather) => {
      temps.push(weather.main.temp);
    });
    minTemp.push(Math.round(Math.min(...temps)));
    maxTemp.push(Math.round(Math.max(...temps)));
  }

  const chart = new Chart(chartDays, {
    plugins: [ChartDataLabels],
    type: 'line',
    data: {
      labels: dates,
      datasets: [
        {
          data: minTemp,
          fill: false,
          borderColor: 'skyblue',
          pointRadius: 5,
          pointBackgroundColor: 'skyblue',
          showLine: false,
          datalabels: {
            align: 'bottom',
            font: {
              size: 18,
              family: "'Jeju Gothic', sans-serif",
            },
          },
        },
        {
          data: maxTemp,
          fill: false,
          borderColor: 'tomato',
          pointRadius: 5,
          pointBackgroundColor: 'tomato',
          showLine: false,
          datalabels: {
            align: 'top',
            font: {
              size: 18,
              family: "'Jeju Gothic', sans-serif",
            },
          },
        },
      ],
    },
    options: {
      legend: false,
      responsive: false,
      scales: {
        xAxes: [
          {
            gridLines: {
              display: false,
              drawBorder: false,
            },
            ticks: {
              fontSize: 18,
              fontFamily: "'Jeju Gothic', sans-serif",
            },
          },
        ],
        yAxes: [
          {
            gridLines: {
              display: false,
              drawBorder: false,
            },

            ticks: {
              display: false,
              min: Math.min(...minTemp) - 2,
              max: Math.max(...maxTemp) + 2,
            },
          },
        ],
      },
    },
  });
}

function getWeather(lat, lon) {
  fetch(
    `https://api.openweathermap.org/data/2.5/forecast?lat=${lat}&lon=${lon}&units=metric&appid=${API_KEY}`,
  )
    .then(response => response.json())
    .then((json) => {
      const weatherList = json.list;
      getWeatherNow(weatherList);
      getWeather24h(weatherList);
      getWeatherDays(weatherList);
    });
}

function handleSuccess(position) {
  const lat = position.coords.latitude;
  const lon = position.coords.longitude;
  getWeather(lat, lon);
}

function askForCoords() {
  navigator.geolocation.getCurrentPosition(handleSuccess);
}

function init() {
  askForCoords();
}

init();
