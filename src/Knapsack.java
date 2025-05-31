public interface Knapsack {
    void solve();
    int getTotalWorth();
    int getTotalWeight();
    Item[] getSelectedItems();
    long getExecutionTime();
} 