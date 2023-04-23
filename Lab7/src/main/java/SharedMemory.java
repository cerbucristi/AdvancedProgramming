import java.util.*;

public class SharedMemory {

    private Queue<Token> tokensList;


    public SharedMemory(int numberOfTokens) {
        this.tokensList = new LinkedList<>();
        for (int i = 0; i <= numberOfTokens; i++) {
            tokensList.offer(new Token(i));
        }
        Collections.shuffle((List<?>) tokensList);
    }

    public synchronized List<Token> extractTokens(int howMany) {
        Random random = new Random();
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokensList.isEmpty()) {
                break;
            }
            extracted.add(tokensList.poll());
        }
        return extracted;
    }


    public Queue<Token> getTokensList() {
        return tokensList;
    }

    public void setTokensList(Queue<Token> tokensList) {
        this.tokensList = tokensList;
    }
}
