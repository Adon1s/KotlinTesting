import jdk.internal.vm.vector.VectorSupport.insert
import org.ktorm.database.Database
import org.ktorm.dsl.*
import java.lang.reflect.Array.set
import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
class DatabaseTests {

    class DatabaseTests {
        val database = Database.connect(
            url = "jdbc:mysql://localhost:3306/HealthData",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = "root"
        )

        @Test
        fun `test insert and retrieve patient`() {
            database.useTransaction {
                val id = DBEntities.Patients.insert {
                    set(it.firstName, "John")
                    set(it.lastName, "Doe")
                    set(it.DOB, LocalDate.parse("1990-01-01")) // convert to LocalDate
                    set(it.gender, "M")
                }

                assertNotNull(id, "Inserted id should not be null")

                val result = from(Patients).select().where { Patients.patientID eq id }.map { row ->
                    row[Patients.firstName] to row[Patients.lastName]
                }

                assertEquals(listOf("John" to "Doe"), result, "Retrieved data should match inserted data")
            }
        }

        @Test
        fun `test insert and retrieve health record`() {
            database.useTransaction {
                val recordId = insert(DBEntities.HealthRecords) {
                    set(it.patientID, 1)
                    set(it.dateOfRecord, "2022-12-12")
                    set(it.bloodPressure, "120/80")
                    set(it.pulse, 80)
                    set(it.O2Sat, 0.98)
                }

                assertNotNull(recordId, "Inserted id should not be null")

                val result = from(DBEntities.HealthRecords).select().where { DBEntities.HealthRecords.recordID eq recordId }.map { row ->
                    row[DBEntities.HealthRecords.bloodPressure] to row[DBEntities.HealthRecords.pulse] to row[DBEntities.HealthRecords.O2Sat]
                }

                assertEquals(listOf("120/80" to 80 to 0.98), result, "Retrieved data should match inserted data")
            }
        }
    }

}