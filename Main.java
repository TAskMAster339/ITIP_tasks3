import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // task 1
//        System.out.println(isStrangePair("ratio", "orator"));
//        System.out.println(isStrangePair("sparkling", "groups"));
//        System.out.println(isStrangePair("bush", "hubris"));
//        System.out.println(isStrangePair("", ""));

        // task 2
//        ArrayList<Object[]> list = new ArrayList<Object[]>();
//        list.add(new Object[]{"Laptop", 124200});
//        list.add(new Object[]{"Phone", 51450});
//        list.add(new Object[]{"Headphones", 13800});
//        ArrayList<Object[]> list1 = sale(list, 25);
//        for (var i : list1){
//            System.out.println(Arrays.toString(i));
//        }
        // task 3
//        System.out.println(successShoot(0, 0, 5, 2, 2));
//        System.out.println(successShoot(-2, -3, 4, 5, -6));
        // task 4
//        System.out.println(parityAnalysis(243));
//        System.out.println(parityAnalysis(12));
//        System.out.println((parityAnalysis(3)));
        // task 5
//        System.out.println(rps("rock", "paper"));
//        System.out.println(rps("paper", "rock"));
//        System.out.println(rps("paper", "scissors"));
//        System.out.println(rps("scissors", "scissors"));
//        System.out.println(rps("scissors", "paper"));
        // task 6
//        System.out.println(bugger(39));
//        System.out.println(bugger(999));
//        System.out.println(bugger(4));
        // task 7
//        System.out.println(mostExpensive(new Object[][]{
//                {"Скакалка", 550, 8},
//                {"Шлем", 3750, 4},
//                {"Мяч", 2900, 10}
//                }));
        // task 8
//        System.out.println(longestUnique("abcba"));
//        System.out.println(longestUnique("bbb"));
        // task 9
//        System.out.println(isPrefix("automation", "auto-"));
//        System.out.println(isSuffix("arachnophobia", "-phobia"));
//        System.out.println(isPrefix("retrospect", "sub-"));
//        System.out.println(isSuffix("vocation", "-logy"));
        // task 10
//        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
//        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
//        System.out.println(doesBrickFit(1, 2, 2, 1, 1));

    }
    // task 1
    public static boolean isStrangePair(String str1, String str2){
        if (str1.isEmpty() && str2.isEmpty()) return true;
        if (str1.isEmpty() || str2.isEmpty()) return false;
        return str1.charAt(0) == str2.charAt(str2.length() - 1) && str2.charAt(0) == str1.charAt(str1.length() - 1);
    }
    // task 2
    public static ArrayList<Object[]> sale(ArrayList<Object[]> list, int discount){
        ArrayList<Object[]> res = new ArrayList<>(list.size());
        for (var i : list){
            double newPrice = (Integer)i[1] * (100 - discount) / 100.0;
            if (newPrice < 1) newPrice = 1;
            res.add(new Object[]{i[0],  (int) Math.ceil(newPrice)});
        }
        return res;
    }
    // task 3
    public static boolean successShoot(int x, int y, int r, int m, int n){
        double vectorLength = Math.sqrt(Math.pow((x - m), 2) + Math.pow((y - n), 2));
        return vectorLength < r;
    }
    // task 4
    public static boolean parityAnalysis(int num){
        int sum = 0;
        int numCopy = num;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return numCopy % 2 == sum % 2;
    }
    // task 5
    public static String rps(String p1, String p2){
        if (p1.equals(p2)) return "Tie";
        String[] vars = {"rock", "scissors", "paper", "rock"};
        for (int i = 0; i < vars.length - 1; i++){
            if (p1.equals(vars[i]) && p2.equals(vars[i+1])){
                return "Player 1 wins";
            }
        }
        for (int i = vars.length - 1; i > 1; i--){
            if (p1.equals(vars[i]) && p2.equals(vars[i-1])){
                return "Player 2 wins";
            }
        }
        return null;
    }
    // task 6
    public static int bugger(int num){
        if (num < 10) return 0;
        int newNum = 1;
        while (num > 0){
            newNum *= num % 10;
            num /= 10;
        }
        return bugger(newNum) + 1;
    }
    // task 7
    public static String mostExpensive(Object[][] arr) {
        int max = Integer.MIN_VALUE;
        String maxName = "";
        for (var elem : arr){
            int cost = (Integer) elem[1] * (Integer) elem[2];
            if (cost > max){
                max = cost;
                maxName = (String) elem[0];
            }
        }
        return "Наиб. общ. стоимость у предмета " + maxName + " - " + max;
    }
    // task 8
    public static String longestUnique(String str){
        Set<Character> set = new HashSet<>();
        StringBuilder res = new StringBuilder();
        String ans = "";
        int count = 0;
        for (char c : str.toCharArray()){
            if (!set.contains(c)) {
                count++;
                set.add(c);
                res.append(c);
            }else {
                if (count > ans.length()) {
                    ans = res.toString();
                }
                set.clear();
            }
        }
        return ans;
    }
    // task 9
    public static boolean isPrefix(String str, String prefix){
        prefix = prefix.substring(0, prefix.length() -1);
        return str.startsWith(prefix);
    }
    public static boolean isSuffix(String str, String suffix){
        suffix = suffix.substring(1);
        return str.endsWith(suffix);
    }
    // task 10
    public static boolean doesBrickFit(int a, int b, int c, int w, int h){
        int[] sizes = new int[]{a * b, b * c, a * c};
        for (var i : sizes){
            if (i <= w * h){
                return true;
            }
        }
        return false;
    }
}
