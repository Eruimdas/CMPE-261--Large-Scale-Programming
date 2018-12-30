#include <iostream>
using namespace std;
#include <string>
#include "Person.h"
#include "Course.h"

class Student : public Person,  public Course{
private:
  int yearint;
  string year;
// determining the year string for the student's year
  void getYear(){
    switch(yearint){
      case 1:
      year = "1st";
      break;
      case 2:
      year = "2nd";
      break;
      case 3:
      year = "3rd";
      break;
      case 4:
      year = "4th";
      break;
    }
  }
// initializing Student and it's super classes.
public:
  Student(string name, int id, int finalg, int midterm, int project, string program,string courseTitle,int year):
  Person(id,name,program),Course(courseTitle,finalg,midterm,project){
    yearint = year;
    getYear();
  }
// printing the student as asked in assignment.
  void toString(){
    cout << Person::getName() << ", " << Person::getId() << ", "<< "who is a "<< year << " year student of ";
    cout << Person::getProgram() << " program,\nacquired " << Course::getMidterm() << " for midterm, ";
    cout << Course::getProject() << " for project and " << Course::getFinal() << " for final, so\n";
    cout << "entitled to have a letter grade " << Course::getGrade() << " for " << Course::getCourseTitle() << ".\n";
  }
};
