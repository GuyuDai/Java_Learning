class StringAlgoExer {

    public static String mytrim(String s){
        int start = 0;
        int end = s.length()-1;
        char[] ss = s.toCharArray();

        while(ss[start] == ' '){
            start += 1;
        }
        while(ss[end] == ' '){
            end -= 1;
        }

        String result = s.substring(start, end+1);

        return result;
    }    

    public static String myreserve(String s, int start, int end){
        String result = s.substring(0, start);

        for(int i = end; i >= start; i--){
            result += s.charAt(i);
        }

        result += s.substring(end+1);

        return result;
    }

    public static int count(String s, String index){
        int count = 0;
        Boolean flag = true;
        int i = s.indexOf(index);
        while(flag){
            if(i != -1){
                count++;
                s = s.substring(i+1);
                i = s.indexOf(index);
            }else{
                flag = false;
            }
        }

        return count;
    }

    public static String getMaxSub(String s1, String s2){
        String result = null;
        label:for(int length = s2.length(); length > 0; length--){
            for(int i = 0, j = i + length - 1; j < s2.length(); i++, j++){
                String index = s2.substring(i, j);
                if(s1.contains(index)){
                    result = index;
                    break label;
                }
            }
        }
        return result;
    }


    public static void main(String[] args){
        String s1 = "abcwerthelloyuiodef";
        String s2 = "cvhellobnm";
        String result = getMaxSub(s1, s2);
        System.out.println(result);
    }
}
