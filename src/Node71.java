public class Node71 {
    long value;
    int depth;
    Node71 add, mult;

    public Node71(long value) {
        this.value = value;
        this.add = this.mult = null;
        this.depth = 1;
    }

    public Node71 insertAdd(long add) {
        Node71 newadd = new Node71(this.value + add);
        this.add = newadd;
        newadd.depth = this.depth + 1;
        return newadd;
    }
    public Node71 insertMult(long mult) {
        Node71 newMult = new Node71(this.value * mult);
        this.mult = newMult;
        newMult.depth = this.depth + 1;
        return newMult;
    }

    public String toString() {
        return "Node depth: " + depth + ", value: " + value;
    }
}
