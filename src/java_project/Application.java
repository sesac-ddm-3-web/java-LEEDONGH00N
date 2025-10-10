package java_project;

import java_project.calculate.PostFixEngine;
import java_project.converter.PostFixConverter;

import java_project.device.CalculatorDevice;


public class Application {
    public static void main(String[] args) {
        CalculatorDevice device = new CalculatorDevice(new PostFixConverter(), new PostFixEngine());
        device.run();
    }
}
