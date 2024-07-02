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

WebUI.verifyElementText(findTestObject('Object Repository/general/mainHeader'), "Add User")

WebUI.click(findTestObject('Object Repository/admin/user management/select_User Role'))

WebUI.click(findTestObject('Object Repository/admin/user management/option_User Role', [('role') : 'Admin']))

WebUI.click(findTestObject('Object Repository/admin/user management/select_Status'))

WebUI.click(findTestObject('Object Repository/admin/user management/option_Status', [('status') : 'Enabled']))

WebUI.setText(findTestObject('Object Repository/admin/user management/input_Employee Name'), 'A')

WebUI.delay(3)

WebUI.sendKeys(findTestObject('Object Repository/admin/user management/input_Employee Name'), Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))

while (WebUI.verifyTextPresent('Invalid', false, FailureHandling.OPTIONAL) == true) {
    WebUI.sendKeys(findTestObject('admin/input_Employee Name'), Keys.chord(Keys.CONTROL, 'a', Keys.BACK_SPACE))

    WebUI.setText(findTestObject('Object Repository/admin/user management/input_Employee Name'), 'A')

    WebUI.delay(3)

    WebUI.sendKeys(findTestObject('Object Repository/admin/user management/input_Employee Name'), Keys.chord(Keys.ARROW_DOWN, 
            Keys.ENTER))
}

Faker faker = new Faker()
username = faker.name().firstName().replaceAll('[^a-zA-Z0-9]', '')
WebUI.setText(findTestObject('Object Repository/admin/user management/input_Username'), username)


password = 'June2024#'
WebUI.setText(findTestObject('Object Repository/admin/user management/input_Password'), password)
WebUI.setText(findTestObject('Object Repository/admin/user management/input_Confirm Password'), password)

WebUI.click(findTestObject('Object Repository/general/btn_Save'))

WebUI.verifyElementText(findTestObject('Object Repository/general/toast'), "Successfully Saved")