package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int newCourse = 7400;
        int[] updatedCourses = new int[registeredCourses.length+1];
        for (int i=0;i<registeredCourses.length;i++) updatedCourses[i] = registeredCourses[i];
        updatedCourses[updatedCourses.length-1] = newCourse;
        System.out.println("Updated courses : ");
        for (int i=0;i<updatedCourses.length;i++) System.out.println(updatedCourses[i]);
        int courseNum = 1020;
        boolean found = false;
        for (int i=0;i<updatedCourses.length;i++){
            if (updatedCourses[i] == courseNum) {
                found = true;
                break;
            }
        }

        if (found) System.out.println(courseNum + " is in the list.");
        else System.out.println(courseNum + " isn't in the list.");
    }
}
