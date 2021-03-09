#include <stdio.h>
int main()
{
    int fig_code;
    float  base, height, volume, radius;
    printf(" 1 --> Sphere\n");
    printf(" 2 --> Cone\n");
    printf(" 3 --> Cylinder\n");
    printf(" 4 --> cube\n");
    printf("Enter the which Figure's volume you want to find \n");
    scanf("%d", &fig_code);
    switch(fig_code)
    {
    case 1:
        printf("Enter the radius of sphere\n");
        scanf("%f", &radius);
        volume = (4*22*radius*radius*radius)/(7*3);
        printf("volume of a Sphere = %f \n", volume);
        break;
    case 2:
        printf("Enter the radius and height respectively of Cone\n");
        scanf("%f %f", &radius, &height);
        volume = 3.142*radius*radius * (height/3) ;
        printf("volume of a cone = %f\n", volume);
        break;
    case 3:
        printf("Enter the radius and height respectively of cylinder\n");
        scanf("%f %f", &radius, &height);
        volume = 3.142*radius*radius * height ;
        printf("volume of a cylinder = %f\n", volume);
        break;
    case 4:
        printf("Enter the side of cube \n");
        scanf("%f", &base);
        volume =  base * base * base;
        printf("volume of a cube = %f\n", volume);
        break;
    default:
        printf("Error in figure code\n");
        break;
    }
    return 0;
}
