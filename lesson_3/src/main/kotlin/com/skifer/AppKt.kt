import com.skifer.teacher.TeacherKt

fun main() {
    val teacher1 = TeacherKt("Константин", "Костенко", 235879)
    val teacher2 = TeacherKt("Константин", "Костенко", 235879)
    println(teacher1 == teacher2)
    teacher1.experience = 235777
    println(teacher1 == teacher2)
}