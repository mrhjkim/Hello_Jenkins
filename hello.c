#include <stdio.h>

int main(void) {
  int i,j;
  printf( "Hello, World");
  printf( "Hello, Jenkins");
  printf( "warning for no initialized use %d", i);
  printf( "warning for no initialized use %d", j);

  printf( "I have successfully built and run");
  return 0;
}
