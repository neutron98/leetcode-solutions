# leetcode-solutions 总结
**1. Sliding Window**

算sum类型：
- [Maximum Sum Subarray of Size K](https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP)
- [Smallest Subarray with a given sum](https://www.educative.io/courses/grokking-the-coding-interview/7XMlMEQPnnQ)

用map存char frequency：

- [340. Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)：Grokking的Fruits into Baskets是同一题
- [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/):和340很像，只是shrink的条件写法不一样
- [1004. Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)：类似上题，但是不用map

- [395. Longest Substring with At Least K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/)
- [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)



- [567. Permutation in String](https://leetcode.com/problems/permutation-in-string/)
- [76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)：这道题更新长度是在while循环里面

**2. Two Pointers**

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
- 

**3. Fast & Slow Pointers**

Easy
- [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
- [202. Happy Number](https://leetcode.com/problems/happy-number/)
- [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)
- [234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/): 结合了find middle of linkedlist和reverse linked list

Medium
- [142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/): 两次用fast & slow pointers
- [143. Reorder List](https://leetcode.com/problems/reorder-list/): pointers的部分不难，只是找middle。难点在于交换。
- [457. Circular Array Loop](https://leetcode.com/problems/circular-array-loop/): 还是移一步或者两步的问题，只不过找next的过程用了个helper function。

**4. Merge Intervals**

- [46. Merge Intervals](https://leetcode.com/problems/merge-intervals/)
- [47. Insert Interval](https://leetcode.com/problems/insert-interval/)
- [986. Interval List Intersections](https://leetcode.com/problems/interval-list-intersections/)
- [252. Meeting Rooms](https://leetcode.com/problems/meeting-rooms/)
- [253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)
- [(Grokking)Maximum CPU Load](https://www.educative.io/courses/grokking-the-coding-interview/xVlyyv3rR93): 类似上题，但是要用grokking的解法。
- [759. Employee Free Time](https://leetcode.com/problems/employee-free-time/): 类似merge intervals。先flatten整个list。triky的地方是不要管它是哪个employee。不同的是这里只要virtual merge。

**5. Cyclic Sort**
- [Grokking. Cyclic Sort](https://www.educative.io/courses/grokking-the-coding-interview/B8qXVqVwDKY)
- [Grokking. Find The Missing Number](https://www.educative.io/courses/grokking-the-coding-interview/JPnp17NYXE9): 这道题的range是0~n-1。第一次比较：【应该在的地方没有这个数】当前在i,nums[i]是'2'，应该放在index '2'。但是如果'2'和index'2'的这个数不想等，就要交换。第二次比较：【这个地方没有应该在的数】，也就是从0到n-1，这个数是不是和index不相等。不相等的话返回index。
- [448. Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/): 同上
- [287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/): 这道题的range是1~n。用两次loop的话，和上面差不多。如果只用一次loop，思考方式会有一点点不一样。第一次比较：因为有duplicates，第一次不能直接看这个数是不是在right place。因为可能right place已经有一个相同的数了。那么先看这个数是不是【出现在了不应该在的地方】，也就是比较数和index+1，如果是，那看【应该在的地方】有没有这个数。如果还没有这个数，就把它换过去，如果有这个数了，就说明坑位被占了，发现了duplicate。
- [41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/)
- [1539. Kth Missing Positive Number](https://leetcode.com/problems/kth-missing-positive-number/): 需要处理remaining numbers

**6. LinkedList**
- [92. Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)
- [25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)

**7. BFS**
- [286. Walls and Gates](https://leetcode.com/problems/walls-and-gates/)：通过一次性加入gates来优化
- [1197. Minimum Knight Moves](https://leetcode.com/problems/minimum-knight-moves/)：用相对坐标限制棋盘大小


**8. DFS**
- [490. The Maze](https://leetcode.com/problems/the-maze/):沿着四个方向走到底，再对四个方向dfs
- [694. Number of Distinct Islands](https://leetcode.com/problems/number-of-distinct-islands/)：用相对坐标建立形状的String
- [332. Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/): post-order dfs
- [399. Evaluate Division](https://leetcode.com/problems/evaluate-division/)：(1)双层map。  (2) visited set要每次外层call dfs的时候都新建一个  (3)eval2也要!=-1，即判断中间点到target是否可达

**9. Two Heaps**
- [295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)
- [480. Sliding Window Median](https://leetcode.com/problems/sliding-window-median/): sliding window 和 295的结合版
- [502. IPO](https://leetcode.com/problems/ipo/): 贪心算法
- [(Grokking) Next Interval/ 436. Find Right Interval](https://leetcode.com/problems/find-right-interval/):还没做


**10. Subsets**

- [78. Subsets](https://leetcode.com/problems/subsets/): 三种方法：(1) BFS，每次在已有的结果上加一个元素。 (2) DFS + Backtracking (3) Bit Manipulation
- [90. Subsets II](https://leetcode.com/problems/subsets-ii/)： 有重复元素的情况，一定要记得先sort。
- [784. Letter Case Permutation](https://leetcode.com/problems/letter-case-permutation/): 和78的第一种方法很像。
- [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/): 两种做法。都需要leftCount和rightCount。如果用BFS，需要有一个custom class。也可以用DFS。
- [320. Generalized Abbreviation](https://leetcode.com/problems/generalized-abbreviation/): 两种做法。和上题类似需要一个custom class。两个重点：（1）在长度没达到时，count不具体化。（2）backtracking解法中，使用提前记录StringBuilder的长度，最后再setLength的方法来还原状态。
- [241. Different Ways to Add Parentheses](https://leetcode.com/problems/different-ways-to-add-parentheses/): 分治法。recursion + memorization
- [(Grokking)Structurally Unique Binary Search Trees](https://www.educative.io/courses/grokking-the-coding-interview/3j9V2QL3Ky9): 类似上题。上题是把每一个operator作为分界线，这题是把每一个[start,end] 区间的值作为根节点。
- [96. Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/)

**11. Binary Search**
- [34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/):这道题要用九章模板
- [744. Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/):左开右闭模板 
- [(Grokking) Search Bitonic Array](https://www.educative.io/courses/grokking-the-coding-interview/7n3BlOvqW0r):这题没法像leetcode 33那样分类。需要两次binary search。
- [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
- [50. Pow(x, n)](https://leetcode.com/problems/powx-n/)
- [69. Sqrt(x)](https://leetcode.com/problems/sqrtx/)
- [74. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)

**12. Bit Operation**

- [136. Single Number](https://leetcode.com/problems/single-number/): 核心在于 a XOR a = 0。 所以a XOR b XOR a = b。
- [260. Single Number III](https://leetcode.com/problems/single-number-iii/)：结果有两个数。利用不同的bit来区分这两个数。



**13. K-way merge**

- [23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/): minHeap
- [Kth Smallest Number in M Sorted Lists](https://www.educative.io/courses/grokking-the-coding-interview/myAqDMyRXn3): 边merge边记录index。重点在于这里的merge是virtual merge，用node的arrayIndex和elementIndex在list中找值。
- [632. Smallest Range Covering Elements from K Lists](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/): 类似上题，加上贪心，并且记录每次插入的最大元素。
- [373. Find K Pairs with Smallest Sums](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/): 有点像滑动窗口和632的结合。窗口没到size的时候一直加。到了之后replace

**14. Backtracking**
- [79. Word Search](https://leetcode.com/problems/word-search/): 时间空间复杂度分析
- [212. Word Search II](https://leetcode.com/problems/word-search-ii/)
- [207. Course Schedule](https://leetcode.com/problems/course-schedule/)：需要会两种方法

**15. Graph**
DFS:
- [1466. Reorder Routes to Make All Paths Lead to the City Zero](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/)：时空复杂度怎么分析？
- Time Complexity: O(E+V). It would take us |E| steps to build a graph in the first step.
For dfs, we need to visit every child. It takes O(|V|). Since we are not backtracking, we do not need to do O(|V|^2)
- Space Complexity: O(E+V). It takes O(2 * E + V) to store the connections, and O(V) to store the boolean[] visited. Calling stack will be O(V) in worst case. So total is O(2 * E + 3 * V) = O(E + V)


Topological Sort:
- [207. Course Schedule](https://leetcode.com/problems/course-schedule/)：需要会两种方法

**16. Tree**

(1) Traverse and Iterator
- [105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
- [106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/): 注意这道题和上道题的不同，因为postIndex是减小的，左右根在遍历array的时候实际上是根右左，应该先root.right再root.left。
- [173. Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/)
- [987.Vertical Order Traversal of a Binary Tree](https://leetcode.com/problems/binary-tree-vertical-order-traversal/)：这题其实不难，考验的是基本功。有趣的是可以用global的minColumn和maxColumn稍微优化。另外注意看清楚规则，按照值排序的时候要写comparator，按照顺序排序的时候（[314题](https://leetcode.com/problems/binary-tree-vertical-order-traversal/))其实并不用额外排序。时间复杂度的计算可以复习一下。


(2)Tree BFS的应用：
- [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
- [103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/tag/tree/)
- [226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)
- [662. Maximum Width of Binary Tree](https://leetcode.com/problems/maximum-width-of-binary-tree/)
- [199. Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)

(3)递归
- [543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)
- [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
- [572. Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/)：注意时空复杂度分析
- [968. Binary Tree Cameras](https://leetcode.com/problems/binary-tree-cameras/)：enum很有意思

(4)BST:
- [Implement Binary Search Tree](基础模板/BST/BST.java)
- [426. Convert Binary Search Tree to Sorted Doubly Linked List](https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/)：对于inorder的事情，只要无脑先helper(node.left)，再helper(node.right），中间做一些正事即可
- [449. Serialize and Deserialize BST](https://leetcode.com/problems/serialize-and-deserialize-bst/):和validate那道题的共同点是利用了max和min


(5)Serialize and Deserialize
- [449. Serialize and Deserialize BST](https://leetcode.com/problems/serialize-and-deserialize-bst/)，[297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)：这两道题的写法非常相似，serialize一模一样。唯一的不同是在deserialize的时候，对于什么时候return null。Binary Tree直接判断字符串是不是null；BST里面在serialize的时候没有加入null，所以可以利用BST的性质，传入max和min来判断。注意queue都写成String类型，因为在Binary Tree里面有Null.


(6)使用parent和left, right的index性质：
- [662. Maximum Width of Binary Tree](https://leetcode.com/problems/maximum-width-of-binary-tree/)
- [297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)的非递归写法

(7)LCA问题：
- [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/):不要把left和root.left搞混！
- [1644. Lowest Common Ancestor of a Binary Tree II](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/)

(8)其他：
- [222. Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)：最优解是Tree+两次binary search。这题很神奇。


**17. Trie**

考点：

(1) Trie直接实现(20分钟内写完！)

- [208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/):Time:平均O(l)，最坏O(高度）。 Space:最坏O(n*l^2)。因为如果每个字母，每个前缀都不一样，总共有n*l个字母，每个字母最多有l个children。所以是n*l*l = O(n*l^2)

(2) 利用Trie前缀特性解题

- [211. Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/): Trie + DFS

(3) 矩阵类里面，字符串一个一个字符，深度优先遍历的问题
- [212. Word Search II](https://leetcode.com/problems/word-search-ii/): 时间：O(sum(l)) + O(m*n*4^l)。空间O(sum(l))。

**18. Array**

- [289. Game of Life](https://leetcode.com/problems/game-of-life/):位运算省空间
- [73. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/):对第一行和第一列作projection
- [31. Next Permutation](https://leetcode.com/problems/next-permutation/):先从后往前找下降，再swap，再reverse后面
- [611. Valid Triangle Number](https://leetcode.com/problems/valid-triangle-number/)：通过控制k的循环，不让它go backward，将O(n^3)->O(n^2)
- [581. Shortest Unsorted Continuous Subarray](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/)：找到unsorted的l和r，再找到窗口内的min和max，然后向两端扩展
- [665. Non-decreasing Array](https://leetcode.com/problems/non-decreasing-array/)：背下来
- 
**19. Prefix Sum**

- [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)：直接滑动窗口就行
- [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)：类似two sum的rolling prefix sum。这题可以从brute force写起，然后写三种解法，better brute force的O(n^2)+O(1), prefix sum的O(n^2)+O(n), 以及rolling prefix sum。
- [325. Maximum Size Subarray Sum Equals k](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/)：和上题类似用一个map。注意index更新条件。
- [862. Shortest Subarray with Sum at Least K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/):这题很取巧，prefix sum数组+deque


**20. String**

- [7. Reverse Integer](https://leetcode.com/problems/reverse-integer/):回顾一下overflow的判断条件
- [8. String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/)：回顾一下overflow的判断条件
- [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)：把key处理成"#1#2#3"这种格式很取巧
- [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/submissions/)：和[132. Palindrome Partitioning II](https://leetcode.com/problems/palindrome-partitioning-ii/)很像

**21. DP**
- [518. Coin Change 2](https://leetcode.com/problems/coin-change-2/)：注意循环顺序，避免重复
- [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/):follow up:打印path
- [64. Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)：dp能work是因为只能向下或者向右
- [91. Decode Ways](https://leetcode.com/problems/decode-ways/):数组开n也可以，但是最好开n+1
- [132. Palindrome Partitioning II](https://leetcode.com/problems/palindrome-partitioning/):区间型dp
- [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)：直接expand around center
- [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)：要能一步步推导
- [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)：和上题一样



**Stream类型问题**

- [702. Search in a Sorted Array of Unknown Size](https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/)：end每次


**数据量太大怎么办？**

分成很多个chunk，让chunk来进行计算，返回计算结果和指针。主机维护的是指针。
要具体看一下VM和分布式计算


**Test case注意事项**
- 对于值比较的问题，注意输入的范围，考虑int的上下界。有时候，把answer初始化成Long.MAX_VALUE比Integer.MAX_VALUE要好。参考[671](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/)题
