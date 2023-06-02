import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FixtureMaker {
    public static void main(String[] args) {
        ArrayList<String> teams = new ArrayList<>();
        ArrayList<String> secondHalf = new ArrayList<>();
        ArrayList<String> firstHalf = new ArrayList<>();
        Random rand = new Random();
        String[] teamList = {"Galatasaray", "Fenerbahçe", "Beşiktaş", "Trabzonspor", "Bursaspor", "Başakşehir"};
        String home, away;
        int weekMatchCount = Math.max((teamList.length / 2), 2);
        int weekCount = teamList.length - 1;
        addTeamstoList(teams, teamList);
        for(int j = 0; j < weekCount ; j++){
            if(teams.size()==0){
                addTeamstoList(teams, teamList);
            }
            for(int i = 0; i < weekMatchCount; i++){
                home = teams.get(rand.nextInt(teams.size()));
                away = teams.get(rand.nextInt(teams.size()));
                while(home.equals(away) || firstHalf.contains(home + " VS " + away) || firstHalf.contains(away + " VS " + home)){
                    home = teams.get(rand.nextInt(teams.size()));
                    away = teams.get(rand.nextInt(teams.size()));
                }
                if(home.equals("BYE")){
                    firstHalf.add(away + " RECEIVE A BYE");
                    secondHalf.add(away + " RECEIVE A BYE");
                    teams.remove(home);
                    teams.remove(away);
                }
                else if(away.equals("BYE")){
                    firstHalf.add(home + " RECEIVE A BYE");
                    secondHalf.add(home + " RECEIVE A BYE");
                    teams.remove(home);
                    teams.remove(away);
                }
                else{
                    firstHalf.add(home + " VS " + away);
                    secondHalf.add(away + " VS " + home);
                    teams.remove(home);
                    teams.remove(away);
                }
            }
        }
        for(int i = 0; i < weekCount; i++){
            System.out.println("Week " + (i + 1));
            for(int j = 0; j < weekMatchCount; j++){
                System.out.println(firstHalf.get((i+j)+i) + " ");
            }
            System.out.println();
        }
        for(int i = 0; i < weekCount; i++){
            System.out.println("Week " + (i + 4));
            for(int j = 0; j < weekMatchCount; j++){
                System.out.println(secondHalf.get((i+j)+i) + " ");
            }
            System.out.println();
        }
    }
    static void addTeamstoList(ArrayList<String> teams, String[] teamList){
        Collections.addAll(teams, teamList);
        if(teams.size() % 2 != 0){
            teams.add("BYE");
        }
    }
}
