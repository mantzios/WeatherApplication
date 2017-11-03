package main;

import service.WeatherService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        List<String> list=weatherService.getMetrics();
        list.stream().forEach(x-> System.out.println(x));

    }
}
