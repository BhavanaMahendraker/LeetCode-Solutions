class Solution {
    public int maxTurbulenceSize(int[] arr) {
        char prev = 0;
        int left = 0;
        int result = 1;
        for (int right = 1; right < arr.length; ++right) {
            if (arr[right - 1] < arr[right] && prev != '<') {
                prev = '<';
                result = Math.max(result, right - left + 1);
            } else if (arr[right - 1] > arr[right] && prev != '>') {
                prev = '>';
                result = Math.max(result, right - left + 1);
            } else {
                prev = 0;
                right -= arr[right - 1] == arr[right] ? 0 : 1;
                left = right;
            }
        }
        return result;
    }
}