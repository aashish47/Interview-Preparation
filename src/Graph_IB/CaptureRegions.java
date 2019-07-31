package Graph_IB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaptureRegions {

    public static void mark(int i, int j, ArrayList<List<Character>> a){

        if(i + 1 < a.size()){
            if(a.get(i + 1).get(j) == 'O'){
                a.get(i + 1).set(j, '1');
                mark(i+1, j,a);
            }
        }
        if(j + 1 < a.get(0).size()){
            if(a.get(i).get(j + 1 ) == 'O'){
                a.get(i).set(j + 1, '1');
                mark(i, j+ 1,a);
            }
        }
        if(i - 1 >= 0){
            if(a.get(i - 1).get(j) == 'O'){
                a.get(i - 1).set(j, '1');
                mark(i-1, j,a);
            }
        }
        if(j - 1 >= 0){
            if(a.get(i).get(j - 1) == 'O'){
                a.get(i).set(j - 1, '1');
                mark(i, j - 1,a);
            }
        }
    }

    public static void solve(ArrayList<List<Character>> a) {
        for(int i = 0; i < a.size(); i++){
            if(a.get(i).get(0) == 'O'){
                a.get(i).set(0, '1');
                mark(i , 0, a);
            }
            if(a.get(i).get(a.get(0).size() - 1) == 'O'){
                a.get(i).set(a.get(0).size() - 1, '1');
                mark(i , a.get(0).size() - 1, a);
            }
        }
        for(int i = 0; i < a.get(0).size(); i++){
            if(a.get(0).get(i) == 'O'){
                a.get(0).set(i, '1');
                mark(0 , i, a);
            }
            if(a.get(a.size() - 1).get(i) == 'O'){
                a.get(a.size() - 1).set(i, '1');
                mark(a.size() - 1 , i, a);
            }
        }


        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < a.get(0).size(); j++){
                if(a.get(i).get(j) == 'O'){
                    a.get(i).set(j, 'X');
                }
            }
        }

        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < a.get(0).size(); j++){
                if(a.get(i).get(j) == '1'){
                    a.get(i).set(j, 'O');
                }
            }
        }
    }
    public static void main(String[] args) {

        ArrayList<List<Character>> arr1 = new ArrayList<>();
        arr1.add(Arrays.asList('X','O','X','X','X','X','O','O','X','X'));
        arr1.add(Arrays.asList('X','O','O','O','O','X','O','O','X','X'));
        arr1.add(Arrays.asList('O','X','X','O','O','X','X','X','O','O'));
        arr1.add(Arrays.asList('O','X','O','X','O','O','O','X','X','O'));
        arr1.add(Arrays.asList('O','X','O','O','X','X','O','O','X','X'));
        arr1.add(Arrays.asList('O','X','X','X','O','X','X','O','X','O'));
        arr1.add(Arrays.asList('O','O','X','X','X','X','O','X','O','O'));
        solve(arr1);
        for(int i = 0 ; i < arr1.size(); i++){
            for(int j = 0; j < arr1.get(0).size(); j++){
                System.out.print(arr1.get(i).get(j));
            }
            System.out.println();
        }
    }
}
