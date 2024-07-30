import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
    /*
    989.

    */
    public List<Integer> addToArrayForm(int[] num, int k) {
        // 101
        // 100

        // 100

        // 101 --> 5


        // 100
        // 011

        int n = num.length;
        int i = n - 1;
        LinkedList<Integer> sum = new LinkedList<>();
        int mem = 0;
        while (i >= 0 || k > 0 || mem > 0) {
            if (i >= 0) {
                mem += num[i];
                i--;
            }
            if (k > 0) {
                mem += (k % 10);
                k /= 10;
            }
            sum.addFirst(mem % 10);
            mem /= 10;
        }
        return sum;
    }
}
