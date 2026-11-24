package binarysearch.medium;

public class KokoEatingBananas {
    // ---------- Optimal Solution ----------
    public int minEatingSpeed(int[] piles, int h) {
        int minEat = 1;
        int maxEat = 0;
        int result = Integer.MAX_VALUE;

        // find the maximum number of bananas in the piles
        for(int num : piles){
            maxEat = Math.max(num, maxEat);
        }

        // binary search to find the minimum eating speed (starting from 1 to maxEat)
        while(minEat <= maxEat){
            int mid = minEat + (maxEat - minEat) / 2;

            long hrs = 0;

            // calculate the total hours needed to eat all bananas at the current speed (mid)
            for(int num : piles){
                int hours = num / mid;

                // if there are remaining bananas after dividing by mid, it means Koko needs an extra hour to finish that pile (that's why we add 1 to hours)
                if(num % mid != 0){
                    hours++;
                }

                hrs += hours;
            }

            // if the total hours needed is less than or equal to h, update the result and search for a smaller eating speed
            if(hrs <= h){
                result = Math.min(result, mid);
                maxEat = mid - 1;
            } 
            // can't finish all bananas in h hours, need to increase the eating speed
            else{
                minEat = mid + 1;
            }
        }

        return result;
    }

    // ------------------- Brute Force Solution -------------------
    public int minEatingSpeedBrute(int[] piles, int h) {
        int eatCount = 1;

        while (true) {
            int hrs = 0;

            for (int i = 0; i < piles.length; i++) {
                // calculate the number of hours needed to eat the current pile at the current eating speed (eatCount)
                int md = piles[i] % eatCount;
                int total = piles[i] / eatCount;

                int ans;

                // if there are remaining bananas after dividing by eatCount, it means Koko needs an extra hour to finish that pile (that's why we add 1 to total)
                if (md == 0) {
                    ans = total;
                } else {
                    ans = total + 1;
                }

                hrs += ans;
                
                // if hrs exceeds break the loop as we don't need to calculate further
                if (hrs > h) {
                    break;
                }
            }

            // if the total hours needed is less than or equal to h, return the current eating speed (eatCount)
            if (hrs <= h) {
                return eatCount;
            }

            eatCount++;
        }
    }
}
