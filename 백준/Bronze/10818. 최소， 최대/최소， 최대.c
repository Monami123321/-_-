#include <stdio.h>
int main(void) {
    int n;
    scanf("%d",&n);
    int max = 1 << 31;
    int min = 1 << 29;

    int tmp;
    for(int i = 0; i<n; i++) {
        scanf("%d",&tmp);
        if (max < tmp) {
            max = tmp;
        }
        if(min > tmp) {
            min = tmp;
        }
    }
    printf("%d %d",min,max);

    return 0;
    

}