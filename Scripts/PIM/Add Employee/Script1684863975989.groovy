import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.nio.file.Paths

import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths
import java.text.SimpleDateFormat
import java.util.Calendar

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


WebUI.uploadFile(findTestObject('PIM/uploadFoto'), 'C:\\Users\\ASUS\\git\\OrangeHRM\\orangeHRM\\Data\\foto.jpg')

WebUI.takeScreenshot()

WebUI.click(findTestObject('PIM/button_Save'))

WebUI.verifyTextPresent('Success', false)

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
