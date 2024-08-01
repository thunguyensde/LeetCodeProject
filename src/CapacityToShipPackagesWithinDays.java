public class CapacityToShipPackagesWithinDays {
    /*
    1011.

    */

    public int shipWithinDays(int[] weights, int days) {
        // result range: [1, sum(weights)]
        int n = weights.length;

        int sumWeight = 0;
        int maxWeight = 0;
        for (int weight : weights) {
            sumWeight += weight;
            maxWeight = Math.max(maxWeight, weight);
        }

        int left = maxWeight;
        int right = sumWeight;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (shippable(weights, days, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // System.out.println(shippable(weights, days, 5));

        return left;

        // right < left
        // - mid == right == left, shippable, right = mid - 1 --> return left;
        // - mid == right == left, not shippable, left = mid + 1 --> return left;
    }

    private boolean shippable(int[] weights, int days, int capacity) {
        int i = 0;
        int numDays = 0;
        while (i < weights.length) {
            if (capacity < weights[i]) {
                return false;
            }

            // System.out.println(i);
            numDays++;
            int curCapacity = capacity;
            while (i < weights.length && curCapacity >= weights[i]) {
                curCapacity -= weights[i];
                i++;
            }
        }
        return numDays <= days;
    }
}
