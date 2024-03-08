class Solution {
    public int solution(String my_string, String is_suffix) {
        if(my_string.length() >= is_suffix.length() && my_string.substring(my_string.length()-is_suffix.length(), my_string.length()).equals(is_suffix)) return 1;
        return 0;
    }
}