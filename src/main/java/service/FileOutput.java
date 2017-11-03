package service;


import java.util.List;

public class FileOutput implements Output {

    private WeatherService weatherService = new WeatherService();
    private static final String FILE_LOCATION = "results.txt";

    @Override
    public void print() {
        List<String> list = weatherService.getMetricsFromJson();
        list.stream().forEach(x-> System.out.println(x));
    }
}
