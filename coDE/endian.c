#include <stdio.h>
int check_for_endianness();
int main ()
{
  unsigned int x = 0x76543210;
  char *c = (char*) &x;
  int a =  check_for_endianness();
  printf("%d",a);
  printf ("*c is: 0x%x\n", *c);
  if (*c == 0x10)
  {
    printf ("Underlying architecture is little endian. \n");
  }
  else
  {
     printf ("Underlying architecture is big endian. \n");
  }

  return 0;
}
int check_for_endianness()
{
  unsigned int x = 1;
  char *c = (char*) &x;
  return (int)*c;
}
