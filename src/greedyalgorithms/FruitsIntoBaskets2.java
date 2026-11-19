package greedyalgorithms;
/*
You are given two arrays of integers, fruits and baskets, each of length n,
where fruits[i] represents the quantity of the ith type of fruit,
and baskets[j] represents the capacity of the jth basket.

From left to right, place the fruits according to these rules:
    Each fruit type must be placed in the leftmost available basket with
    a capacity greater than or equal to the quantity of that fruit type.
    Each basket can hold only one type of fruit.
    If a fruit type cannot be placed in any basket, it remains unplaced.

Return the number of fruit types that remain unplaced after all possible allocations are made.

Input: fruits = [4,2,5], baskets = [3,5,4]

Output: 1

Explanation:

    fruits[0] = 4 is placed in baskets[1] = 5.
    fruits[1] = 2 is placed in baskets[0] = 3.
    fruits[2] = 5 cannot be placed in baskets[2] = 4.

Since one fruit type remains unplaced, we return 1.

Tip - (fruit type not how many fruits : like 5 is unplaced so its 1 type fruit not 5-4 = 1)
 */
public class FruitsIntoBaskets2 {
    // -------- Better ---------
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            int result = 0;

            for (int i = 0; i < fruits.length; i++) {
                boolean placed = false;

                for (int j = 0; j < baskets.length; j++) {

                    // check if basket is unused AND can fit fruit
                    if (baskets[j] != -1 && baskets[j] >= fruits[i]) {
                        baskets[j] = -1; // mark as used
                        placed = true;
                        break; // move to next fruit
                    }
                }

                if (!placed) {
                    result++; // fruit couldn't be placed
                }
            }

            return result;
        }

        // ---------- Optimal Solution ------------
}
