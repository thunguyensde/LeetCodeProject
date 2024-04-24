public class PermutationInString {
    /*
    567.

    */
    public boolean checkInclusion(String s1, String s2) {
        // - generate all perm of s1, find them in s2
        // - count freqs
        // - sliding windows fixed size
        // abc -> a: 1, b: 1, c: 1
        // eidbaoobac

        // aabo -> a: 1, b: 0, o: 0
        // eid b aob a

        int m = s1.length();
        int n = s2.length();
        if (m > n) return false;

        int[] map = new int[26];
        int[] curMap = new int[26];
        for (int i = 0; i < m; i++) {
            map[s1.charAt(i) - 'a']++;
            curMap[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n - m + 1; i++) {
            boolean match = true;
            for (int j = 0; j < 26; j++) {
                if (map[j] != curMap[j]) {
                    match = false;
                }
            }
            if (match) return true;
            if (i == n - m) return false;
            curMap[s2.charAt(i) - 'a']--;
            curMap[s2.charAt(i + m) - 'a']++;
        }

        return false;
    }

     public boolean optimizedCheckInclusion(String s1, String s2) {
         // - generate all perm of s1, find them in s2
         // - count freqs
         // - sliding windows fixed size
         // abc -> a: 1, b: 1, c: 1
         // eidbaoobac

         // aabo -> a: 1, b: 0, o: 0
         // eid b aob a

         int m = s1.length();
         int n = s2.length();
         if (m > n) return false;

         int[] map = new int[26];
         int[] curMap = new int[26];
         for (int i = 0; i < m; i++) {
             map[s1.charAt(i) - 'a']++;
             curMap[s2.charAt(i) - 'a']++;
         }

         int count = 0;
         for (int j = 0; j < 26; j++) {
             if (map[j] == curMap[j]) {
                 count++;
             }
         }

         if (count == 26) return true;

         for (int i = 1; i < n - m + 1; i++) {
             int head = s2.charAt(i - 1) - 'a';
             int tail = s2.charAt(i + m - 1) - 'a';

             if (curMap[head] == map[head]) {
                 count--;
             }
             curMap[head]--;
             if (curMap[head] == map[head]) {
                 count++;
             }

             if (curMap[tail] == map[tail]) {
                 count--;
             }
             curMap[tail]++;
             if (curMap[tail] == map[tail]) {
                 count++;
             }

             if (count == 26) return true;
         }

         return false;
     }
}
