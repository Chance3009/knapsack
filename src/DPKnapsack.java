import java.util.Arrays;

public class DPKnapsack implements Knapsack {
    private Item[] items;
    private int capacity;
    private int[][] dp;
    private boolean[] selected;
    private long executionTime;

    public DPKnapsack(Item[] items, int capacity) {
        this.items = items.clone();  // Make a copy of the array
        this.capacity = capacity;
        this.dp = new int[items.length + 1][capacity + 1];
        this.selected = new boolean[items.length];
    }

    public void solve() {
        long startTime = System.nanoTime();
        
        // Initialize first row with zeros
        for (int j = 0; j <= capacity; j++) {
            dp[0][j] = 0;
        }
        
        // Fill the dp table
        for (int i = 1; i <= items.length; i++) {
            Item item = items[i-1];
            for (int j = 0; j <= capacity; j++) {
                // By default, inherit previous state
                dp[i][j] = dp[i-1][j];
                
                // Try to include current item if it fits
                if (j >= item.weight) {
                    int withItem = item.worth + dp[i-1][j - item.weight];
                    if (withItem > dp[i][j]) {
                        dp[i][j] = withItem;
                    }
                }
            }
        }

        // Trace back
        Arrays.fill(selected, false);
        int j = capacity;
        int remainingCapacity = capacity;
        int remainingProfit = dp[items.length][j];
        
        for (int i = items.length; i > 0 && remainingCapacity > 0 && remainingProfit > 0; i--) {
            Item item = items[i-1];
            // Check if this item was included by comparing with previous state
            if (remainingCapacity >= item.weight && dp[i][remainingCapacity] != dp[i-1][remainingCapacity]) {
                selected[i-1] = true;
                remainingProfit -= item.worth;
                remainingCapacity -= item.weight;
            }
        }

        executionTime = System.nanoTime() - startTime;
    }

    public int getTotalWorth() {
        return dp[items.length][capacity];
    }

    public int getTotalWeight() {
        int weight = 0;
        for (int i = 0; i < items.length; i++) {
            if (selected[i]) {
                weight += items[i].weight;
            }
        }
        return weight;
    }

    public Item[] getSelectedItems() {
        int count = 0;
        for (boolean s : selected) {
            if (s) count++;
        }
        
        Item[] selectedItems = new Item[count];
        int index = 0;
        for (int i = 0; i < items.length; i++) {
            if (selected[i]) {
                selectedItems[index++] = items[i];
            }
        }
        return selectedItems;
    }

    public long getExecutionTime() {
        return executionTime;
    }
}
