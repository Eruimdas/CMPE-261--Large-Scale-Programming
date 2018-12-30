#include <iostream>
using namespace std;
#include <string>
#include "Country.h"

int decreasePop(int pop){
  return pop*0.55;
}

int main(){
  Country c1;
  Country c2("Istanbul",1000,1800);
  Country c3("Zonguldak",1700);
  c1.setName("Oslo");
  c3.setPopulation(10000);

  c1.toString();
  c2.toString();
  c3.toString();

  cout<<"c1 name: "<<c1.getName()<<" c1 pop: "<<c1.getPopulation()<<" c1 found: "<< c1.getfoundYear()<<endl;
  cout<<"c2 name: "<<c2.getName()<<" c2 pop: "<<c2.getPopulation()<<" c2 found: "<< c2.getfoundYear()<<endl;
  cout<<"c3 name: "<<c3.getName()<<" c3 pop: "<<c3.getPopulation()<<" c3 found: "<< c3.getfoundYear()<<endl;

  c1.setPopulation(decreasePop(c1.getPopulation()));
  c3.setPopulation(decreasePop(c3.getPopulation()));

  c1.toString();
  c3.toString();

  return 0;
}
