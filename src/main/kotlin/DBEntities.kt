import org.ktorm.schema.*
class DBEntities {
    object Patients : Table<Nothing>("Patients") {
        val patientID = int("patientID").primaryKey()
        val firstName = varchar("firstName")
        val lastName = varchar("lastName")
        val DOB = date("DOB")
        val gender = varchar("gender")
    }

    object HealthRecords : Table<Nothing>("HealthRecords") {
        val recordID = int("recordID").primaryKey()
        val patientID = int("patientID")
        val dateOfRecord = date("dateOfRecord")
        val bloodPressure = varchar("bloodPressure")
        val pulse = int("pulse")
        val O2Saturation = decimal("O2Saturation")
    }

}