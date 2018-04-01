package solution;

import common.Point;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * /*
 *  A line is determined by two factors,say y=ax+b
 *
 *  If two points(x1,y1) (x2,y2) are on the same line(Of course).
 *  Consider the gap between two points.
 *  We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled since b is a constant
 *  If a third point (x3,y3) are on the same line. So we must have y3=ax3+b
 *  Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
 *  Since a is a rational, there exists y0 and x0, y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
 *  So we can use y0&x0 to track a line;
 */
public class N149_MaxPointsonALine {
//    public int maxPoints(Point[] points) {
//        if(points.length <= 1) return points.length;
//        int result = 0;
//        for (int i = 0; i < points.length; i++) {
//            HashMap<String,Integer> map = new HashMap<String, Integer>();//每一次循环都要重新创建一个map,避免重复计算 平行线等情况
//            int dup = 1;//重复
//            int vertical = 0;
//            for (int j = 0; j < points.length; j++) {
//                if(i == j) continue;
//                int x = points[i].x - points[j].x;
//                int y = points[i].y - points[j].y;
//                if(x == 0 && y == 0){
//                    //计数重复的点
//                    dup++;
//                }else if(x == 0){
//                    //垂直线段上的点
//                    vertical++;
//                } else{
//                   boolean sign = (y / x) > 0 ? true:false;
//                    x = Math.abs(x);
//                    y = Math.abs(y);
//                   int gcd = generateGCD(x,y);
//                   if(gcd != 0){
//                       x /= gcd;
//                       y /= gcd;
//                   }
//
//                   //利用x 与 y 求出唯一的key
//                    // 不要算除法 精度不准确
//                   String key = (sign ? "": "-")  + x + "#" + y;
//                   if(map.containsKey(key)){
//                       map.put(key,map.get(key) + 1);
//                   }else{
//                       map.put(key,1);
//                   }
//                }
//            }
//
//            int max = vertical;
//            for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                max = Math.max(max,entry.getValue());
//            }
//            result = Math.max(result,max + dup);
//        }
//        return result;
//    }
//
//    //求最大公约数
//    private int generateGCD(int a,int b){
//        if (b==0) return a;
//        else return generateGCD(b,a%b);
//    }


    public int maxPoints(Point[] points) {
        //int cx = Integer.MAX_VALUE, cy = 0;
        int len = points.length;
        HashMap<String,Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<len;i++){
            map.clear();
            int dup = 1;
            int max = 0;
            int x0 = points[i].x;
            int y0 = points[i].y;
            for(int j=i+1;j<len;j++){
                int x1 = points[j].x;
                int y1 = points[j].y;
                if(x0==x1 && y1==y0){
                    dup ++;
                }else{
                    int x = x1-x0;
                    int y = y1-y0;
                    int gcd = gcd(x,y);
                    x = x/gcd;
                    y = y/gcd;
                    String key = x+"/"+y;
                    map.put(key,map.getOrDefault(key,0)+1);
                    max = Math.max(max,map.get(key));
                }
            }
            res = Math.max(res,max+dup);
        }
        return res;
    }
    public int gcd(int x, int y){
        if(y==0) return x;
        return gcd(y,x%y);
    }

    @Test
    public void test(){
        Point[] points = new Point[3];
        points[0] = new Point(0,0);
        points[1] = new Point(94911151,94911150);
        points[2] = new Point(94911152,94911151);

        System.out.println(maxPoints(points));
    }
}
