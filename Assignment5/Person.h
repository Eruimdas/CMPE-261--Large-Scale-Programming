#include <iostream>
using namespace std;
#include <string>

class Person{
private:
  int id;
  string name;
  string program;
public:
  // initializing the Person and it's getter methods
  Person(int id, string name, string program){
    this -> id = id;
    this -> name = name;
    this -> program = program;
  }
  string getName(){
    return name;
  }

  int getId(){
    return id;
  }

  string getProgram(){
    return program;
  }
};
