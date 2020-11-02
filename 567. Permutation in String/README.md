educative上的题目

这题的难点在于想到用一个map存s1的frequency，然后每次s2有一个出现过的字母，就减少频率，同时当完全match频率时，就增加match count。
与之相对，在shrink window的时候，是增加频率，并且减少match count。

另一个重点是要想到window length = s1 的长度时，就要开始shrink window。因为走到这个if的时候还没有完全match，这个时候再扩张，长度都不一样了，就更不会match了
