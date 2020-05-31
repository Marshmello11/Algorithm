#include<iostream>
#define n 5
#define m 4
using namespace std;
int count = 0;
int color[n] = {0};
int graph[n][n] = { 0,1,1,1,0,
                    1,0,1,1,1,
                    1,1,0,1,0,
                    1,1,1,0,1,
                    0,1,0,1,0};
bool isOk(int v){
    for(int j = 0; j < n; j++){
        if(graph[v][j] == 1){
            if(color[v] == color[j]){
                return false;
            }
        }
    }
    return true;
}

void traceback(int v){
    int oldvalue = 0;
    if(v == n){
        count ++;
        return;
    }
    for(int i = 1; i <=m; i++){
        oldvalue = color[v];
        color[v] = i;
        if(isOk(v)){
            traceback(v+1);
        }
        color[v] = oldvalue;
    }
}

int main(){
    traceback(0);
    cout  << "total  plans:" << count <<endl;
    return 0;
}
