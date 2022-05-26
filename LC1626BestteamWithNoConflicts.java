import java.util.Arrays;

public class LC1626BestteamWithNoConflicts {
    public static void main(String[] args) {

    }
    public int bestTeamScore(int[] scores, int[] ages) {

        player[] ary = new player[scores.length];

        Arrays.sort(ary, (a,b)->{
            return a.age - b.age;
        });

        return 0;

    }

    class player{
        int score;
        int age;

        public player(int score, int age){
            this.score = score;
            this.age = age;
        }
    }
}
