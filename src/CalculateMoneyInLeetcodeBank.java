public class CalculateMoneyInLeetcodeBank {
    /*
    1716.

    */

    public int totalMoney(int n) {
        int base = 28;
        int weeks = n / 7;
        int days = n % 7;

        int sum = (int)(base * weeks + 7 * (weeks * ((double)weeks - 1) / 2));
        for (int i = 1; i <= days; i++) {
            sum += weeks + i;
        }
        return sum;
    }
}
