#include <stdio.h>
int main()
{
    int fig_code;
    float  base, height, area, radius;
    printf(" 1 --> Sphere\n");
    printf(" 2 --> Circle\n");
    printf(" 3 --> Cylinder\n");
    printf(" 4 --> Triangle\n");
    printf("Enter the which Figure's area you want to find \n");
    scanf("%d", &fig_code);
    switch(fig_code)
    {
    case 1:
        printf("Enter the radius of sphere\n");
        scanf("%f", &radius);
        area = 4* 3.142 *radius * radius;
        printf("Area of a Sphere = %f \n", area);
        break;
    case 2:
        printf("Enter the radius of circle\n");
        scanf("%f", &radius);
        area = 3.142 * radius * radius;
        printf("Area of a circle = %f \n", area);
        break;
    case 3:
        printf("Enter the radius and height respectively of cylinder\n");
        scanf("%f %f", &radius, &height);
        area = (2 * 3.142)*((radius*height  )+(radius*radius));
        printf("Area of a cylinder = %f\n", area);
        break;
    case 4:
        printf("Enter the base and height of triangle\n");
        scanf("%f %f", &base, &height);
        area = 0.5 * base * height;
        printf("Area of a Triangle = %f\n", area);
        break;
    default:
        printf("Error in figure code\n");
        break;
    }
    return 0;
}
