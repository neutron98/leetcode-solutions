# leetcode-solutions 总结



**II. Two Pointers**

Easy
- [167. Two Sum II - Input array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) : 当输入是sorted的时候，可以用two pointers
- [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/): l指向的是最后一个non-duplicate，r是当前元素。相似题：[283. Move Zeroes](https://leetcode.com/problems/move-zeroes/)
- [977. Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/): 相向双指针，值从高到低。和merge sort很像。

Medium:
- [15. 3Sum](https://leetcode.com/problems/3sum/): 经典题。关键点是化为two sum，并且内外循环都要remove duplicates
- [16. 3Sum Closest](https://leetcode.com/problems/3sum-closest/): 在three sum的基础之上，计算差值并且维护最小差值。这道题因为没有重复元素，不用去重。
- [259. 3Sum Smaller](https://leetcode.com/problems/3sum-smaller/): 看似简单，但是要注意的是在移动左指针之前，count不能每次只+1，而是加r - l。不然会错过[左指针，右指针减少的solution]
- [713. Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/): Two pointers和Sliding Window结合。注意l的边界。
- [75. Sort Colors](https://leetcode.com/problems/sort-colors/): 这题有三个指针，关键是要弄清楚curr指针不能随便increase。
- [18. 4Sum](https://leetcode.com/problems/4sum/): 和3Sum差不多
- [844. Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/): 反着走。并且每个String都有交替指针。
- [581. Shortest Unsorted Continuous Subarray](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/): 画图很有用。

**III. Fast & Slow Pointers**

Easy
- [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
- [202. Happy Number](https://leetcode.com/problems/happy-number/)
- [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)
- [234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/): 结合了find middle of linkedlist和reverse linked list

Medium
- [142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/): 两次用fast & slow pointers
- [143. Reorder List](https://leetcode.com/problems/reorder-list/): pointers的部分不难，只是找middle。难点在于交换。
- [457. Circular Array Loop](https://leetcode.com/problems/circular-array-loop/): 还是移一步或者两步的问题，只不过找next的过程用了个helper function。

**IV. Merge Intervals**



**V. Cyclic Sort**

- [Grokking. Find The Missing Number](https://www.educative.io/courses/grokking-the-coding-interview/JPnp17NYXE9): 这道题的range是0~n-1。第一次比较：【应该在的地方没有这个数】当前在i,nums[i]是'2'，应该放在index '2'。但是如果'2'和index'2'的这个数不想等，就要交换。第二次比较：【这个地方没有应该在的数】，也就是从0到n-1，这个数是不是和index不相等。不相等的话返回index。
- [448. Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/): 同上
- [287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/): 这道题的range是1~n。用两次loop的话，和上面差不多。如果只用一次loop，思考方式会有一点点不一样。第一次比较：因为有duplicates，第一次不能直接看这个数是不是在right place。因为可能right place已经有一个相同的数了。那么先看这个数是不是【出现在了不应该在的地方】，也就是比较数和index+1，如果是，那看【应该在的地方】有没有这个数。如果还没有这个数，就把它换过去，如果有这个数了，就说明坑位被占了，发现了duplicate。
- [41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/)
- [1539. Kth Missing Positive Number](https://leetcode.com/problems/kth-missing-positive-number/): 需要处理remaining numbers


**VI. Tree BFS**

**VII. Tree DFS**

**VIII. Subsets**
- [78. Subsets](https://leetcode.com/problems/subsets/): 三种方法：(1) BFS，每次在已有的结果上加一个元素。 (2) DFS + Backtracking (3) Bit Manipulation
- [90. Subsets II](https://leetcode.com/problems/subsets-ii/)： 有重复元素的情况，一定要记得先sort。
- [784. Letter Case Permutation](https://leetcode.com/problems/letter-case-permutation/): 和78的第一种方法很像。
- [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/): 两种做法。都需要leftCount和rightCount。如果用BFS，需要有一个custom class。也可以用DFS。
