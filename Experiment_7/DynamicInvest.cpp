#include <iostream>
using namespace std;
void DynamicInvest() {
    int a[100][100];// a[i][j] 前i个项目投资j万元 给第i个项目投资a[i][j]万元时收益最大
    int g[100];// 当前阶段最优分配方案下的收益函数
    int f[100];// 当前阶段输入的第k个项目的收益函数
    int t[100];// t[i] 中间变量 当前第k阶段时  给第k个项目i万元时的最大收益
    int gain[100];// 每一个项目在最优分配方案中的配额
    int rest;// 剩余资金 初始时设置为总投资金额
    int n;// 总投资金额
    int m;// 项目数
    int k;// 阶段
    int i, j;
    /*输入总资金和项目数*/
    cin >> m >> n;
    for (j = 0; j <= n; ++j) {// 第一阶段
        cin >> f[j];// 第一个项目的投资收益函数
        g[j] = f[j];// 第一阶段投资收益函数
        a[1][j] = j;// 第一个项目投资j万元 收益最大时投资给第一个项目j万元 即全部投给第一个项目
    }
    for (k = 2; k <= m; ++k) {// 从第二个阶段到最后一个阶段
        for (i = 0; i <= n; ++i) { // 遍历所有的投资金额
            t[i] = f[i];// 第k阶段初始最优解 认为是把所有金额投给第k个项目
            cin >> f[i];// 输入第k个项目的投资收益函数
            a[k][i] = 0;// 初始化时认为 有i万元资金时 给第k个项目不投资 收益最大
        }
        for (i = 0; i <= n; ++i) {
            for (j = 0; j <= i; ++j) {// 遍历给定金额i下的分配情况
                if (f[j] + g[i - j] > t[i]) {// 如果此分配方案收益更大  则更新分配方案和最大收益
                    t[i] = f[j] + g[i - j];
                    a[k][i] = j;
                }
            }
        }
        for (i = 0; i <= n; ++i)// 更新分配方案
            g[i] = t[i];
    }
    
    rest = n;
    for (i = m; i > 0; --i) {
        gain[i] = a[i][rest];
        rest -= gain[i];
    }
    /*输出每个项目的资金配置*/
    for (i = 1; i <= m; i++)
        cout << gain[i] << endl;
}

int main() {
    DynamicInvest();
    return 0;
}

