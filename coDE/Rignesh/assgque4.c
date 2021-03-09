#include<stdio.h>
int main(){
    printf("enter the numbers  \n");
    float a,b;
    scanf("%f %f",&a,&b);
    int c =a+b;
    printf("the addition is %d\n",c);
    int d =a-b;
    printf("the subtraction is %d\n",d);
    float e =a*b;
    printf("the multiplcation is %f\n",e);
    e =a/b;
    printf("the division a/b is %f\n",e);
    e=b/a;
    printf("the division b/a is %f\n",e);
}
