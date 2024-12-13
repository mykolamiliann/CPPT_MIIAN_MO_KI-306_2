package KI.Milian.Lab2;

/**
 * Клас, що описує Bluetooth модуль для аудіоплеєра.
 */
public class BluetoothModule {
    private boolean isConnected; // Стан підключення
    private String connectedDevice; // Підключений пристрій

    public BluetoothModule() {
        this.isConnected = false;
        this.connectedDevice = "None";
    }

    public void connectToDevice(String device) {
        this.isConnected = true;
        this.connectedDevice = device;
    }

    public void disconnect() {
        this.isConnected = false;
        this.connectedDevice = "None";
    }

    public boolean isConnected() {
        return isConnected;
    }

    public String getConnectedDevice() {
        return connectedDevice;
    }

    @Override
    public String toString() {
        return "BluetoothModule{isConnected=" + isConnected + ", connectedDevice='" + connectedDevice + "'}";
    }
}