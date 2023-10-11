package javaio;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class BlinkLED {

    public static void main(String[] args) throws InterruptedException {
        // Create a GPIO controller
        final GpioController gpio = GpioFactory.getInstance();

        // Provision the pin
        final GpioPinDigitalOutput fanPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Fan", PinState.LOW);

        // Turn the fan on
        fanPin.high();
        System.out.println("Fan is ON");
        Thread.sleep(5000); // Run for 5 seconds

        // Turn the fan off
        fanPin.low();
        System.out.println("Fan is OFF");
        
        // Release resources
        gpio.shutdown();
    }
}