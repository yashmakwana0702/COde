#include <stdio.h>
int main()
{
unsigned int i = 1;
char *c = (char*)&i;
printf("%X  %d ",&i,c);
if (*c)
	printf("Little endian ");
else
	printf("Big endian");
getchar();
return 0;
}
