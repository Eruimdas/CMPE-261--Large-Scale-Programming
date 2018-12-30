#include <iostream>
using namespace std;
#include <string>
#include "Student.h"

int main(){
  //  Student(string name, int id, int final, int midterm, int project, string program,string courseTitle,int year)
  // creating 3 different student objects
  Student s1("Hasan Kemik", 116207076, 90, 70, 100, "Computer Engineering", "CMPE 261", 3);
  Student s2("Doğukan Korkut", 115207053,75,75,75,"Mechantronics Engineering", "MECA 321", 4);
  Student s3("M. Berkin Dal", 116207061,100,100,100,"Mechantronics Engineering","Meca 211", 2);
  // testing their toString methods along with their getter methods.
  s1.toString();
  s2.toString();
  s3.toString();
}
