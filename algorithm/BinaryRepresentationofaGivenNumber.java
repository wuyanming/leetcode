package BasicConcepts;

public class BinaryRepresentationofaGivenNumber {

    public static void main(String args[]) {
        int n = 11;
        String sb = Integer.toBinaryString(n);
        System.out.println("11 in binary: " + sb);

        convertBinary(n);
        System.out.println();
        convertBinarySec(n);
        System.out.println();
        convertBinaryThird(n);

    }


    public static void convertBinary(int num) {
        int binary[] = new int[40];
        int index = 0;
        while (num > 0) {
            binary[index++] = num % 2;
            num = num / 2;
        }

        System.out.print("convertBinary: ");
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(binary[i]);
        }
    }


    public static void convertBinarySec(int num) {
        StringBuilder binary = new StringBuilder();

        while (num > 0) {
            if ((num & 1) == 1) {
                binary.append(1);
            } else
                binary.append(0);
            num >>= 1;
        }
        System.out.println("convertBinarySec: " + binary.reverse());
    }


    public static void convertBinaryThird(int num) {
        StringBuilder result = new StringBuilder();

        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            result.append((num & mask) != 0 ? "1" : "0");
        }
        System.out.println("convertBinaryThird: " + result.toString());
    }
}
