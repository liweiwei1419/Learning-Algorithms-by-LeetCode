小结如下:

当前的递归中，假设 `root`为 `i`。
那么左子树是由 `[1, i - 1]` 构成的所有可能的组合，右子树是由 `[i + 1, n]` 构成的所有可能的组合。
可以统一记录为用 `[start, end]` 去构建一棵树。
在有了左子树、根结点、右子树的情况下，根据乘法原理很容易计算得出在当前情况下的所有的树。记录 root 到一个 vector 中就可以完整地记录所有结果，返回结果即可。

1、递归每次都返回一堆结点，而不是一个结点。
当递归的返回结果为多个时，为了方便处理，可以把这些结果打包放入一个 vector（列表）中。
2、是典型的 DFS 题目。 

易错点在于，n = 0 时，我们对属于它的链表 res[0] 也要加入结点 null ，否则如果左子树需要 n = 0 的解集，而链表为空，
则会直接跳过里面对右子树的访问。所以我们需要加入一行 `res[0].add(null);` 这样就能解决此问题。