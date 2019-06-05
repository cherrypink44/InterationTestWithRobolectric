package com.example.demorobolectricthao

import android.util.Log
import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements


@Implements(Log::class)
object ShadowLog {
    // ShadowLog class, to print android.util.Log to the console when running tests
    @Implementation
    fun d(tag: String, msg: String) {
        print(tag, "D", msg, null)
    }

    // other implementation
    private fun print(tag: String, level: String, msg: String, throwable: Throwable?) {
        System.out.printf("%s(%s): %s. %s\n", tag, level, msg, throwable ?: "")
    }
}
