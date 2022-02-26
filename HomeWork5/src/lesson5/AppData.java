package lesson5;

import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public int[][] getData() {
        return Arrays.copyOf(data, data.length);
    }

    public void setData(int[][] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    public String[] getHeader() {
        return Arrays.copyOf(header, header.length);
    }

    public void setHeader(String[] header) {
        this.header = Arrays.copyOf(header, header.length);
    }

    public void printAppData() {
        System.out.println("Header Data: " + Arrays.toString(header));
        System.out.println("Main Data: ");
        for (int i = 0; i < data.length; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
    }

}
