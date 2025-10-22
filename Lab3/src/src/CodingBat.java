package src;

public class CodingBat {
    public static String firstHalf(String str) {
        char[] a= str.toCharArray();
        int l=str.length()/2;
        char result[] =  new char [l];

        for (int i=0; i<l; i++){
            result[i]=a[i];
        }
        String resultstr = new String(result);
        return resultstr;
    }
    public static boolean sleepIn(boolean weekday, boolean vacation) {
        if(!weekday || vacation){
            return true;
        }
        else return false;
    }
    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if ((!aSmile && !bSmile ) || (aSmile && bSmile)){
            return true;
        }
        else return false;
    }

    public static boolean firstLast6(int[] nums) {
        if(nums.length>=1){
            if (nums[0]==6){return true;}
            else if (nums[nums.length-1]==6){return true;}
            else return false;
        }
        else return false;
    }
    public static void main(String[] args){
        System.out.println(firstLast6(new int[]{1,2,3,4,5,6,7,8,9,10}));
        System.out.println(firstHalf("ABCDSEasdf"));
        System.out.println(monkeyTrouble(true,true));
        System.out.println(sleepIn(true,true));



    }

}
