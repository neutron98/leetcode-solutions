选择题：

1. TCP的11种状态


编程题：

1. [kth largest element](https://leetcode.com/problems/kth-largest-element-in-an-array/)
2. [Count Primes](https://leetcode.com/problems/count-primes/)
3. [Valid palindrome with at most one element removed, must be o(n)](https://leetcode.com/problems/valid-palindrome-ii/)
4. [34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
5. Lucky numbers
6. [tree traversal](/基础模板/二叉树遍历)
7. [Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
8. [reorder LinkedList: 1-2-3-4-5-6 变成 1-6-2-5-3-4](https://leetcode.com/problems/reorder-list/)  [字符串输入版本](ReorderListString.java)
9. [1423. Maximum Points You Can Obtain from Cards](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)
10. [单词以空间隔开，把单词按照长度升序输出，空格隔开，输入时第一个为大写，输出时也是，如果长度相同保持原顺序。](ProcessWords.java)
11. [539. Minimum Time Difference](https://leetcode.com/problems/minimum-time-difference/)
12. 用多重背包算法来做
13. [25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)
14. [Excel](Excel.java)
15. [Find n-th element in a series with only 2 digits (4 and 7) allowed](FindNth.java)
16. [Climb stairs](https://leetcode.com/problems/climbing-stairs/submissions/)
17. [Decimal To Hex](DecimalToHex.java)
18. [329. Longest Increasing Path in a Matrix](https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/)
19. [179. Largest Number](https://leetcode.com/problems/largest-number/)

[还原二叉树](https://www.jianshu.com/p/2943a21d2a99)


https://github.com/Tscharrl/Shopee-Interview-Backend


https://leetcode-cn.com/circle/discuss/inYBDb/


[数据库范式](https://www.zhihu.com/question/24696366)

2NF: No partial dependencies
不存在*非主属性*对于key的*部分依赖*
（学号，课程名） -> (姓名，年龄，成绩，学分）

符合1NF但是不符合2NF。应该改为：

(课程名） -> (学分)
(学号) -> (姓名，年龄）
(学号，课程名) -> （成绩）

3NF: No transitive dependencies   
不存在非主属性对key的部分函数依赖和*传递依赖*

BCNF： 不存在*主属性*(prime attribute)对于key的部分函数依赖与传递函数依赖
