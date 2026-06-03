import java.util.PriorityQueue;

public class FindMedianFromDataStreamLeetCode {

    public static class MedianFinder {

        PriorityQueue<Integer> smallQueue;
        PriorityQueue<Integer> largeQueue;

        public MedianFinder() {
            smallQueue = new PriorityQueue<>((a, b) -> b - a);
            largeQueue = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (smallQueue.size() == 0 && largeQueue.size() == 0) {
                smallQueue.add(num);
                return;
            }
            double med = findMedian();
            if (num > med) {
                largeQueue.add(num);
            } else {
                smallQueue.add(num);
            }
            if (largeQueue.size() - smallQueue.size() == 2) {
                smallQueue.add(largeQueue.poll());
            }
            else if (smallQueue.size() - largeQueue.size() == 2) {
                largeQueue.add(smallQueue.poll());
            }
        }

        public double findMedian() {
            int total = largeQueue.size() + smallQueue.size();
            if (total % 2 == 0) {
                return (largeQueue.peek() + smallQueue.peek()) / 2.0;
            } else if (largeQueue.size() > smallQueue.size()) {
                return largeQueue.peek();
            } else {
                return smallQueue.peek();
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

}
