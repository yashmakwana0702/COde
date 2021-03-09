#include <math.h>
#include <stdio.h>
int main()
{
    float principal, rate, time, pay;
    printf ("Enter the principal amount: ");
    scanf ("%f", &principal);
    printf ("Enter the interest rate: ");
    scanf ("%f", &rate);
    printf ("Enter the term in years: ");
    scanf ("%f", &time);
    rate=rate/100;
    pay = (principal * rate * pow(1 + rate, time)) / (pow(1 + rate, time) - 1);
    printf("\n payment each year is = %f\n", pay);
    return 0;
}
