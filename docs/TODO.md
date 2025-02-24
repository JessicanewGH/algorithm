## 跳表相关 TODO
eg：
LeetCode 632

[1,5,9,13]
[4,12]
[8,12]
[0,7,8,9]
找到一个最窄区间[a,b],如果有多个最窄区间且开始位置最小的那个区间，使得这个区间内至少包含每个数组的一个数
tips:
用有序表
第一次把每个数组的第0个位置的值放有序表
然后弹出一个区间（这个区间肯定包括几个数组的数），记录一个min
 有序表中弹出最小的，这个最小值来自于哪个数组，就再把这个数组的下一个加入有序表
 周而复始
 可以封装每个数组的元素（在哪个数组的哪个位置）

 最窄的且开始位置最小的区间就是答案
## 有序表可以改进ArrayList和LinkedList TODO

做到查询，删除，增加 都达到`O(logN)`级别

Code_0063_AddRemoveGetIndexGreat.java

## 改写有序表的题目核心点

1）分析增加什么数据项可以支持题目

2）有序表一定要保持内部参与排序的key不重复

3）增加这个数据项了，在平衡性调整时，保证这个数据项也能更新正确

4）做到上面3点，剩下就是搜索二叉树怎么实现你想要的接口的问题了

## 各种有序表的性能对比

Code_0061_TreeMapTest.java

资源限制
1）布隆过滤器用于集合的建立与查询，并可以节省大量空间
2）一致性哈希解决数据服务器的负载管理问题
3）利用并查集结构做岛问题的并行计算
4）哈希函数可以把数据按照种类均匀分流
5）位图解决某一范围上数字的出现情况，并可以节省大量空间
6）利用分段统计思想、并进一步节省大量空间
7）利用堆、外排序来做多个处理单元的结果合并

如果求1...1000以内的数的每个数的质数因子之和（数据量固定）
多次调用的方法，可以hardcode结果成一张表，后续所有的方法都可以调用这个表拿结果




每一个项目都有三个数，[a,b,c]表示项目a和b乐队参演，花费为c
给定很多个项目

```
int[][] programs
```
每一个乐队可能在多个项目里都出现了，但是只能挑一次
nums是可以挑选的项目数量，所以一定会有nums*2只乐队被挑选出来
返回一共挑nums轮(也就意味着一定请到所有的乐队)，最少花费是多少？
nums< 9, programs长度小于500，每组测试乐队的全部数量一定是nums*2，
且标号一定是0 ~nums*2-1

分治


向上取整

a/b ->

(a + (b - 1)) / b 

使用加强堆：
Dijkstra算法用自定义堆来优化 ,具体见[图](图.md)

使用加强堆：
题目3：
项目有四个信息:
1)哪个项目经理提的
2)被项目经理润色出来的时间点
3)项目优先级
4)项目花费的时间
项目经理们可以提交项目给程序员们，程序员可以做这些项目。
比如长度为4的数组[1, 3, 2, 2]，表示1号项目经理提的，被项目经理润色出来的时间点是3，优先级2，花 费程序员2个时间。
所以给一个N*4的矩阵，就可以代表N个项目。 给定一个正数pm，表示项目经理的数量，每个项目经理只负责自己的那些项目，并且一次只能提交一个项目 给程序员们，这个提交的项目做完了，才能再次提交。 经理对项目越喜欢，就会越早提交。一个项目优先级越高越被喜欢;如果优先级一样，花费时间越少越喜欢; 如果还一样，被项目经理润色出来的时间点越早越喜欢。 给定一个正数sde，表示程序员的数量，所有经理提交了的项目，程序员会选自己喜欢的项目做，每个人做 完了一个项目，然后才会再来挑选。 当程序员在挑选项目时，有自己的喜欢标准。一个项目花费时间越少越被喜欢;如果花费时间一样，该项目 的负责人编号越小越被喜欢。
返回一个长度为N的数组，表示N个项目的结束时间。
比如:

