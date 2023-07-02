import java.util.*;
public class LargestAreaHistogram {
    public static int maxAreaInHistogram(int[]arr){
        Stack<Integer> s = new Stack<>();
        int max_area=0;
        int i=0;
        while( i<arr.length){
            int currentBuiliding = arr[i];
            if(s.isEmpty() || currentBuiliding>=arr[s.peek()]){
                s.push(i);
                i++;
            
            }else{
                int previousBar = s.pop();
                int height = arr[previousBar];
                int width;
                if(s.isEmpty()){
                    width=i;
                }else{
                    width=i-s.peek()-1;
                }
                int area = height*width;
                max_area = Math.max(area,max_area);
            }
        }
        while(!s.isEmpty()){
            int previousbar = s.pop();
            int height = arr[previousbar];
            int width;
            if(s.isEmpty()){
                width=i;
            }else{
                width=i-s.peek()-1;
            }
            int area = height*width;
            max_area = Math.max(area,max_area);
        }
        return max_area;
    }
}
