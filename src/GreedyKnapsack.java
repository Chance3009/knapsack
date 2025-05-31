public class GreedyKnapsack implements Knapsack {
    private Item[] items;
    private int capacity;
    private boolean[] selected;
    private long executionTime;
    private int totalWorth;
    private int totalWeight;

    public GreedyKnapsack(Item[] items, int capacity) {
        this.items = items.clone();  // Make a copy of the array
        this.capacity = capacity;
        this.selected = new boolean[items.length];
    }

    public void solve() {
        long startTime = System.nanoTime();
        
        // Sort items by worth/weight ratio using selection sort
        for (int i = 0; i < items.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < items.length; j++) {
                if ((double)items[j].worth / items[j].weight >
                    (double)items[maxIndex].worth / items[maxIndex].weight) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                Item temp = items[i];
                items[i] = items[maxIndex];
                items[maxIndex] = temp;
            }
        }

        // Select items
        totalWeight = 0;
        totalWorth = 0;
        for (int i = 0; i < items.length; i++) {
            if (totalWeight + items[i].weight <= capacity) {
                selected[i] = true;
                totalWeight += items[i].weight;
                totalWorth += items[i].worth;
            }
        }

        executionTime = System.nanoTime() - startTime;
    }

    public int getTotalWorth() {
        return totalWorth;
    }

    public int getTotalWeight() {
        return totalWeight;
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
