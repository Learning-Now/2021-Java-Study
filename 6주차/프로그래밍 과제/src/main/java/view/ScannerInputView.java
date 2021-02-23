package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScannerInputView{

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static String[] getFormular() throws IOException {
        String[] formularArguement = bf.readLine().split(" ");
        return formularArguement;
    }
}
