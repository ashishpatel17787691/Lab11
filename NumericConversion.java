
import java.util.Scanner;

public class NumericConversion{

    public static long hexStringDecode (String hex) {
        int exponent = 0;
        String hexLow;
        hexLow = hex.toLowerCase();
        long decimalValue = 0;
        if (hex.charAt(1) == 'x') {
        for (int i = hexLow.length() - 1; i >= 2; i--) {
            if (hexLow.charAt(i) > 47 && hexLow.charAt(i) < 58) {
                decimalValue += (long) (hexLow.charAt(i) - 48) * Math.pow(16, exponent);
                exponent++;
            } else if (hexLow.charAt(i) > 96 && hexLow.charAt(i) < 103) {
                decimalValue += (long) (hexLow.charAt(i) - 87) * Math.pow(16, exponent);
                exponent++;
            }
            }
        }
        else  {
            for (int i = hexLow.length() - 1; i >= 0; i--) {
                if (hexLow.charAt(i) > 47 && hexLow.charAt(i) < 58) {
                    decimalValue += (long) (hexLow.charAt(i) - 48) * Math.pow(16, exponent);
                    exponent++;
                } else if (hexLow.charAt(i) > 96 && hexLow.charAt(i) < 103) {
                    decimalValue += (long) (hexLow.charAt(i) - 87) * Math.pow(16, exponent);
                    exponent++;
                }
            }
        }
        return decimalValue;
    }
    public static short hexCharDecode (char hex) {
        int exponent = 0;
        short decimalValue = 0;
            if (hex > 47 && hex < 58) {
                decimalValue = (short) ((hex - 48) * Math.pow(16, exponent));

            } else if (hex > 96 && hex < 103) {
                decimalValue = (short) ( (hex - 87) * Math.pow(16, exponent));

            }
        return decimalValue;
            }
    public static short binaryStringDecode (String binary) {
        int exponent = 0;

        short decimalValue = 0;
        if (binary.charAt(1) == 'b'){
            for (int i = binary.length() - 1; i >= 2; i--) {
                if (binary.charAt(i) > 47 && binary.charAt(i) < 50) {
                    decimalValue += (short) (binary.charAt(i) - 48) * Math.pow(2, exponent);
                    exponent++;
                }

            }
        }
        else {
            for (int i = binary.length() - 1; i >= 0; i--) {
                if (binary.charAt(i) > 47 && binary.charAt(i) < 50) {
                    decimalValue += (short) (binary.charAt(i) - 48) * Math.pow(2, exponent);
                    exponent++;
                }

            }
        }

        return decimalValue;
    }
    public static String binaryToHex (String binary) {

        long decimalValue = binaryStringDecode(binary);
        long decAppend = 0;
        String hexAppend = "";
        String hexDecimal = "";
        int i = 1;

        while (i != 0) {
            decAppend = decimalValue % 16;

            if (decAppend == 10) {
                hexAppend = "A";
            } else if (decAppend == 11) {
                hexAppend = "B";
            } else if (decAppend == 12) {
                hexAppend = "C";
            } else if (decAppend == 13) {
                hexAppend = "D";
            } else if (decAppend == 14) {
                hexAppend = "E";
            } else if (decAppend == 15) {
                hexAppend = "F";
            } else {
                hexAppend = Long.toString(decAppend);
            }
            hexDecimal = hexAppend + hexDecimal;

            decimalValue =  (decimalValue / 16);

            if (decimalValue == 0) {
                i = 0;
            }


        }
        return hexDecimal;
    }

    public static void main(String[] args) {

        short operator;
        System.out.println("\nDecoding Menu"); //displaying operation menu
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit");
        System.out.print("\nPlease enter an option: ");
        Scanner scnr = new Scanner(System.in);
        operator = scnr.nextShort(); //assigning user input to variable operator

        while(operator != 0) {

            if (operator == 1) {
                System.out.print("Please enter the numeric string to convert: ");
                String alpha = scnr.next();

                if (alpha.length() > 1) {
                    long beta = hexStringDecode(alpha);
                    System.out.println("Result: " + beta);
                } else if (alpha.length() == 1) {
                    char charlie = alpha.charAt(0);
                    short beta = hexCharDecode(charlie);
                    System.out.println("Result: " + beta);
                }
            } else if (operator == 2) {
                System.out.print("Please enter the numeric string to convert: ");
                String alpha = scnr.next();
                long beta = binaryStringDecode(alpha);
                System.out.println("Result: " + beta);
            } else if (operator == 3) {
                System.out.print("Please enter the numeric string to convert: ");
                String alpha = scnr.next();
                String beta = binaryToHex(alpha);
                System.out.println("Result: " + beta);
            } else {
                System.out.println("Goodbye!");
                break;
            }

            System.out.println("\nDecoding Menu"); //displaying operation menu
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");
            System.out.print("\nPlease enter an option: ");
            operator = scnr.nextShort();
        }

        }
    }

