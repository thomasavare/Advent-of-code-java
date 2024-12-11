public class Node72 {
    long value;
    int depth;
    Node72 add, mult, merge;

    public Node72(long value) {
        this.value = value;
        this.add = this.mult = null;
        this.depth = 1;
    }

    public Node72 insertAdd(long add) {
        Node72 newadd = new Node72(this.value + add);
        this.add = newadd;
        newadd.depth = this.depth + 1;
        return newadd;
    }

    public Node72 insertMult(long mult) {
        Node72 newMult = new Node72(this.value * mult);
        this.mult = newMult;
        newMult.depth = this.depth + 1;
        return newMult;
    }

    public Node72 insertMerge(long merge) {
        String str = Long.toString(value);
        str = str + Long.toString(merge);
        Node72 newMerge = new Node72(Long.parseLong(str));
        this.merge = newMerge;
        newMerge.depth = this.depth + 1;
        return newMerge;
    }


    public String toString() {
        return "Node depth: " + depth + ", value: " + value;
    }
}
