import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SharedMemory {

    private List<Token> tokensList;


    public SharedMemory(int numberOfTokens) {
        this.tokensList = new ArrayList<>();
        for (int i = 0; i <= numberOfTokens; i++) {
            tokensList.add(new Token(i));
        }
        Collections.shuffle(tokensList);
    }

    public synchronized List<Token> extractTokens(int howMany) {
        Random random = new Random();
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokensList.isEmpty()) {
                break;
            }
            extracted.add(tokensList.get(random.nextInt(tokensList.size())));
        }
        return extracted;
    }


    public List<Token> getTokensList() {
        return tokensList;
    }

    public void setTokensList(List<Token> tokensList) {
        this.tokensList = tokensList;
    }
}
