import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class Attacker {
    String name;
    String[] ball = new String[5];
}
class Goalkeeper {
    String[] keep = new String[4];
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] miss = new int[2];
        for(int i = 0; i < miss.length; i++) {
            miss[i] = 0;
        }
        String[] balls = new String[2];
        String keepball;
        Attacker[] attackers = new Attacker[2];
        for(int i = 0; i < attackers.length; i++) {
            attackers[i] = new Attacker();
        }
        ArrayList<Goalkeeper> goalkeeperlist = new ArrayList<Goalkeeper>();
        goalkeeperlist.add(new Goalkeeper());
        ArrayList<Attacker> attackerlist = Arrays.stream(attackers).collect(Collectors.toCollection(ArrayList::new));

        for(int i=0; i< attackerlist.size(); i++) {
             System.out.print("공격수 이름을 입력해주세요 : ");
             attackerlist.get(i).name = sc.nextLine();
             System.out.print("공을 입력해주세요 : ");
             balls[i] = sc.nextLine();
             attackerlist.get(i).ball = balls[i].split(",");
        }
        System.out.print("골키퍼의 공을 입력해주세요 : ");
        keepball = sc.nextLine();

        goalkeeperlist.get(0).keep = keepball.split(",");
        for(int i=0; i<attackerlist.size(); i++) {
            for(String shoot : attackerlist.get(i).ball) {
                for(String goal : goalkeeperlist.get(0).keep) {
                    if(shoot.contains(goal)) miss[i] +=1;
                }
            }
        }
        if(miss[0]>miss[1]) System.out.println(attackerlist.get(1).name + "님이 승리하셨습니다.");
        else if (miss[0]<miss[1]) System.out.println(attackerlist.get(0).name + "님이 승리하셨습니다.");
        else System.out.println("무승부입니다.");
    }
}