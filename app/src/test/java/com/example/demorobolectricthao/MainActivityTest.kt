package com.example.demorobolectricthao

import android.content.Intent
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import junit.framework.TestCase.assertNotNull
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf


@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    private var mActivity: MainActivity? = null
    private var edtNumber1: EditText? = null
    private var edtNumber2: EditText? = null
    private var tvResult: TextView? = null
    private var btnOk: Button? = null
    private var btnStartNewActivity: Button? = null

    @Before
    fun setUp() {
        mActivity = Robolectric.buildActivity<MainActivity>(MainActivity::class.java).create().get()
        edtNumber1 = mActivity?.findViewById(R.id.edtNumber1)
        edtNumber2 = mActivity?.findViewById(R.id.edtNumber2)
        tvResult = mActivity?.findViewById(R.id.tvResult)
        btnOk = mActivity?.findViewById(R.id.btnOk)
        btnStartNewActivity = mActivity?.findViewById(R.id.btnStartNewActivity)
    }

    @Test
    fun testResult() {
        edtNumber1?.setText("8")
        edtNumber2?.setText("1")
        btnOk?.performClick()
        assertThat(tvResult?.text.toString(), equalTo("9"))
    }

    @Test
    fun testNotNull() {
        assertNotNull(edtNumber1)
        assertNotNull(edtNumber2)
        assertNotNull(tvResult)
        assertNotNull(btnOk)
        assertNotNull(mActivity)
    }

    @Test
    fun testInputValue() {
        assertTrue(TextUtils.isDigitsOnly(edtNumber1?.text))
        assertTrue(TextUtils.isDigitsOnly(edtNumber2?.text))
    }

    @Test
    fun test_StartNewActivity_Case_1() {
        btnStartNewActivity?.performClick()

        val shadowActivity = shadowOf(mActivity)
        val intent = shadowActivity.nextStartedActivity

        assertThat(intent.component?.className, equalTo(SecondActivity::class.java.name))
    }

    @Test
    fun test_StartNewActivity_Case_2() {
        btnStartNewActivity?.performClick()

        val expectedIntent = Intent(mActivity, SecondActivity::class.java)
        val shadowActivity = shadowOf(mActivity)
        val actualIntent = shadowActivity.nextStartedActivity

        assertTrue(actualIntent.filterEquals(expectedIntent))
    }
}