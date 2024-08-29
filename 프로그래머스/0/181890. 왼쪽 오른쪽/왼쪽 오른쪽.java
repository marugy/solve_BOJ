class Solution {
    public String[] solution(String[] str_list) {
        for(int i=0; i< str_list.length; i++){
            if(str_list[i].equals("l")){
                String []str = new String[i];
                for(int j=0;j<i;j++){
                    str[j]=str_list[j];
                }
                return str;
            }else if(str_list[i].equals("r")){
                String []str = new String[str_list.length - (i+1)];
                for(int j=i+1;j<str_list.length;j++){
                    str[j-(i+1)]=str_list[j];
                }
                return str;
            }
        }
        return new String[0];
    }
}