#include <stdio.h>
#include<math.h>
int main(){
    double f=0.00, L=0.00,C=0.00;
    printf("Enter inductance in Henrys\n");
    scanf("%lf",&L);
    printf("Enter capacitance in Farads\n");
    scanf("%lf",&C);
    f=1.0/(2*3.142*(sqrt(L*C)));
    printf("Resonant freq of Tank circuit = %lf \n",f);
    return 0;
}
