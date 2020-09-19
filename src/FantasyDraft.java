
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class FantasyDraft {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTeams = sc.nextInt();
		int teamSize = sc.nextInt();
		String[][] prefs = new String[numTeams][];
		
		for (int i = 0; i < numTeams; i++) {
			int preferenceSize = sc.nextInt();
			String[] preferences = new String[preferenceSize];
			for (int j = 0; j < preferenceSize; j++) {
				preferences[j] = sc.next();
			}
			prefs[i] = preferences;
		}
		
		int numPlayers = sc.nextInt();
		String[] players = new String[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			players[i] = sc.next();
		}
		
		int[] indices = new int[numTeams];
		String[][] teams = new String[numTeams][teamSize];
		HashSet<String> picked = new HashSet<String>();
		int listIndex = 0;
		
		for (int i = 0; i < numTeams*teamSize; i++) {
			int teamIndex = i % numTeams;
			
			// 1. Check if there are still players on the preference list (if index is less than number of players on the preference list)
			// 2. If there are players in the preference list still, then check if that player is available.
			// 3. Otherwise, increment the index and go back to step 1.
			// 4. If there are no players on the preference list (if the index exceeds the number of players on the preference list)
			// 5. Then, check the list of players by using listIndex.
			// 6. If that player is not available, then increment listIndex until you are able to successfully add a player
			
			while (indices[teamIndex] < prefs[teamIndex].length && picked.contains(prefs[teamIndex][indices[teamIndex]])) {
				indices[teamIndex]++;
			}
			if (indices[teamIndex] >= prefs[teamIndex].length) {
				// ran out of preferences; must resort to player list
				while (picked.contains(players[listIndex])) {
					listIndex++;
				}
				teams[teamIndex][i/numTeams] = players[listIndex];
				picked.add(players[listIndex]);
				listIndex++;
			} else {
				// try to add the player from preference list
				teams[teamIndex][i/numTeams] = prefs[teamIndex][indices[teamIndex]];
				picked.add(prefs[teamIndex][indices[teamIndex]]);
				indices[teamIndex]++;
			}
		}
		for (int i = 0; i < numTeams; i++) {
			for (int j = 0; j < teamSize; j++) {
				System.out.print(teams[i][j] + " ");
			}
			System.out.println();
		}
	}

}
