package com.example.test2;

/**
 * Control gpio
 */
public class GpioManager {

    public static int out = 1;
    public static int in = 0;

    static {
        System.loadLibrary("gpio-manager");
    }


    public static native int exportGpio(int gpio);

    public static native int setGpioDirection(int gpio, int direction);

    public static native int readGpioStatus(int gpio);

    /**
     * Modify the state gpio
     * @param gpio
     * @param value
     * @return
     */
    public static native int writeGpioStatus(int gpio, int value);

    public static native int unexportGpio(int gpio);
}
