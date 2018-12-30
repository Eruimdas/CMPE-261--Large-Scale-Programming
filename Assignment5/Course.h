#include <iostream>
using namespace std;
#include <string>

class Course{
private:
  string courseTitle;
  int finalg;
  int midterm;
  int project;
// calculating overall grade for course and determining it's letter grade in this method.
  string calculateGrade(){
    int result = 0.55*finalg + 0.35*midterm + 0.10*project;
    if(result >0 && result <= 35){
      return "F";
    }
    else if (result > 35 && result <= 50){
      return "D";
    }
    else if (result > 50 && result <= 75){
      return "C";
    }
    else if (result > 75 && result <= 90){
      return "B";
    }
    else {
      return "A";
    }
  }
  // initializing course class and it's getter methods
public:
  Course(string course, int finalg, int midterm, int project){
    courseTitle = course;
    this -> finalg = finalg;
    this -> midterm = midterm;
    this -> project = project;
  }

  string getGrade(){
    return calculateGrade();
  }

  int getMidterm(){
    return midterm;
  }

  int getProject(){
    return project;
  }

  int getFinal(){
    return finalg;
  }

  string getCourseTitle(){
    return courseTitle;
  }
};
