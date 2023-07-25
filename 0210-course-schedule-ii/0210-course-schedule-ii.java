class Solution {
    int WHITE = 1;
    int GREY = 2;
    int BLACK = 3;
    boolean cycleDetected = false;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> visitingPoint = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> adjlist = new HashMap<>();
        
        for(int i=0; i<numCourses; i++){
            visitingPoint.put(i, WHITE);
        }
        
        for(int[] prereq : prerequisites){
            adjlist.putIfAbsent(prereq[1], new ArrayList<>());
            adjlist.get(prereq[1]).add(prereq[0]);
        }
        
        for(int i=0; i<numCourses; i++){
            if(visitingPoint.get(i) == WHITE){
                dfs(i, visitingPoint, adjlist, stack);
                if(cycleDetected == true)
                    break;
            }
        }
        if(cycleDetected == true)
            return new int[]{};
        int i =0;
        while(!stack.isEmpty()){
            res[i++] = stack.pop();
        }
        
        return res;
    }
    
    public void dfs(int i, HashMap<Integer, Integer> visitingPoint, HashMap<Integer, ArrayList<Integer>> adjlist, Stack<Integer> stack){
                
        if(cycleDetected == true){
            return;
        }
        
        visitingPoint.put(i, GREY);
        
        for(int child: adjlist.getOrDefault(i, new ArrayList<Integer>())){
            if(visitingPoint.get(child) == BLACK){
                continue;
            }
            if(visitingPoint.get(child) == GREY){
                cycleDetected = true;
            }
            if(visitingPoint.get(child) == WHITE){
                dfs(child, visitingPoint, adjlist, stack);
            }
        }
            
        visitingPoint.put(i, BLACK);
        stack.push(i);
    }
}