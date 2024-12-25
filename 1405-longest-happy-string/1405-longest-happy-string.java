class Solution {
    public String longestDiverseString(int a, int b, int c) {
        HashMap<Character, Integer> freq = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((x,y) -> freq.get(y) - freq.get(x));
        
        freq.put('a', a);
        freq.put('b', b);
        freq.put('c', c);
        
        for(char ch: freq.keySet()){
            if(freq.get(ch) > 0){
                maxHeap.add(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!maxHeap.isEmpty()){
            char ch1 = maxHeap.poll();
            
            if(sb.length() >= 2 && sb.charAt(sb.length() - 1) == ch1 && sb.charAt(sb.length() - 2) == ch1){
                
                if(maxHeap.isEmpty()){
                    return sb.toString();
                }
                
                char ch2 = maxHeap.poll();
                
                sb.append(ch2);
                freq.put(ch2, freq.get(ch2) - 1);
                if(freq.get(ch2) > 0){
                    maxHeap.add(ch2);
                }
                
                maxHeap.add(ch1);
                
            } else{
                sb.append(ch1);
                freq.put(ch1, freq.get(ch1) - 1);
                if(freq.get(ch1) > 0){
                    maxHeap.add(ch1);
                }
            }
            
        }
        
        return sb.toString();
    }
}