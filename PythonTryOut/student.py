from person import Person
class Student(Person):
    def __init__(self,name,address,dept):
        p = Person(name,address)
        self.dept = dept
    def info():
        return p.getPerson + " " + self.dept