```
int pms = 2;
int sde = 2;
int[][] programs = { { 1, 1, 1, 2 }, { 1, 2, 1, 1 }, { 1, 3, 2, 2 }, { 2, 1, 1, 2 }, { 2, 3, 5, 5 } };
返回:{3, 4, 5, 3, 9}
```
tips:
项目经理堆
程序员堆
add() -> 加设计书
get() -> 程序员喜欢的项目

[TODO]
给定一个数组arr，给定一个正数k。选出3个不重叠的子数组，每个子数组长度都是k，返回最大的三子数组的最大和。

tips:
dpi  dp反i 包括k个数的最大累加和

[TODO]
一群孩子做游戏，现在请你根据游戏得分来发糖果，要求如下: 
1.每个孩子不管得分多少， 起码分到 1 个糖果。 
2.任意两个相邻的孩子之间，得分较多的孩子必须拿多一些的糖果。 给定一个数组 arr 代表得分数组，请返回最少需要多少糖果。 例如:arr=[1,2,2]，糖果 分配为[1,2,1]，即可满足要求且数量最少，所以返回 4。
【进阶】
原题目中的两个规则不变，再加一条规则: 3.任意两个相邻的孩子之间如果得分一样，糖 果数必须相同。
给定一个数组 arr 代表得分数组，返回最少需要多少糖果。 例如:arr=[1,2,2]，糖果分 配为[1,2,2]，即可满足要求且数量最少，所以返回 5。
【要求】
arr 长度为 N，原题与进阶题都要求时间复杂度为 O(N)，额外空间复杂度为 O(1)。
tips:
画图，
left数组->左边比当前位置小，当前位置+1，左边比当前位置大，当前位置置回1

right数组->右边比当前位置小，当前位置+1，右边比当前位置大，当前位置置回1
每个位置糖果,max(left(i),right(i))

[TODO]
给定一棵二叉树的头节点head，如果在某一个节点x上放置相机，那么x的父节点、x的所 有子节点以及x都可以被覆盖。返回如果要把所有数都覆盖，至少需要多少个相机。
tips:
二叉树递归套路
1. x位置有相机
2. x没相机，但是被覆盖
3. x没相机，也没被覆盖
也可以贪心
   

[TODO]
给定一个路径数组 paths，表示一张图。paths[i]==j 代表城市 i 连向城市 j，如果 paths[i]==i， 则表示 i 城市是首都，一张图里只会有一个首都且图中除首都指向自己之 外不会有环。
例如， paths=[9,1,4,9,0,4,8,9,0,1]，
由数组表示的图可以知道，城市 1 是首都，所以距离为 0，离首都距离为 1 的城市只有城 市 9，离首都距离为 2 的城市有城市 0、3 和 7，离首都距离为 3 的城市有城市 4 和 8， 离首都 距离为 4 的城市有城市 2、5 和 6。所以距离为 0 的城市有 1 座，距离为 1 的 城市有 1 座，距离 为 2 的城市有 3 座，距离为 3 的城市有 2 座，距离为 4 的城市有
3 座。那么统计数组为nums=[1,1,3,2,3,0,0,0,0,0]，nums[i]==j 代表距离为 i 的城市有 j 座。要求实现一个 void 类型的函 数，输入一个路径数组 paths，直接在原数组上调整， 使之变为 nums 数组，即 paths=[9,1,4,9,0,4,8,9,0,1]经过这个函数处理后变成 [1,1,3,2,3,0,0,0,0,0]。
【要求】
如果 paths 长度为 N，请达到时间复杂度为 O(N)，额外空间复杂度为 O(1)。
tips:
方法1 宽度优先遍历
进阶方法：O(N) 空间O(1)
下标循环怼
int next 
int last
怼到首都节点的时候，往回蹦，更新arr 变成负数（表示已经更新过了）
如果怼到负数节点，可以直接回去更新了
首都最后改成0即可

每个位置到首都的距离
[-2,-1,-2,-1,0,-3,-2]
--> 正数变成统计学含义

[TODO]
[四边形不等式](四边形不等式.md)

