class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        PriorityQueue<Character> maxFreqHeap = new PriorityQueue<>((a,b) -> freqMap.get(b) - freqMap.get(a));
        
        for(char ch: s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        for(char key: freqMap.keySet()){
            maxFreqHeap.add(key);
        }
        
        StringBuilder sb = new StringBuilder();
        while(maxFreqHeap.size() >= 2){
            char ch1 = maxFreqHeap.poll();
            char ch2 = maxFreqHeap.poll();
            
            sb.append(ch1);
            sb.append(ch2);
            
            freqMap.put(ch1, freqMap.get(ch1) - 1);
            freqMap.put(ch2, freqMap.get(ch2) - 1);
            
            if(freqMap.get(ch1) > 0) maxFreqHeap.add(ch1);
            if(freqMap.get(ch2) > 0) maxFreqHeap.add(ch2);
        }
        
        if(!maxFreqHeap.isEmpty()){
            char ch = maxFreqHeap.poll();
            if(freqMap.get(ch) > 1) return "";
            sb.append(ch);            
        }
        
        return sb.toString();
    }
}