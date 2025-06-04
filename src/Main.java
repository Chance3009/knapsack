public class Main {
    public static void main(String[] args) {
        Item[] items = new Item[] {
            new Item("Lenovo X1 Carbon (5th Gen)", 40, 112),
            new Item("10 pairs thongs", 39, 80),
            new Item("5 Underarmour Strappy", 38, 305),
            new Item("1 pair Uniqlo leggings", 37, 185),
            new Item("2 Lululemon Cool Racerback", 36, 174),
            new Item("Chargers and cables in Mini Bomber Travel Kit", 35, 665),
            new Item("The Roost Stand", 34, 170),
            new Item("ThinkPad Compact Bluetooth Keyboard with trackpoint", 33, 460),
            new Item("Seagate Backup PlusSlim", 32, 159),
            new Item("1 pair black denim shorts", 31, 197),
            new Item("2 pairs Nike Pro shorts", 30, 112),
            new Item("2 pairs Lululemon shorts", 29, 184),
            new Item("Isabella T-Strap Croc sandals", 28, 200),
            new Item("2 Underarmour HeatGear CoolSwitch tank tops", 27, 138),
            new Item("5 pairs black socks", 26, 95),
            new Item("2 pairs Injinji Women's Run Lightweight No-Show Toe Socks", 25, 54),
            new Item("1 fancy tank top", 24, 71),
            new Item("1 light and stretchylong-sleeve shirt (Gap Fit)", 23, 147),
            new Item("Uniqlo Ultralight Down insulating jacket", 22, 235),
            new Item("Patagonia Torrentshell", 21, 301),
            new Item("Lightweight Merino Wool Buff", 20, 50),
            new Item("1 LBD (H&M)", 19, 174),
            new Item("Field Notes Pitch Black Memo Book Dot-Graph", 18, 68),
            new Item("Innergie PocketCell USB-C 6000mAh power bank", 17, 14),
            new Item("Important papers", 16, 228),
            new Item("Deuter First Aid Kit Active", 15, 144),
            new Item("Stanley Classic Vacuum Camp Mug 16oz", 14, 454),
            new Item("JBL Reflect Mini Bluetooth Sport Headphones", 13, 14),
            new Item("Anker SoundCore nano Bluetooth Speaker", 12, 89),
            new Item("Oakley Latch Sunglasses", 11, 30),
            new Item("Ray Ban Wayfarer Classic", 10, 45),
            new Item("Zip bag of toiletries", 9, 236),
            new Item("Petzl E+LITE Emergency Headlamp", 8, 27),
            new Item("Laptop Bag", 7, 20),
            new Item("Peak Design Cuff Camera Wrist Strap", 6, 26),
            new Item("Travelon Micro Scale", 5, 125),
            new Item("BlitzWolf Bluetooth Tripod/Monopod", 4, 150),
            new Item("Humangear GoBites Duo", 3, 22),
            new Item("Touchlight", 2, 10),
            new Item("Vapur Bottle 1L", 1, 41)
        };

        int capacity = 7000; // Switch 4000 & 7000 for comparison 

        System.out.println("Dynamic Programming Solution:");
        DPKnapsack dp = new DPKnapsack(items, capacity);
        dp.solve();
        printResults(dp);

        System.out.println("\nGreedy Solution:");
        GreedyKnapsack greedy = new GreedyKnapsack(items, capacity);
        greedy.solve();
        printResults(greedy);

        System.out.println("\nComparison Table:");
        System.out.println("----------------------------------------");
        System.out.println("                   Greedy    Dynamic Programming");
        System.out.println("Total weight:      " + greedy.getTotalWeight() + "g       " + dp.getTotalWeight() + "g");
        System.out.println("Total worth:       " + greedy.getTotalWorth() + "         " + dp.getTotalWorth());
        System.out.println("Speed (ns):        " + greedy.getExecutionTime() + "      " + dp.getExecutionTime());
        System.out.println("----------------------------------------");
    }

    private static void printResults(Knapsack knapsack) {
        System.out.println("Total weight: " + knapsack.getTotalWeight() + "g");
        System.out.println("Total worth: " + knapsack.getTotalWorth());
        System.out.println("Selected items:");
        for (Item item : knapsack.getSelectedItems()) {
            System.out.println("- " + item);
        }
    }
}