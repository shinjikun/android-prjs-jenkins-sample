package org.ikariworks.palindrome.prj.test;
import org.ikariworks.palindrome.prj.PalindromePrjActivity;
import com.jayway.android.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;
public class TestMain extends
		ActivityInstrumentationTestCase2<PalindromePrjActivity> {
		private Solo solo;
	public TestMain() {
		super("org.ikariworks.palindrome.prj",PalindromePrjActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(),getActivity());
	}

	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}
	public void testFirstConditionSuccess(){
		solo.enterText(0, "abba");
		solo.clickOnButton("Check!!!");
		assertTrue(solo.searchText("Yes it is"));
	}
	public void testSecondConditionSuccess(){
		solo.enterText(0, "yasay");
		solo.clickOnButton("Check!!!");
		assertTrue(solo.searchText("Yes it is"));
	}
	
	public void testFirstConditionFail(){
		solo.enterText(0, "hello");
		solo.clickOnButton("Check!!!");
		assertTrue(solo.searchText("No it isn't"));
	}
	public void testSecondConditionFail(){
		solo.enterText(0, "helldo");
		solo.clickOnButton("Check!!!");
		assertTrue(solo.searchText("No it isn't"));
	}
}
