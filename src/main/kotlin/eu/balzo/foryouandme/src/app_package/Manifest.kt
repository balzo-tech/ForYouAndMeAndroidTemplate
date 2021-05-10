package eu.balzo.foryouandme.src.app_package

import com.android.tools.idea.wizard.template.ProjectTemplateData

fun manifest(project: ProjectTemplateData) =
    """
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="${project.applicationPackage}">

    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

    <application
        android:name="${project.applicationPackage}.StudyApp"
        android:allowBackup="false"
        android:fullBackupContent="false"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">

        //TODO: set push notification image
        <!--
            <meta-data
                android:name="com.google.firebase.messaging.default_notification_icon"
                android:resource="@drawable/your_push_notification_image" />
        -->

    </application>

</manifest>
    """