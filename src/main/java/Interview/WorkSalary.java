package Interview;

import org.junit.Test;

import java.util.Scanner;

public class WorkSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] counts = sc.nextLine().split(" ");
        int workCount = Integer.parseInt(counts[0]);
        int friendCount = Integer.parseInt(counts[1]);


        int[] ablitys = new int[workCount];
        int[] salarys = new int[workCount];

        for (int i = 0; i < workCount; i++) {
            String[] abilityAndSalary = sc.nextLine().split(" ");
            ablitys[i] = Integer.parseInt(abilityAndSalary[0]);
            salarys[i] = Integer.parseInt(abilityAndSalary[1]);
        }

        String[] abilityStr = sc.nextLine().split(" ");
        for (int i = 0; i < friendCount; i++) {
            int ability = Integer.parseInt(abilityStr[i]);
            int maxSalary = 0;
            for (int j = 0; j < ablitys.length; j++) {
                if(ability >= ablitys[i]){
                    maxSalary = Math.max(maxSalary,salarys[i]);
                }
            }
            System.out.println(maxSalary);
        }

    }

}
