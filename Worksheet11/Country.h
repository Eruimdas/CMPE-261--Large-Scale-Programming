#include <iostream>
using namespace std;
#include <string>

class Country{
    private:
      string name;
      int population;
      int found_year;

    public:

      Country(){
        name = "deneme";
        population = 15;
        found_year = 2018;
      }

      Country(string name, int population, int found_year){
        this -> name = name;
        this -> population = population;
        this -> found_year = found_year;
      }

      Country(string name, int found_year){
        this -> name = name;
        this -> found_year = found_year;
      }

      int getfoundYear(){
        return found_year;
      }

      int getPopulation(){
        return population;
      }

      string getName(){
        return name;
      }

      void setFoundYear(int year){
        found_year = year;
      }

      void setPopulation(int pop){
        population = pop;
      }

      void setName(string name){
        this -> name = name;
      }

      void toString(){
        cout<<"name: "<<name<<" population: "<< population<< " foundation year: "<<found_year<<endl;
      }

};
