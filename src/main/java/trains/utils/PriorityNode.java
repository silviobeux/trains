package trains.utils;

public class PriorityNode implements Comparable<PriorityNode> {

    private int index;
    private int priority;

    public PriorityNode(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(PriorityNode o) {
        return Integer.valueOf(priority).compareTo(o.priority);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriorityNode that = (PriorityNode) o;

        if (index != that.index) return false;
        return priority == that.priority;

    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + priority;
        return result;
    }
}

