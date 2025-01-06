package leetcode;

public class CanPlaceFlowers {

    // 605. Can Place Flowers
    // Easy

    // You have a long flowerbed in which some of the plots are planted, and some
    // are not. However, flowers cannot be planted in adjacent plots.

    // Given an integer array flowerbed containing 0's and 1's, where 0 means empty
    // and 1 means not empty, and an integer n, return true if n new flowers can be
    // planted in the flowerbed without violating the no-adjacent-flowers rule and
    // false otherwise.

    // Example 1:

    // Input: flowerbed = [1,0,0,0,1], n = 1
    // Output: true

    // Example 2:

    // Input: flowerbed = [1,0,0,0,1], n = 2
    // Output: false

    public static boolean solution(int[] flowerbed, int n) {

        int bedLength = flowerbed.length;

        if(bedLength==0 && n>=1) return false;
        else if(bedLength==0 && n==0) return true;

        if(bedLength==1 &&flowerbed[0]==1 && n>=1) return false; 
        if(bedLength==1&& flowerbed[0]==0 && n==1) return true;


        for (int i = 0; i < flowerbed.length; i++) {
            System.out.println("i: "+i+" n: "+n);
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n -= 1;
                }
            } else if (i == bedLength - 1) {
                if (flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    n -= 1;
                }
            } else {
                if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n -= 1;
                }
            }
        }
        return n == 0;

    }

    public static void main(String[] args) {

        int[] flowerbed = { 1,0,0,0,1,0,0 };
        boolean result = solution(flowerbed, 2);
        System.out.println(result);

    }
}
