import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
import java.util.Collections
// Open browser and navigate to URL
WebUI.openBrowser('')
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/')

// Wait for page to load and take initial screenshot
WebUI.waitForPageLoad(30)
WebUI.takeScreenshotAsCheckpoint('Screen Shot 1')

// Log in
WebUI.setText(findTestObject('Page_OrangeHRM/input_Username_username'), 'Admin')
WebUI.setEncryptedText(findTestObject('Page_OrangeHRM/input_Password_password'), 'hUKwJTbofgPU9eVlw/CnDQ==')
WebUI.click(findTestObject('Page_OrangeHRM/button_Login'))

// Click Leave via JavaScript fallback
TestObject leaveTab = findTestObject('Page_OrangeHRM/span_Leave')
WebUI.waitForElementClickable(leaveTab, 30)
WebUI.scrollToElement(leaveTab, 10)
WebElement leaveElement = WebUiCommonHelper.findWebElement(leaveTab, 30)
WebUI.executeJavaScript('arguments[0].click();', Collections.singletonList(leaveElement))

// Verify Leave and capture screenshot
WebUI.verifyElementText(findTestObject('Page_OrangeHRM/h6_Leave'), 'Leave')
WebUI.takeScreenshotAsCheckpoint('Screen Shot 2')

// Click My Info via JavaScript fallback
TestObject myInfoTab = findTestObject('Page_OrangeHRM/a_My Info')
WebUI.waitForElementClickable(myInfoTab, 30)
WebUI.scrollToElement(myInfoTab, 10)
WebElement myInfoElement = WebUiCommonHelper.findWebElement(myInfoTab, 30)
WebUI.executeJavaScript('arguments[0].click();', Collections.singletonList(myInfoElement))
WebUI.verifyElementText(findTestObject('Page_OrangeHRM/h6_PIM'), 'PIM')

// Click Dashboard via JavaScript fallback
TestObject dashboardTab = findTestObject('Page_OrangeHRM/span_Dashboard')
WebUI.waitForElementClickable(dashboardTab, 30)
WebUI.scrollToElement(dashboardTab, 10)
WebElement dashboardElement = WebUiCommonHelper.findWebElement(dashboardTab, 30)
WebUI.executeJavaScript('arguments[0].click();', Collections.singletonList(dashboardElement))
WebUI.verifyElementText(findTestObject('Page_OrangeHRM/h6_Dashboard'), 'Dashboard')
WebUI.takeScreenshotAsCheckpoint('Screen Shot 3')

// Close browser
WebUI.closeBrowser()
