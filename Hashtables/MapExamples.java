import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MapExamples{
    public static <K extends Comparable<K>, V> K maxKey(Map<K,V> map){
        K max = null;
        
        for( K key: map.keySet() ){
            if( max == null || key.compareTo(max) > 0 ){
                max = key;
            }
        }

        return max;
    }

    public static <K> int keyValueEqualCount(Map<K,K> map){
        int count = 0;
        
        for( K key: map.keySet() ){
            K val = map.get(key);

            if( key.equals(val) ){
                count++;
            }
        }

        return count;
    }

    public static <K> int keyValueEqualCount2(Map<K,K> map){
        int count = 0;
        
        for( Map.Entry<K,K> entry: map.entrySet() ){
            if( entry.getKey().equals(entry.getValue()) ){
                count++;
            }
        }

        return count;
    }

    public static Map<String, Integer> wordCount(String filename){
        try{
          BufferedReader in = new BufferedReader(new FileReader(filename));
 
          HashMap<String, Integer> counts = new HashMap<String, Integer>();

          String line;

          while( (line = in.readLine()) != null ){
            String[] words = line.split("\\s+");
            for( String word: words ){
                if( !counts.containsKey(word) ){
                    counts.put(word, 0);
                }

                counts.put(word, counts.get(word) + 1);
            }
          }

          in.close();

          return counts;
        } catch (IOException e){
            return null;
        }
    }

    public static Map<String, Integer> wordCount2(String filename){
        try{
          BufferedReader in = new BufferedReader(new FileReader(filename));
 
          HashMap<String, Integer> counts = new HashMap<String, Integer>();

          String line;

          while( (line = in.readLine()) != null ){
            String[] words = line.split("\\s+");
            for( String word: words ){
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
          }
          
          in.close();

          return counts;
        } catch (IOException e){
            return null;
        }
    }
}
