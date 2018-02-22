package solution;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 */

/**
 * 题目大意:
 * 给你一个非负整数代表n个垂直线段，索引i代表x坐标，ai代表高度，寻找其中两条线段与x组成一个水桶，求能装最多水的面积。
 */
public class N011_ContainerWithMostWater {

    /**
     * 把所有的两条线段组成的面积都算了一遍，超时
     * @param height
     * @return
     */
//    public int maxArea(int[] height) {
//        int maxArea = 0;
//        for (int i = 0; i < height.length-1; i++) {
//            for (int j = i+1; j < height.length; j++) {
//                int area = Math.min(height[i],height[j]) * (j-i);
//                maxArea = Math.max(maxArea,area);
//            }
//        }
//        return maxArea;
//    }


    //两边逼近
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0,right = height.length-1;
        while (left < right){
            int area = Math.min(height[left],height[right]) * (right - left);
            maxArea = Math.max(maxArea,area);
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxArea;
    }
}
