package eu.balzo.foryouandme.src.app_package

fun manifest(packageName: String) =
    """
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="$packageName">

    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

    <application
        android:name="$packageName.StudyApp"
        android:allowBackup="false"
        android:fullBackupContent="false"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.MyApplication">

        <!-- TODO: set push notification image -->
        <!--
            <meta-data
                android:name="com.google.firebase.messaging.default_notification_icon"
                android:resource="@drawable/your_push_notification_image" />
        -->

    </application>

</manifest>
    """