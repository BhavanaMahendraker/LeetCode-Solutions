class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');
        
        for(char ch: s.toCharArray()){
            if(bracketsMap.containsKey(ch)){
                if(stack.isEmpty() || stack.peek() != bracketsMap.get(ch))
                    return false;
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        
        return stack.isEmpty();
    }
}

/*

()[]{}
 i

stack =>



map => 
) -> (
] -> [
} -> {

if(map contains Key s(i))
    if(stack peek != key's value)
        return false;
    poll;
else
    stack.push(i)

return stack.empty()
    

*/