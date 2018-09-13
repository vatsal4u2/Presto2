import java.util.*;

public class Main {

    private static final String socksString = "1/blue/right,2/blue/right,3/red/right,4/blue/left,5/purple/left,6/red/left,7/green/left,8/red/left,9/blue/left";
    static HashMap<String, String> map;
    private static String[] commaSeparated;

    public static void main(String[] args) {
        map = new HashMap<>();
        commaSeparated = socksString.split(",");

        for (String aCommaSeparated : commaSeparated) {
            String[] tem = aCommaSeparated.split("/");
            map.put(tem[0], tem[1] + "-" + tem[2]);
        }
        final ArrayList<Integer> positionFound = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            int pos;
            int matchPos;
            for (int i = 0; i < commaSeparated.length; i++) {
                String[] temArray = commaSeparated[i].split("/");
                String[] localArray = entry.getValue().split("-");
                if (temArray[1].equals(localArray[0]) && !temArray[2].equals(localArray[1])) {
                    if (!positionFound.contains(Integer.parseInt(entry.getKey())) && !positionFound.contains(Integer.parseInt(temArray[0]))) {
                        pos = Integer.parseInt(entry.getKey());
                        positionFound.add(pos);
                        matchPos = Integer.parseInt(temArray[0]);
                        System.out.println(pos + " " + matchPos);
                        positionFound.add(matchPos);
                    }
                }
            }
        }
    }

}
