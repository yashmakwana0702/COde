#include<stdio.h>
int main(){
    int marks[4],total=0;
    for(int i=0;i<4;i++){
        printf("enter the marks for %d  subject :  ",i+1);
        scanf("%d",&marks[i]);
        total+=marks[i];
    }
    printf("the total is %d\n",total);
    float avg;
    avg=total/4;
    printf("the avg or percentage is %f\n ",avg);
    for(int i =0;i<4;i++){
        if(marks[i]<33){
            printf(" the student in failed in %d  subject\n",i+1);
        }
        else{
            printf("the student is pass in %d  subject\n",i+1);        }
    }
    return 0;
}
