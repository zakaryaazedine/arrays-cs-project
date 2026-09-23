package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];
        for (int i=0;i<students.length;i++) if (students[i].getAge() > oldest.getAge()) oldest = students[i];
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int countAdult =0;
        for (int i=0;i<students.length;i++) if (students[i].getAge() >= 18) countAdult++;
        return countAdult;

    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        int sum =0;
        for(int i=0;i<students.length;i++) sum+= students[i].getGrade();
        double avg = (double) sum / students.length;
        return avg;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        boolean found = false;
        Student foundStudent = students[0];
        for (int i=0;i<students.length;i++) if (students[i].getName().equals(name)) {
            foundStudent = students[i];
            found = true;
        }
        if (found) return foundStudent;
        else return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students , (a,b) -> Integer.compare(b.getGrade(),a.getGrade()));
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (int i=0;i<students.length;i++) if (students[i].getGrade()>=15) System.out.println(students[i].getName());
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (int i=0;i<students.length;i++) if(students[i].getId() == id){
            students[i].setGrade(newGrade);
            return true;
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for(int i=0;i< students.length;i++){
            for(int j=i+1;j< students.length;j++){
                if(students[i].getName().equals(students[j].getName())){
                    System.out.println("Duplicates found");
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] new_arr=new Student[students.length+1];
        for(int i=0;i<students.length;i++) new_arr[i]=students[i];
        new_arr[new_arr.length-1]=newStudent;
        return new_arr;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student [] arr = new Student[5];
        arr[0] = new Student(1,"Zakarya", 20,19);
        arr[1] = new Student(2,"Mohamed");
        arr[2] = new Student(3,"Moad", 19,6);
        arr[3] = new Student(4,"Oumaima", 17);
        arr[4] = new Student(5,"Latifa", 22,13);



        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("Oldest Student: "+ ManageStudent.findOldest(arr));


        // 3) Count adults
        System.out.println("Number of adults: "+ ManageStudent.countAdults(arr));


        // 4) Average grade
        System.out.println("Average grade: "+ ManageStudent.averageGrade(arr));


        // 5) Find by name
        if(ManageStudent.findStudentByName(arr,"Zakarya") == null) System.out.println("Student not found");
        else System.out.println("Zakarya found");

        // 6) Sort by grade desc
        // sort function
        ManageStudent.sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated=ManageStudent.updateGrade(arr,3,10);
        System.out.println("\nUpdated id=3? " + updated);
        System.out.println(findStudentByName(arr, "Moad"));

        // 9) Duplicate names
        if(ManageStudent.hasDuplicateNames(arr)) System.out.println("The array contains some students with the same name");
        else System.out.println("The array has no students with the same name");


        // 10) Append new student
        Student s=new Student(6,"Meriem",23,11);
        arr=ManageStudent.appendStudent(arr,s);

        // 11)
        Student[][] classx = new Student[2][3];
        classx[0][0] = arr[0];
        classx[0][1] = arr[1];
        classx[0][2] = arr[2];
        classx[1][0] = arr[3];
        classx[1][1] = arr[4];
        classx[1][2] = s;

        System.out.println("Names of students class by class : ");
        for(int i=0;i<classx.length;i++){
            System.out.println("Class "+(i+1));
            for (int j=0;j<classx[0].length;j++) System.out.println(classx[i][j]);
        }

        System.out.println("Best student per class : ");
        for(int i=0;i<classx.length;i++){
            ManageStudent.sortByGradeDesc(classx[i]);
            System.out.println(classx[i][0]);
        }
    }
}

