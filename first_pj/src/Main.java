import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
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
        int[] s = new int[2];
        String[] balls = new String[2];
        String keepball = new String();
        Goalkeeper goalkeeper = new Goalkeeper();
        Attacker[] attackers = new Attacker[2];
        ArrayList<Goalkeeper> goalkeeperlist = new ArrayList<Goalkeeper>();
        //goalkeeperlist.add(goalkeeper);
        //ArrayList<Attacker> attackerlist = Arrays.stream(attackers).collect(Collectors.toCollection(ArrayList::new));

        for(int i=0; i<2; i++) {
             attackers[i] = new Attacker();
             System.out.print("공격수 이름을 입력해주세요 : ");
             attackers[i].name = sc.nextLine();
            System.out.print("공을 입력해주세요 : ");
             balls[i] = sc.nextLine();
             attackers[i].ball = balls[i].split(",");
             //attackerlist.add(attackers[i]);
        }
        System.out.print("골키퍼의 공을 입력해주세요 : ");
        keepball = sc.nextLine();

        goalkeeper.keep = keepball.split(",");
        for(int i=0; i<2; i++) {
            for(String shoot : attackers[i].ball) {
                for(String goal : goalkeeper.keep) {
                    if(shoot.contains(goal)) s[i] +=1;
                }
            }
        }
        if(s[0]>s[1]) System.out.println(attackers[0].name + "님이 승리하셨습니다.");
        else if (s[0]<s[1]) System.out.println(attackers[1].name + "님이 승리하셨습니다.");
        else System.out.println("무승부입니다.");
    }
}