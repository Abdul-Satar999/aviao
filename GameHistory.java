import java.util.ArrayList;

public class GameHistory {
    private static ArrayList<GameResult> history = new ArrayList<>();

    public static void addResult(GameResult result) {
        history.add(result);
    }

    public static ArrayList<GameResult> getHistory() {
        return history;
    }
}
