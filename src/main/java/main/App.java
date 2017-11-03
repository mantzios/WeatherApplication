package main;

import service.WeatherService;

public class App {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        weatherService.getResults();
    }
}
