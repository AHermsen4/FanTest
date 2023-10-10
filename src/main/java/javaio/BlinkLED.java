package javaio;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/*
Simple class for writing and testing outputpin

@author Leo Korbee (l.korbee@graafschapcollege.nl)
@version 2022-08-07
*/

public class BlinkLED
{
	// define the pin number that has the LED connected
	public final static Pin LED_PIN = RaspiPin.GPIO_01;

	// Initialize the Wiring Pi Library and Hardware controller
	final static GpioController gpio = GpioFactory.getInstance();

	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("Brushless fan on pin " + LED_PIN + " should turn on and off");
		// load the pin
		GpioPinDigitalOutput led = gpio.provisionDigitalOutputPin(LED_PIN, "led", PinState.LOW);

		System.out.println("Press Ctrl-C to stop");

		// Loop forever until we press Ctrl-C
		while (true)
		{
			// Set the pin high (1) the pin so that the LED turns on
			led.high();
			// wait 500 ms
			Thread.sleep(1500);
			// Set the pin low (0) the pin so that the LED turns off
			led.low();
			// wait 500 ms
			Thread.sleep(1500);
		}

	}

}
