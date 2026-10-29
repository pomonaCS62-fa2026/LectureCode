import java.util.*;

public class LambdaExpressions{
    public static void mystery(){
        Integer[] vals = {1, 2, 3, 4, 5, 6, 7};
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(vals));

        for(int num: nums){
            if( num % 2 == 0 ){
                System.out.println(num);
            }
        }
    }

    public static void mystery2(){
        Integer[] vals = {1, 2, 3, 4, 5, 6, 7};
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(vals));

        nums.forEach((num) -> {
            if(num % 2 == 0){
                System.out.println(num);
            }
        });
    }

    public static void mystery3(){
        Map<String, Integer> groceries = new HashMap<String, Integer>();
        groceries.put("bananas", 6);
        groceries.put("apples", 5);
        groceries.put("ice cream", 1);

        for(String food: groceries.keySet()){
            System.out.println("buy " + groceries.get(food) + " " + food);
        }
    }

    public static void mystery4(){
        Map<String, Integer> groceries = new HashMap<String, Integer>();
        groceries.put("bananas", 6);
        groceries.put("apples", 5);
        groceries.put("ice cream", 1);

        groceries.forEach((food, num) -> System.out.println("buy " + num + " " + food));
    }

    public static void mystery5(){
        Integer[] vals = {1, 2, 3, 4, 5, 6, 7};
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(vals));

        nums.sort((num1, num2) -> -Integer.compare(num1, num2));
        System.out.println(nums);
    }

    public static Comparator<Integer> absComparator(){
        return (num1, num2) -> Integer.compare(Math.abs(num1), Math.abs(num2));
    }

    public static void main(String[] args) {
        mystery5();
    }
}