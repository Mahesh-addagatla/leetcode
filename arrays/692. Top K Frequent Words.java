
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>(
            (a, b) -> freqMap.get(a).equals(freqMap.get(b))
                ? b.compareTo(a) // Alphabetical if frequencies equal
                : freqMap.get(a) - freqMap.get(b) // Min-heap: least frequent at top
        );

        for (String word : freqMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        Collections.reverse(result); // Because we want most frequent first
        return result;
    }
}
