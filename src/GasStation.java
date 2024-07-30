public class GasStation {
    /*
    134.

    */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 0 1 2 3
        // 5 2 3 4: gas
        // 6 2 1 3: cost

        // - - + +

        // 5 2 3 4: gas
        // 6 2 1 10: cost
        // - - + -

        // 0th --> no
        // 1th --> yes
        // 2th --> yes
        // 3th --> yes

        // formula: ((curGas + gas[i] - cost[i]) + gas[i + 1] - cost[i - 1])
        // 0 + 5 - 6 --> negative: no
        // ((((0 + 2 - 2) + 3 - 1) + 4 - 3) + 5 - 6) --> positive: yes
        // cusGas + gas[i] - cost[i] + gas[i + 1] - cost[i + 1] + ...

        // 0 1 2 3 4
        // 1 2 3 4 5: gas
        // 3 4 5 1 2: cost

        // 1  3  6  10 15
        // 15 14 12 9  5

        // 0 1 2 3
        // 5 2 3 4: gas
        // 6 2 1 3: cost

        // - - - + +
        //
        // int n = gas.length;
        // for (int i = 0; i < n; i++) {
        //     int curGas = 0;
        //     int c = 0;
        //     for (int j = i; c < n; c++, j = (j + 1) % n) {
        //         curGas += (gas[j] - cost[j]); // 2
        //         if (curGas < 0) {
        //             break;
        //         }
        //     }
        //     if (c == n) {
        //         return i;
        //     }
        // }
        // return -1;

        // - - - + +

        // 1 2 3 5 5
        // 3 3 5 1 6
        // - - - + -

        // 1 2 3 4 5.   200
        // 3 3 5 1 100. 1
        // - - - + - +

        // greedy:
        // take first: no
        // take max: no

        // array of gas - cost
        // find max sum of sub array

        int n = gas.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = gas[i] - cost[i];
        }

        int curSum = 0;
        int idx = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
            curSum += arr[i];
            if (curSum < 0) {
                curSum = 0;
                idx = i + 1;
            }
        }
        return total >= 0 ? idx : -1;
    }
}