[TODO]
牛牛和15个朋友来玩打土豪分田地的游戏，牛牛决定让你来分田地，地主的田地可以看成是一个矩形，每个位置有一个价值。分割田地的方法是横竖各切三刀，分成 16 份，作为领导干部，牛牛总是会选择其中总 价值最小的一份田地， 作为牛牛最好的朋友，你希望牛牛取得的田地的价值和尽可能大，你知道这个值最大 可以是多少吗?
输入描述:
每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m(1 <= n, m <= 75)，表示田地 的大小，接下来的 n 行，每行包含 m 个 0-9 之间的数字，表示每块位置的价值。
输出描述: 输出一行表示牛牛所能取得的最大的价值。
输入例子: 4 4
3 3 3 2
3 2 3 3
3 3 3 2
2 3 2 3
输出例子: 2
tips:
长方形中，求出任意矩阵的累加和
二维前缀和

```
help[i][j] = help[i-1][j] + help[i][j-1] - arr[i-1][j-1] + arr[i]][j]
```

假设竖着三刀已经确定，横着切一刀，怎么让八块最小值尽量大
0...i 怎么切一刀最好 up[i]
N-1...0 怎么切一刀最好 down[i]
枚举每一行
0..i行最优一刀在k位置，0...i+1行最优一刀不需要在k之前去试 -> 差(好(S1,S2)) 模型
1） 子矩阵的累加和 O(1) -> help
2) 枚举所有可能的竖三刀
3） up/down  中间位置 O(N)
   O(N^4) 最优解

[TODO]
给定一个只含0和1二维数组matrix，第0行表示天花板。每个位置认为与上、下、左、右四个方向有粘性，比如：
matrix =
1 0 0 1 0
1 0 0 1 1
1 1 0 1 1
1 0 0 0 0
0 0 1 1 0
注意到0行0列是1，然后能延伸出5个1的一片。同理0行3列也是1，也能延伸出5个1的一片。注意到4行2列是1，然后能延伸出2个1的一片。其中有两片1是粘在天花板上的，而4行2列延伸出来的这片，认为粘不住就掉下来了。
在给定一个二维数组bomb，表示炸弹的位置，比如：
bomb =
2 0
1 3
1 4
0 3
根据matrix和bomb，返回结果[2,3,0,0]。
tips:
并查集
炮弹有1，1变成2，如果是0就维持0
然后看接在天花板上1的数量
按打炮弹的顺序的相反顺序去求
遇到2就变成1，然后以2作为分割点
在看接到天花板1的数量，接在天花板的炮弹数量
然后逆着求(看2的位置），再看接到天花板上炮弹的数量（不包括被炸的砖块）
如果增加了数量 则增加数量 - 1就是掉落的数量

用并查集的时候，
需要查看是否接在天花板上，连在天花板上的一是多少
接在同一个天花板上的1 
用一个Dot类来区分每个点（内存地址不同，点就不同）也可以用数组优化空间

注意：
两个同为天花板集合，合并后，天花板上集合数量不会有变化

[TODO]
给定一个数组arr，如果其中有两个集合的累加和相等，并且两个集合使用的数没有相容 的部分(也就是arr中某数不能同时进这个两个集合)，那么这两个集合叫作等累加和集 合对。返回等累加和集合对中，最大的累加和。
举例:
arr={1,2,3,6} {1,2}和{3}，是等累加和集合对 {1,2,3}和{6}，也是等累加和集合对 返回6
tips:
map:
key：可能的所有差值
value：差值较大的那一对中较小的数
1，2 两个数，差值1
1) 1,0
2) 2,1 
差值较大的那一对中较小的数 第二对中的1

map -> map' 按如上规则不断更新
求最后差值为0的那条记录

[TODO]
字面值不同的子序列
tips：
考虑不重复的情况：
所有不同字面值的子序列中，以
a结尾的有多少..
..
z结尾的有多少..
all记录总的字面值子序列有多少
如果有重复值
那么all的更新需要 all — [重复的字符]原有的数量 
是否考虑空集？

