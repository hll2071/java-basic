import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] miss = new int[]{0,0};
        ArrayList<String> goalkeeper;
        ArrayList<String> attacker1;
        ArrayList<String> attacker2;

        System.out.print("attacker1이 찰 공을 입력해주세요 : ");
        attacker1 = Arrays.stream(sc.nextLine().split(","))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.print("attacker2가 찰 공을 입력해주세요 : ");
        attacker2 = Arrays.stream(sc.nextLine().split(","))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.print("goalkeeper가 막을 공을 입력해주세요 : ");
        goalkeeper = Arrays.stream(sc.nextLine().split(","))
                .collect(Collectors.toCollection(ArrayList::new));

        for(String goal : goalkeeper) {
            if(attacker1.contains(goal)) miss[0] +=1;
            if(attacker2.contains(goal)) miss[1] +=1;
        }
        if(miss[0]<miss[1]) System.out.println("attacker1 님이 승리하셨습니다.");
        else if (miss[0]>miss[1]) System.out.println("attacker2 님이 승리하셨습니다.");
        else System.out.println("무승부입니다.");
    }
}