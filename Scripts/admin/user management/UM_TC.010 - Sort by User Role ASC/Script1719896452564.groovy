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

import org.junit.Assert
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement


WebUI.click(findTestObject('Object Repository/admin/span_Admin'))

WebUI.click(findTestObject('Object Repository/admin/user management/dropdown_User Management'))

WebUI.click(findTestObject('Object Repository/admin/user management/ul_Users'))

WebUI.click(findTestObject('Object Repository/admin/user management/sort_User Role'))

WebUI.click(findTestObject('Object Repository/general/sort_ASC'))

TestObject selectorType = new TestObject()
selectorType.addProperty('css', ConditionType.EQUALS, '.oxd-table-body > div > .oxd-table-row')

// find the list of type
List<WebElement> typeList = WebUI.findWebElements(selectorType, 30)
int size = typeList.size()

ArrayList<String> tableValues = new ArrayList<String>();

for (int i = 1; i <= size; i++) {
	String css = ".oxd-table-body > div:nth-of-type($i) div:nth-of-type(3)"
	TestObject dynamicObject = new TestObject('dynamicObject').addProperty('css', ConditionType.EQUALS, css)
	String str = WebUI.getText(dynamicObject)
	String upper =  str.toUpperCase()
	tableValues.add(upper)
}

System.out.println(tableValues)

ArrayList<String> referenceValues = new ArrayList<String>();
for(int i=0; i < tableValues.size(); i++){
	referenceValues.add(tableValues.get(i))
}

Collections.sort(referenceValues)
System.out.println(referenceValues)

assert referenceValues.equals(tableValues)