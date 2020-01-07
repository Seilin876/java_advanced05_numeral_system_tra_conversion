package com.example.advancedhw05;

import java.util.Scanner;

public class Tra {
    Scanner scanner = new Scanner(System.in);
    private String Dec = "";
    private char Word[][] = {{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'},{'0', '1', '2', '3', '4', '5', '6', '7'},
            {'0', '1'}, {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'}};
    private String Bin = "";
    private String Hex = "";
    private String Oct = "";

    public void setDecimal(String decimal) {
        Dec = decimal;
    }

    public void setOctal(String octal) {
        Oct = octal;
    }

    public void setBin(String binary) {
        Bin = binary;
    }

    public void setHex(String hexadecimal) {
        Hex = hexadecimal;
    }

    public void DecTra() {
        System.out.println("請輸入十進位數");
        setDecimal(scanner.next());
        if (Judge("Decimal", Dec) == false)
            System.out.println("輸入錯誤請輸入正確的十進位數");
        else {
            int DecimalInt = Integer.parseInt(Dec);
            Bin = Integer.toBinaryString(DecimalInt);
            Oct = Integer.toOctalString(DecimalInt);
            Hex = Integer.toHexString(DecimalInt);
            System.out.println("二進制:"+Bin);
            System.out.println("八進制:"+Oct);
            System.out.println("十六進制:"+Hex);
        }
    }

    public void OctTra() {
        System.out.println("請輸入八進位數");
        setOctal(scanner.next());
        if (Judge("Octal", Oct) == false)
            System.out.println("輸入錯誤請輸入正確的八進位數");
        else {
            int DecimalInt = Integer.valueOf(Oct,8);
            Bin = Integer.toBinaryString(DecimalInt);
            Dec = Integer.toString(DecimalInt);
            Hex = Integer.toHexString(DecimalInt);
            System.out.println("十進制:"+Dec);
            System.out.println("二進制:"+Bin);
            System.out.println("十六進制:"+Hex);
        }
    }

    public void BinTra() {
        System.out.println("請輸入二進位數");
        setBin(scanner.next());
        if (Judge("Binary", Bin) == false)
            System.out.println("輸入錯誤請輸入正確的二進位數");

        else {
            int DecimalInt = Integer.valueOf(Bin,2);
            Dec = Integer.toString(DecimalInt);
            Oct = Integer.toOctalString(DecimalInt);
            Hex = Integer.toHexString(DecimalInt);
            System.out.println("十進制:"+Dec);
            System.out.println("八進制:"+Oct);
            System.out.println("十六進制:"+Hex);
        }
    }

    public void HexTra() {
        System.out.println("請輸入十六進位數");
        setHex(scanner.next());
        if (Judge("Hexadecimal", Hex) == false)
            System.out.println("輸入錯誤請輸入正確的十六進位數");

        else {
            int DecimalInt = Integer.valueOf(Hex,16);
            Dec = Integer.toString(DecimalInt);
            Oct = Integer.toOctalString(DecimalInt);
            Bin = Integer.toBinaryString(DecimalInt);
            System.out.println("十進制:"+Dec);
            System.out.println("八進制:"+Oct);
            System.out.println("二進制:"+Bin);
        }
    }

    public boolean Judge(String Type, String Number) {
        boolean JudgeBoolean = true;
        int k = -1;
        int length = 0;
        if (Type.matches("Decimal")) {
            k = 0;
            length = 10;
        }  else if (Type.matches("Octal")) {
            k = 1;
            length = 8;
        }  else if (Type.matches("Binary")) {
            k = 2;
            length = 2;
        } else if (Type.matches("Hexadecimal")) {
            k = 3;
            length = 16;
        }
        if (k == 0 || k == 1 || k == 2 || k == 3) {
            for (int i = Number.length() - 1; i >= 0; i--) {
                int JudgeCount = 0;
                for (int j = 0; j < length; j++) {
                    if (Number.charAt(i) != Word[k][j]) {
                        JudgeCount++;
                    }
                    if (JudgeCount == length) {
                        JudgeBoolean = false;
                    }
                }
            }
        } else JudgeBoolean = false;

        return JudgeBoolean;
    }

}
