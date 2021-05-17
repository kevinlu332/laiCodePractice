import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int index = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // insert k elements first
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            if (maxHeap.isEmpty() || num < maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            // balance
            if (maxHeap.size() - minHeap.size() == 2) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() - maxHeap.size() == 1) {
                maxHeap.offer(minHeap.poll());
            }
        }

        if (k % 2 == 0)
            result[index++] = (double) (maxHeap.peek() + (double) (minHeap.peek() - maxHeap.peek()) / 2);
        else {
            result[index++] = maxHeap.peek();
        }

        int slow = 0;
        int balance = 0; // both heaps are balanced or nearly balanced
        Map<Integer, Integer> invalidNums = new HashMap<>();

        for (int fast = k; fast < nums.length; fast++) {
            // maxHeap, minHeap peek elements are both valid
            // add fast
            int num = nums[fast];
            if (num < maxHeap.peek()) {
                balance++;
                maxHeap.offer(num);
            } else {
                balance--;
                minHeap.offer(num);
            }

            // remove slow
            int outNum = nums[slow];
            invalidNums.put(outNum, invalidNums.getOrDefault(outNum, 0) + 1);
            slow++;

            if (maxHeap.contains(outNum))
                balance--;
            else
                balance++;

            // lazy deletion
            while (invalidNums.containsKey(maxHeap.peek())) {
                if (invalidNums.get(maxHeap.peek()) == 1)
                    invalidNums.remove(maxHeap.peek());
                else
                    invalidNums.put(maxHeap.peek(), invalidNums.get(maxHeap.peek() - 1));
                maxHeap.poll();
            }

            while (invalidNums.containsKey(minHeap.peek())) {
                if (invalidNums.get(minHeap.peek()) == 1)
                    invalidNums.remove(minHeap.peek());
                else
                    invalidNums.put(minHeap.peek(), invalidNums.get(minHeap.peek() - 1));
                minHeap.poll();
            }

            // balance
            if (balance < 0)
                maxHeap.offer(minHeap.poll());
            else if (balance > 0)
                minHeap.offer(maxHeap.poll());
            balance = 0;

            //////////////////////////////////
            // lazy deletion
            while (invalidNums.containsKey(maxHeap.peek())) {
                if (invalidNums.get(maxHeap.peek()) == 1)
                    invalidNums.remove(maxHeap.peek());
                else
                    invalidNums.put(maxHeap.peek(), invalidNums.get(maxHeap.peek() - 1));
                maxHeap.poll();
            }

            while (invalidNums.containsKey(minHeap.peek())) {
                if (invalidNums.get(minHeap.peek()) == 1)
                    invalidNums.remove(minHeap.peek());
                else
                    invalidNums.put(minHeap.peek(), invalidNums.get(minHeap.peek() - 1));
                minHeap.poll();
            }
            /////////////////////////////////////////
            // get median
            if (k % 2 == 0) {
                System.out.println(maxHeap.peek() + " " + minHeap.peek());
                result[index++] = (double) (maxHeap.peek() + (double) (minHeap.peek() - maxHeap.peek()) / 2);
            } else {
                result[index++] = maxHeap.peek();
            }
        }
        return result;
    }

//    public static void main(String[] args){
//        Solution sol = new Solution();
//        int[] arr = new  int[]{-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
//                sol.medianSlidingWindow(arr, 2);
//    }
}
