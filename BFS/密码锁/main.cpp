#include<bits/stdc++.h>
using namespace std;
char a[6],b[6];
int vis[10000];
int ans;
int in(char s[])
{
    if(!vis[(s[0]-'0')*1000+(s[1]-'0')*100+(s[2]-'0')*10+(s[3]-'0')])
    {
        vis[(s[0]-'0')*1000+(s[1]-'0')*100+(s[2]-'0')*10+(s[3]-'0')]=1;
        return 1;
    }
    return 0;
}
struct node
{
    char s[6];
    int step;
};
void bfs()
{
    queue<node>qq;
    node f;
    strcpy(f.s,a);
    f.step=0;
    if(in(a)) qq.push(f);
    while(!qq.empty())
    {
        f=qq.front();
        qq.pop();
        if(strcmp(f.s,b)==0)
        {
           ans=f.step;
           return;
        }
        for(int i=0;i<4;i++)
        {
            char t=f.s[i];
            f.step++;
            if(f.s[i]!='9') f.s[i]++;
            else f.s[i]='1';
            if(in(f.s)) qq.push(f);
            f.s[i]=t;
            if(f.s[i]!='1') f.s[i]--;
            else f.s[i]='9';
            if(in(f.s)) qq.push(f);
            f.s[i]=t;
            if(i<3)
            {
                f.s[i]=f.s[i+1];
                f.s[i+1]=t;
                if(in(f.s)) qq.push(f);
                f.s[i+1]=f.s[i];
                f.s[i]=t;
            }
            f.step--;//»¹Ô­²Ù×÷
        }
    }
}
int main()
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        scanf("%s%s",a,b);
        ans=0;
        memset(vis,0,sizeof(vis));
        bfs();
        printf("%d\n",ans);
    }
}

