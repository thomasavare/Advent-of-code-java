import java.util.ArrayList;

public class Node71WithRules {
    ArrayList<Long> value;
    int depth = 0;
    Node71WithRules addChild;
    Node71WithRules multChild;

    public Node71WithRules(Long rootValue) {
        this.value = new ArrayList<>(1);
        this.value.add(rootValue);
        this.depth = 1;
        this.addChild = null;
        this.multChild = null;
    }

    public Node71WithRules(ArrayList<Long> value) {
        this.value = value;
        this.depth = value.size();
        this.addChild = null;
        this.multChild = null;
    }

    public long getDepth() {
        return depth;
    }

    public long getSum() {
        long sum = 0;
        for (int i = 0; i < value.size(); i++) {
            sum += value.get(i);
        }
        return sum;
    }

    public Node71WithRules insertAdd(Long add) {
        ArrayList<Long> newValue = new ArrayList<>(value);
        newValue.add(add);
        Node71WithRules newChild = new Node71WithRules(newValue);
        newChild.depth = depth + 1;
        this.addChild = newChild;
        return newChild;
    }
    public Node71WithRules insertMult(Long mult) {
        ArrayList<Long> newValue = new ArrayList<>(value);
        newValue.set(newValue.size() - 1, newValue.getLast() * mult);
        Node71WithRules newChild = new Node71WithRules(newValue);
        newChild.depth = depth + 1;
        this.multChild = newChild;
        return newChild;
    }

    @Override
    public String toString() {
        return "Node depth: " + depth + ", position: " + value;
    }
}
