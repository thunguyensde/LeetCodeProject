public class ExcelSheetColumnTitle {
    /*
    168.

    requirement:
    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
    For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...

    test case:
    - 3 -> C

    solution:
    divide columnNumber by 26
    - result
    - remainder

    dry run:

    complexity:
    - time: O(logn)
    - space: O(1)
    */

    public String getColumnTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber -= 1;
            int remainder = columnNumber % 26; // 2
            char ch = (char) ('A' + remainder); // B
            sb.append(ch); // B
            columnNumber /= 26; // 1
        }
        return sb.reverse().toString();
    }
}
