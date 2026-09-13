class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(char ch: s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            maxHeap.add(new int[]{entry.getKey() - 'a', entry.getValue()});
        }

        int[] prev = null;
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty() || prev != null){
            if(maxHeap.isEmpty() && prev != null){
                return "";
            }
            
            int[] curr = maxHeap.poll();
            char ch = (char)(curr[0] + 'a');
            sb.append(ch);
            if(prev != null){
                maxHeap.add(prev);
                prev = null;
            }

            if(curr[1] - 1 > 0){
                prev = new int[]{curr[0], curr[1] - 1};
            }
        }
        return sb.toString();
    }
}