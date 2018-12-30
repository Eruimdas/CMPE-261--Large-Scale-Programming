#include <iostream>
using namespace std;
#include <string>
#include <cstdlib>
#include <ctime>

// Hasan Kemik 116207076

// method to simulate the slot machine
void printSlot(int k){
  // creating string array for names
  string slot[4] = {"orange","lemon","lime","cherry"};
  // creating control array to control if they're same or different.
  int control [3] = {0,0,0};

  // simulating and writing randomized outputs.
  for(int i = 0; i < k;i++){
    for(int y = 0; y < 3; y++){
      int x = rand() % 4;
      cout << slot[x] << " ";
      control[y] = x;
    }
    cout << endl;
  }

  //controlling if they're all the same or different
  if(control[0] == control[1] && control[1] == control[2]){
      cout << "You win" << endl;
  }
  else if(control[0] != control[1] && control[0] != control[2] && control[1] != control[2]){
    cout << "You win" << endl;
  } else {
    cout << "You lose" << endl;
  }
}
// creating the randomized seed variable to random different values at different times
// then printing the slot machine for 8 turns.
int main(){
  unsigned seed = time(0);
  srand(seed);
  printSlot(8);
  return 0;
}
