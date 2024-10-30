import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.github.javafaker.Faker as Faker
import com.kms.katalon.core.configuration.RunConfiguration

Faker faker = new Faker()

job = faker.job().title()

WebUI.callTestCase(findTestCase('admin/job/job titles/JOB_TC.001 - Navigate to Job Titles Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/admin/job/button_Add'))

WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/admin/job/input_Job Title'), job)

def projectDir = RunConfiguration.getProjectDir()

def filePath = projectDir + '/Data/foto.png'

WebUI.uploadFile(findTestObject('Object Repository/admin/job/upload_Jon Specification'), filePath)

WebUI.setText(findTestObject('Object Repository/admin/job/input_Job Description'), 'description test')

WebUI.click(findTestObject('Object Repository/admin/button_Save'))

TestObject success = new TestObject().addProperty("class", ConditionType.EQUALS, "oxd-toast oxd-toast--success oxd-toast-container--toast")

WebUI.verifyElementPresent(success, 0)