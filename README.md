# CSC4202 Assignment 2: Real-Life Carry-On Knapsack

---

## Problem Overview

This assignment simulates a real-world decision problem: a digital nomad must select a subset of useful items to pack in their carry-on bag, without exceeding a weight limit of **4000g**. The objective is to **maximize the total worth** of selected items using two algorithms:

- **Greedy Approach**  
- **Dynamic Programming (0/1 Knapsack)**

---

## Results Summary

| Metric           | Greedy Algorithm | Dynamic Programming |
|------------------|------------------|---------------------|
| **Total Weight** | 3977g            | 3995g               |
| **Total Worth**  | 721              | 722                 |
| **Execution Time** | 35,700 ns       | 4,093,100 ns        |

> *Greedy algorithm is faster but not guaranteed to produce the optimal solution. Dynamic programming yields a slightly higher worth with higher computational cost.*

