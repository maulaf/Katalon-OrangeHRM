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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.github.javafaker.Faker as Faker

WebUI.click(findTestObject('Object Repository/admin/span_Admin'))

WebUI.click(findTestObject('Object Repository/admin/user management/dropdown_User Management'))

WebUI.click(findTestObject('Object Repository/admin/user management/ul_Users'))

WebUI.click(findTestObject('general/btn_Add'))

WebUI.click(findTestObject('Object Repository/general/btn_Save'))

userRole = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//label[text()='User Role']/parent::div/following-sibling::div/following-sibling::span")

WebUI.verifyElementText(userRole, "Required")

employeeName = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//label[text()='Employee Name']/parent::div/following-sibling::div/following-sibling::span")

WebUI.verifyElementText(employeeName, "Required")

status = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//label[text()='Status']/parent::div/following-sibling::div/following-sibling::span")

WebUI.verifyElementText(status, "Required")

username = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//label[text()='Username']/parent::div/following-sibling::div/following-sibling::span")

WebUI.verifyElementText(username, "Required")

password = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//label[text()='Password']/parent::div/following-sibling::div/following-sibling::span")

WebUI.verifyElementText(password, "Required")

