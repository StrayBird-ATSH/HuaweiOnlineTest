import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(find(in.nextLine(),0,0).getKey());
    }


    static Map.Entry<String,Integer> find(String str, int index, int flag) {
        StringBuilder res = new StringBuilder();
        for (;index<str.length();index++){
            if (Character.isAlphabetic(str.charAt(index)))
                res.append(str.charAt(index));
            else if (str.charAt(index) == ')'){
                break;
            }
            else if (Character.isDigit(str.charAt(index))){
                Map.Entry<String,Integer> t = null;
                t = find(str,index+2, str.charAt(index)-48);
                res.append(t.getKey());
                index = t.getValue();
            }
        }

        String temp = res.toString();
        while (flag>1){
            res.append(temp);
            flag--;
        }
        return new AbstractMap.SimpleEntry<>(res.toString(),index);
    }
}
