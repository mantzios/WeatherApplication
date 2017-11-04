package main;

import service.Output;
import service.FileOutput;

public class App {
    public static void main(String[] args) {
        Output output = new FileOutput();
        output.out();
    }
}
