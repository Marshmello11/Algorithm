#include <iostream>
using namespace std;
void DynamicInvest() {
    int a[100][100];// a[i][j] ǰi����ĿͶ��j��Ԫ ����i����ĿͶ��a[i][j]��Ԫʱ�������
    int g[100];// ��ǰ�׶����ŷ��䷽���µ����溯��
    int f[100];// ��ǰ�׶�����ĵ�k����Ŀ�����溯��
    int t[100];// t[i] �м���� ��ǰ��k�׶�ʱ  ����k����Ŀi��Ԫʱ���������
    int gain[100];// ÿһ����Ŀ�����ŷ��䷽���е����
    int rest;// ʣ���ʽ� ��ʼʱ����Ϊ��Ͷ�ʽ��
    int n;// ��Ͷ�ʽ��
    int m;// ��Ŀ��
    int k;// �׶�
    int i, j;
    /*�������ʽ����Ŀ��*/
    cin >> m >> n;
    for (j = 0; j <= n; ++j) {// ��һ�׶�
        cin >> f[j];// ��һ����Ŀ��Ͷ�����溯��
        g[j] = f[j];// ��һ�׶�Ͷ�����溯��
        a[1][j] = j;// ��һ����ĿͶ��j��Ԫ �������ʱͶ�ʸ���һ����Ŀj��Ԫ ��ȫ��Ͷ����һ����Ŀ
    }
    for (k = 2; k <= m; ++k) {// �ӵڶ����׶ε����һ���׶�
        for (i = 0; i <= n; ++i) { // �������е�Ͷ�ʽ��
            t[i] = f[i];// ��k�׶γ�ʼ���Ž� ��Ϊ�ǰ����н��Ͷ����k����Ŀ
            cin >> f[i];// �����k����Ŀ��Ͷ�����溯��
            a[k][i] = 0;// ��ʼ��ʱ��Ϊ ��i��Ԫ�ʽ�ʱ ����k����Ŀ��Ͷ�� �������
        }
        for (i = 0; i <= n; ++i) {
            for (j = 0; j <= i; ++j) {// �����������i�µķ������
                if (f[j] + g[i - j] > t[i]) {// ����˷��䷽���������  ����·��䷽�����������
                    t[i] = f[j] + g[i - j];
                    a[k][i] = j;
                }
            }
        }
        for (i = 0; i <= n; ++i)// ���·��䷽��
            g[i] = t[i];
    }
    
    rest = n;
    for (i = m; i > 0; --i) {
        gain[i] = a[i][rest];
        rest -= gain[i];
    }
    /*���ÿ����Ŀ���ʽ�����*/
    for (i = 1; i <= m; i++)
        cout << gain[i] << endl;
}

int main() {
    DynamicInvest();
    return 0;
}
