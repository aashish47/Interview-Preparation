package Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class JustifiedText {
    public static  ArrayList<String> justifiedText(ArrayList<String> s, int len){
        int currlen;
        int prevlen;
        int space;
        int spaceSize;
        int unevenSpaces;
        int unevenSpacesSize;
        int startIndex;
        String result;
        ArrayList<String> ans = new ArrayList<>();
        
        if(s.size() == 0){
            return ans;
        }
        
        for(int i = 0; i < s.size(); i++){
            prevlen = 0;
            space = 0;
            result = "";
            startIndex = i;
            if(i == s.size() - 1){
                String result1 = "";
                result = s.get(startIndex);
                result1 = result;
                for(int k = 0; k < len - result.length(); k++){
                    result1 += " ";
                }
                ans.add(result1);
                return ans;
            }
            for(currlen = 0; currlen <= len && i < s.size(); i++){
                currlen += s.get(i).length();
                if(currlen <= len){
                    prevlen = currlen;
                    currlen++;
                    space++;
                }
                else {
                    break;
                }
            }
            space--;
            if(space != 0){
                spaceSize = (len - prevlen + space) / space;
                unevenSpaces = (len - prevlen + space) % space;
                unevenSpacesSize = spaceSize + 1;
            }
            else{
                spaceSize = len - prevlen;
                unevenSpaces = 0;
                unevenSpacesSize = 0;
            }
            if(i == s.size()){
                spaceSize = 1;
                unevenSpaces = 0;
            }

            for(int j = startIndex; j < i; j++) {
                result += s.get(j);
                if (result.length() < len) {
                    if (unevenSpaces != 0) {
                        for(int k = 0; k < unevenSpacesSize; k++){
                            result += " ";
                        }
                        unevenSpaces--;
                    } else {
                        for(int k = 0; k < spaceSize; k++){
                            result += " ";
                        }
                    }
                }
            }
            ans.add(result);
            i--;
        }

        result = ans.get(ans.size() - 1);
        String result1 = result;
        for(int k = 0; k < len - result.length(); k++){
            result1 += " ";
        }
        ans.set(ans.size() - 1,result1);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>(Arrays.asList("glu", "muskzjyen", "ahxkp", "t", "djmgzzyh", "jzudvh", "raji", "vmipiz", "sg", "rv", "mekoexzfmq", "fsrihvdnt", "yvnppem", "gidia", "fxjlzekp", "uvdaj", "ua", "pzagn", "bjffryz", "nkdd", "osrownxj", "fvluvpdj", "kkrpr", "khp", "eef", "aogrl", "gqfwfnaen", "qhujt", "vabjsmj", "ji", "f", "opihimudj", "awi", "jyjlyfavbg", "tqxupaaknt", "dvqxay", "ny", "ezxsvmqk", "ncsckq", "nzlce", "cxzdirg", "dnmaxql", "bhrgyuyc", "qtqt", "yka", "wkjriv", "xyfoxfcqzb", "fttsfs", "m"));
        System.out.print(justifiedText(s, 144));

    }
}