[TODO]
给定整数power，给定一个数组arr，给定一个数组reverse。
含义如下：
arr的长度一定是2的power次方，
reverse中的每个值一定都在0~power范围。
例如power = 2, arr = {3, 1, 4, 2}，reverse = {0, 1, 0, 2}
任何一个在前的数字可以和任何一个在后的数组，构成一对数。
可能是升序关系、相等关系或者降序关系。
arr开始时有如下的降序对：(3,1)、(3,2)、(4,2)，一共3个。
接下来根据reverse对arr进行调整：
reverse[0] = 0, 表示在arr中，划分每1(2的0次方)个数一组，然后每个小组内部逆序，
那么arr变成[3,1,4,2]，此时有3个逆序对
 reverse[1] = 1, 表示在arr中，划分每2(2的1次方)个数一组，然后每个小组内部逆序，
那么arr变成[1,3,2,4]，此时有1个逆序对
reverse[2] = 0, 表示在arr中，划分每1(2的0次方)个数一组，然后每个小组内部逆序，
那么arr变成[1,3,2,4]，此时有1个逆序对。
reverse[3] = 2, 表示在arr中，划分每4(2的2次方)个数一组，然后每个小组内部逆序，
那么arr变成[4,2,3,1]，此时有4个逆序对。
所以返回[3,1,1,4]，表示每次调整之后的逆序对数量。

tips:

```
dp[i]: 如果2的i次方个数内部有几个逆序对
```

从dp[2]开始，
假设[3,0,6,2,7,8,6,5]
不是说前面四个中有几个降序对，而是：前面四个中，必须一个来自前两个，一个来自后两个有几个降序对。以这个例子为例：
dp[2] 表示：
3，0，6，2这组中，必须一个来自3，0，一个来自6，2有几个降序对，假设为a
7，8，6，5这组中，必须一个来自7，8，一个来自6，5有几个降序对，假设为b
那么dp[2] = a + b
dp数组建好后，
在建立dp'数组
dp'数组就是求正序对的数量

每次reverse后，其实就是dp[i]和dp'[i]交换即可
dp累加和就是答案

逆序对怎么求？小和问题
归并排序

[TODO]
矩阵中达标正方形（里面全是1）
达标正方形最大值（含有1最多的个数）
tips:

```
dp[i][j] 必须以i,j为右下角的点，向右上方最多能扩多大
```

[TODO]
给定一个二维数组matrix，其中的值不是0就是1，
其中，
内部全是1的所有子矩阵中，含有最多1的子矩阵中，含有几个1？
tips:
压缩数组+单调栈 O(M*N)

单调栈
类似的一个题目：一维数组直方图中，最大矩形
左右两边比我小的离我最近的位置


[TODO]
给定字符串数组words，其中所有字符串都不同，如果words[i]+words[j]是回文串就记 录(i,j)，找到所有记录并返回
例子一:
输入：["abcd","dcba","lls","s","sssll"]
输出：[[0,1],[1,0],[3,2],[2,4]]
解释：输出的每一组数组，两个下标代表字符串拼接在一起，都是回文串
abcddcba、 dcbaabcd 、 slls 、 llssssll
tips:
暴力方法O(N^2 * K)

所有字符串放hashset
假设某个str为aabaaccacc
看前缀
拿出第一个a，是否是回文串
然后看剩下的字符串abaaccacc的逆序在set中有没有，
如果有，就把这个字符串拿出来拼接在str前面
拿出 aa,依次处理
然后同理，看后缀
前缀 + 后缀 + 看自己的逆序有没有 就是最后的结果
O(N*K^2)

检查回文串这件事，在这个算法中的复杂度可以忽略

[TODO]
给定一个字符串，判断这个字符串中哪些前缀/后缀是回文
tips:
manacher算法，回文半径数组

[TODO]
给定无序数组arr，返回其中最长的连续序列的长度
比如：arr=[100,4,200,1,3,2],最长的连续序列为[1,2,3,4],返回4
tips:
最优解 可以做到O(N)
头map key:值 value：长度
尾map key:值 value：长度
依次看能否合并

还可以优化
只需要一张map
key所在的连续区间，一共有多少长度
key不需要删数据，遇到重复值不处理
不区分开头和结尾
脏数据不用管，也不需要删除，不会影响最后的解，只保证开头和结尾即可

[TODO]
public class Query {
    public Node o1;
    public Node o2;
    public Query(Node o1, Node o2) { 
        this.o1 = o1;
        this.o2 = o2; }
}

