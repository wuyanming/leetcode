package HighFrequence.Summary;

public class ExcelSheetColumnTitle_168 {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }
}
