package solution;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 */
public class  N042_TrappingRainWater {
    public int trap(int[] height) {
        int[] container = new int[height.length];
        int max = 0,res = 0;

        for (int i = 0; i < height.length; i++) {
            max = Math.max(max,height[i]);
            container[i] = max;
        }

        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            container[i] = Math.min(max,container[i]);
            max = Math.max(max,height[i]);

            res += container[i] - height[i] > 0 ? container[i] - height[i] : 0;
        }

        return res;
    }

    public void test(){

    }
}
