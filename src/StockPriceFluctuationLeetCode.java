import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class StockPriceFluctuationLeetCode {

    static class StockPrice {

        int lastTime, curPrice;
        PriorityQueue<Pair<Integer, Integer>> maxHeap;
        PriorityQueue<Pair<Integer, Integer>> minHeap;
        HashMap<Integer, Integer> timestampToPrice = new HashMap<>();

        public StockPrice() {
            lastTime = 0;
            curPrice = 0;
            //better way to write comparators
            minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
            maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        }

        public void update(int timestamp, int price) {
            if (timestamp >= lastTime) {
                lastTime = timestamp;
                curPrice = price;
            }
            timestampToPrice.put(timestamp, price);
            maxHeap.add(new Pair(timestamp, price));
            minHeap.add(new Pair(timestamp, price));
        }
        public int current() {
            return curPrice;
        }


        public int maximum() {
            if (maxHeap.size() == 0) return 0;
            Pair top = maxHeap.peek();
            while (timestampToPrice.get(top.getKey()) != (int) top.getValue()) {
                maxHeap.poll();
                top = maxHeap.peek();
            }
            return (int) top.getValue();
        }

        public int minimum() {
            if (minHeap.size() == 0) return 0;
            Pair top = minHeap.peek();
            while (timestampToPrice.get(top.getKey()) != (int) top.getValue()) {
                minHeap.poll();
                top = minHeap.peek();
            }
            return (int) top.getValue();
        }
    }

    public static void main(String[] args) {
        StockPrice obj = new StockPrice();
        obj.update(1, 10);
        System.out.println(obj.current() + " " + obj.maximum() + " " + obj.minimum());
        obj.update(2, 10);
        System.out.println(obj.current() + " " + obj.maximum() + " " + obj.minimum());
        obj.update(1, 3);
        System.out.println(obj.current() + " " + obj.maximum() + " " + obj.minimum());
        obj.update(2, 2);
        System.out.println(obj.current() + " " + obj.maximum() + " " + obj.minimum());
    }
}
