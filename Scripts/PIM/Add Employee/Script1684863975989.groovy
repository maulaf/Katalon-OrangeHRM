import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.nio.file.Paths as Paths
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.openqa.selenium.Keys as Keys
import java.nio.file.Path as Path

WebUI.callTestCase(findTestCase('login/Log_TC.001 - Login with Valid Credentials'), [:], FailureHandling.STOP_ON_FAILURE)

TestData data = findTestData('Data Files/employee')

WebUI.click(findTestObject('PIM/span_PIM'))

WebUI.click(findTestObject('PIM/button_Add'))

WebUI.setText(findTestObject('PIM/input_Employee Full Name_firstName'), data.getValue('firstName', 1))

WebUI.setText(findTestObject('PIM/input_Employee Full Name_middleName'), data.getValue('middleName', 1))

WebUI.setText(findTestObject('PIM/input_Employee Full Name_lastName'), data.getValue('lastName', 1))

WebUI.sendKeys(findTestObject('PIM/input_Employee Id'), Keys.chord(Keys.CONTROL, 'a', Keys.BACK_SPACE))

def randomId = RandomStringUtils.randomNumeric(5)

WebUI.setText(findTestObject('PIM/input_Employee Id'), randomId)

String projectDir = RunConfiguration.getProjectDir()

<<<<<<< HEAD:Scripts/PIM/Add Employee/Script1684863975989.groovy
WebUI.uploadFile(findTestObject('PIM/uploadFoto'), 'C:\\Users\\ASUS\\git\\OrangeHRM\\orangeHRM\\Data\\foto.jpg')

WebUI.takeScreenshot()

WebUI.click(findTestObject('PIM/button_Save'))
=======
println('Project Directory: ' + projectDir)

WebUI.uploadFile(findTestObject('OrangeHRM/PIM/uploadFile'), projectDir + '/Data/foto.png')

WebUI.takeScreenshot()

WebUI.click(findTestObject('OrangeHRM/PIM/toggle_Create Login Details'))

def valueFirstName = WebUI.getAttribute(findTestObject('OrangeHRM/PIM/input_Employee Full Name_firstName'), 'value')

def valueLastName = WebUI.getAttribute(findTestObject('OrangeHRM/PIM/input_Employee Full Name_lastName'), 'value')

WebUI.setText(findTestObject('OrangeHRM/PIM/input_Username'), valueFirstName + valueLastName)

//WebUI.click(findTestObject('OrangeHRM/PIM/label_Enabled'))

WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/rb_Status', [('status') : 'Enabled']))

//def uppercaseChars = RandomStringUtils.random(4, 65, 90, true, true) // Generate 4 uppercase letters
//def lowercaseChars = RandomStringUtils.random(4, 97, 122, true, true) // Generate 4 lowercase letters
//def symbols = RandomStringUtils.random(2, 33, 47, false, false) // Generate 2 symbols
//def numbers = RandomStringUtils.randomNumeric(2) // Generate 2 numbers
//
//def allChars = uppercaseChars + lowercaseChars + symbols + numbers


def uppercaseChars = RandomStringUtils.random(4, 'QWERTYUIOPASDFHJKLZXCVBNM') // Generate 4 uppercase letters
def lowercaseChars = RandomStringUtils.random(4, 'qwertyuiopasdfghjklzxcvbnm') // Generate 4 lowercase letters
def symbols = RandomStringUtils.random(2, '!@#$%^&*()') // Generate 2 symbols
def numbers = RandomStringUtils.randomNumeric(2) // Generate 2 numbers

def allChars = uppercaseChars + lowercaseChars + symbols + numbers

WebUI.setText(findTestObject('OrangeHRM/PIM/input_Password'), allChars)

WebUI.setText(findTestObject('OrangeHRM/PIM/input_Confirm Password'), allChars)

WebUI.click(findTestObject('Object Repository/OrangeHRM/PIM/button_Save'))
>>>>>>> origin/master:Scripts/OrangeHRM/PIM/Add Employee/Script1684863975989.groovy

WebUI.takeFullPageScreenshot()

<<<<<<< HEAD:Scripts/PIM/Add Employee/Script1684863975989.groovy
// Get the current date
Calendar calendar = Calendar.getInstance()

// Add one year to the current date
calendar.add(Calendar.YEAR, 1)

// Get the date one year after the current date
Date oneYearAfter = calendar.time

// Define the date format
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd")

// Format the date
String formattedDate = dateFormat.format(oneYearAfter)

// Print the formatted date
println("Date one year after the current date: " + formattedDate)

WebUI.setText(findTestObject('PIM/input_License Expiry Date'), formattedDate)


WebUI.comment(formattedDate)
=======
>>>>>>> origin/master:Scripts/OrangeHRM/PIM/Add Employee/Script1684863975989.groovy
