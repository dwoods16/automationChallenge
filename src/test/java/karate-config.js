function fn() {
  var config = {
    api: {
        baseURL: 'https://httpbin.org/',
    ui: {
        amazonBaseURL: 'https://dashboard.booking.icabbi.dev',
        }
    }
  };

 // karate.configure("driver", chromeDriver);
  karate.configure('report', { showLog: true, showAllSteps: true });

  return config;
}
