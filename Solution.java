import java.util.*;

public class Solution {
    // Mode: (a, b)
    public void solve(int[] nums) {
        int counter = 0;
        int x = nums.length * (nums.length - 1) / 2;  //組合數計算。
        int[] addSum = new int[x]; // x == addSum.length 陣列長度為組合數。
        HashMap<Integer, String> result = new HashMap<Integer, String>(); //存放數組（a,b)
        Set<Integer> setA = new HashSet<>(); //用於比對有無重覆的和。
        Set<Integer> setB = new TreeSet<>(); //用於存放「有重覆的和」，選擇TreeSet因內容將自動小到大排序。
        int y = 0;

        System.out.println("組合數 pairs＝ "+ x);
        /*組合所有和，和放到addSum[] 陣列，數組放到result HashMap，addSum[y]中的y會對應result HashMap的key */
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j< nums.length; j++ ) {
                int tempSum;
                tempSum= nums[i] + nums[j];
                addSum[y] = tempSum;
                String text = "("+String.valueOf(nums[i])+","+String.valueOf(nums[j])+")";
                result.put(y,text);
                y+=1;
            }
        }
        /* addSum 陣列中如果數字和還沒有在setA中即放入setA，如果已有即為重覆放到setB，
        setB最後不會重覆因為set特性內容唯一，放入數字即使無大小順序仍會由小到大排因為TreeSet特性。 */
        for (int i=0; i < addSum.length; i++) {
            if (!setA.contains(addSum[i])) {
                setA.add(addSum[i]);
            } else if (setA.contains(addSum[i])) {
                setB.add(addSum[i]);
            }
        }
        //當setB是空的時，為沒有相同和的數字，需輸出一行 "NO"
        if (setB.isEmpty()) {
            System.out.println("No"); // 沒有相同的和時。
        }
        Iterator<Integer> iterator=setB.iterator();
            while (iterator.hasNext()) {
                int z = iterator.next();
                System.out.printf(z+"==>");
                for (int i=0; i<addSum.length; i++) {
                    if (z==addSum[i]) {
                        System.out.printf(result.get(i));
                    }
                }
                System.out.println("");
        }
    }

    public static void main(String[] args)
    {
        Solution ex1 = new Solution();
        ex1.solve(new int[]{1,2,3,5,6,7});
        System.out.println("=============");

        ex1.solve(new int[]{1,3,8,9,12});
        System.out.println("=============");

        ex1.solve(new int[]{22,33,44,55,66});
        System.out.println("=============");
    }

}

        /*   運行結果 ：
        組合數 pairs＝ 15
        7==>(1,6)(2,5)
        8==>(1,7)(2,6)(3,5)
        9==>(2,7)(3,6)
        =============
        組合數 pairs＝ 10
        No
        =============
        組合數 pairs＝ 10
        77==>(22,55)(33,44)
        88==>(22,66)(33,55)
        99==>(33,66)(44,55)
        =============
        */


