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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

WebUI.callTestCase(findTestCase('OrangeHRM/login/01 - login admin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.enableSmartWait()

WebUI.click(findTestObject('Object Repository/OrangeHRM/admin/span_Admin'))

WebUI.click(findTestObject('Object Repository/OrangeHRM/admin/button_Add'))

WebUI.click(findTestObject('Object Repository/OrangeHRM/admin/div_-- Select --User Role'))

WebUI.click(findTestObject('Object Repository/OrangeHRM/admin/list_userRole', [('userRole') : userRole]))

WebUI.click(findTestObject('Object Repository/OrangeHRM/admin/div_-- Select --Status'))

WebUI.click(findTestObject('Object Repository/OrangeHRM/admin/list_status', [('status') : status]))

WebUI.setText(findTestObject('Object Repository/OrangeHRM/admin/input_Employee Name'), name)

WebUI.click(findTestObject('Object Repository/OrangeHRM/admin/list employee', [('name') : name]))

while ( WebUI.verifyTextPresent('Invalid', false, FailureHandling.OPTIONAL) == true) {
	
	WebUI.sendKeys(findTestObject('Object Repository/OrangeHRM/admin/input_Employee Name'), Keys.chord(Keys.CONTROL, 'a', Keys.BACK_SPACE))
	
	WebUI.setText(findTestObject('Object Repository/OrangeHRM/admin/input_Employee Name'), name)
	
	WebUI.click(findTestObject('Object Repository/OrangeHRM/admin/list employee', [('name') : name]))
}

String username = RandomStringUtils.randomAlphabetic(8)

WebUI.setText(findTestObject('Object Repository/OrangeHRM/admin/input_Username'), username)

//WebUI.selectOptionByIndex(findTestObject('Object Repository/OrangeHRM/admin/input_Employee Name'), 1)

//WebUI.sendKeys(findTestObject('Object Repository/OrangeHRM/admin/input_Employee Name'), Keys.chord(Keys.DOWN, Keys.ENTER))

String [][] detailUser = [['Password', password], ['Confirm Password', password]]

for (int input = 0; input < detailUser.length; input++) {
    WebUI.sendKeys(findTestObject('Object Repository/OrangeHRM/admin/input_' + ((detailUser[input])[0])), Keys.chord(Keys.CONTROL, 'a', Keys.BACK_SPACE))

    WebUI.setText(findTestObject('Object Repository/OrangeHRM/admin/input_' + ((detailUser[input])[0])), (detailUser[input])[1])

    WebUI.click(findTestObject('Object Repository/OrangeHRM/admin/button_Save'))
}

