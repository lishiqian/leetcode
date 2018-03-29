package solution;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique
 */

/**
 * 题目大意：
 * 在环形路线上一共有N个加油站，每个加油站的存储容量为gas[i].你有一辆汽油无限存储的汽车，如果你从加油站i到下一站（i+1），你需要
 *
 * 消耗汽油cost[i]  你从某一个加油站开始你的旅程，但是你的汽车里没有任何的汽油。
 *
 * 如果你能沿着环形路线旅游一遍，返回你开始旅游的加油站的下标否则返回-1
 *
 * 注意：
 *
 * 解决方案唯一
 */
public class N134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = -1;
        int sum = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if(sum < 0){
                start = i;
                sum = 0;
            }
        }

        return total >= 0 ? start+1:-1;
    }
}
