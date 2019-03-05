package HashMap;

import java.util.HashMap;
import java.util.Map;

public class Iterator {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("Name","Aashish");
        map.put("LastName","Agarwal");
        map.put("Age","22");
        map.put("College","BPIT");

        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }
}
