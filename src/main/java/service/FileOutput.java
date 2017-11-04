package service;


import enumeration.Metrics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileOutput implements Output {

    private WeatherService weatherService = new WeatherService();
    private static final String FILE_LOCATION = "results.txt";

    @Override
    public void print() {
        List<String> list = weatherService.getMetricsFromJson();
        try {
            FileWriter fileWriter = new FileWriter(new File(FILE_LOCATION));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            List<Enum> metrics = Arrays.asList(Metrics.values());
            for(int i=0; i<list.size(); i++){
                bufferedWriter.write(metrics.get(i).toString());
                bufferedWriter.write("\t\t");
                bufferedWriter.write(list.get(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