一个 Query 类的实例表示一条查询语句，表示想要查询 o1 节点和 o2 节点的最近公共 祖先 节点。
给定一棵二叉树的头节点 head，并给定所有的查询语句，即一个 Query 类型的数组 Query[] ques，请返回Node类型的数组Node[] ans，ans[i]代表ques[i]这条查询的答案， 即ques[i].o1和 ques[i].o2 的最近公共祖先。
【要求】
如果二叉树的节点数为 N，查询语句的条数为 M，整个处理过程的时间复杂度要求达到 O(N+M)。

tips：
如果查询一次的话，就用二叉树的递归套路

map:
记录每个节点的父节点
用并查集
父节点+代表节点的包装
第一步，清洗数据
第二步，两个表
问题map 
key：节点  value: 列表，哪些节点和key节点有关系
填写map
见代码

代表节点打上tag即可

[TODO] 状态压缩的动态规划
TSP问题 有N个城市，任何两个城市之间的都有距离，任何一座城市到自己的距离都为0。所有点到点的距 离都存在一个N*N的二维数组matrix里，也就是整张图由邻接矩阵表示。现要求一旅行商从k城市 出发必须经过每一个城市且只在一个城市逗留一次，最后回到出发的k城，返回总距离最短的路的 距离。参数给定一个matrix，给定k。
tips:
f(List A, start)
集合，出发点
通过出发点，把集合A中的所有信息联通后，回到源出发点最优的总距离
有重复解
用位状态替换List
N座城市 (1 << N) - 1 表示N个城市都在
最右侧的1

动态规划
行依次+1
O(2^N * N^2)

[TODO] 
状态压缩的动态规划
贴瓷砖问题你有无限的1*2的砖块，要铺满2*N的区域，不同的铺法有多少种? 
tips:
f(6) = f(5) + f(4) 斐波那契问题

你有无限的1*2的砖块，要铺满M*N的区域，不同的铺法有多少种?
tips:
f(int[] , i)
第i行无瓷砖，限制瓷砖的摆法限制往右边和上面摆
int[] 表示上一行的状态
01110110
0表示无，1表示有
i到后面所有的行都是空白的
i-1行以上全摆满了


[TODO]
https://leetcode.com/problems/remove-boxes
tips:
int f(arr, L,R,K)
arr L..R 消消乐 L前面跟着K个[L]位置上的数，都消掉要多少？

[TODO]
https://leetcode.com/problems/strange-printer/
tips:
范围上尝试
int f(L,R)
贪心：边缘处只能让第一转生成，不会影响最优解
L确定
R的确定


[TODO]
整型数组arr长度为n(3 <= n <= 10^4)，最初每个数字是<=200的正数且满足如下条件： 
1. 0位置的要求：arr[0] <=arr[1] 
2. n-1位置的要求：arr[n-1] <= arr[n-2] 
3. 中间i位置的要求：arr[i] <= max(arr[i-1],arr[i+1]) 但是在arr有些数字丢失了，比如k位置的数字之前是正数，丢失之后k位置的数字为0。 
请你根据上述条件，计算可能有多少种不同的arr可以满足以上条件。 
比如 [6,0,9] 只有还原成 [6,9,9]满足全部三个条件，所以返回1种。 
[6,9,9] 达标

tips:
int f(v,i,s)
如果i位置的数字变成了v，s是右边的数和v的关系
在这种设定下，0....i 有几种有效的变法
假设N-1位置的数不是0，是a
那么只需要调用f(a,N-1,2)
如果N-1位置是0，
那么需要调用f(1,N-1,2) +....+f(200,N-1,2)
三维表

可以优化枚举行为

预处理 
O(600N)

[TODO]
找钱的最小张数问题
用滑动窗口做斜率优化

[TODO]
AVL, SBT, 红黑树
AC自动机
资源限制类的题目

Leetcode 683 K个空花盆
Leetcode 568 最大休假天数

相关题目
LeetCode

1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target

LintCode
406. 和大于S的最小子数组
https://www.lintcode.com/problem/minimum-size-subarray-sum/description