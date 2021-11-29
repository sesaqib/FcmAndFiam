// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.firebase.codelab.fcmandfiam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging

private const val TAG = "FcmAndFiam"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            // Log tokens for testing FCM and FIAM
            FirebaseMessaging.getInstance().token.addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d(TAG, "FCM registration token: ${it.result}")
                } else {
                    Log.e(TAG, "Unable to retrieve registration token", it.exception)
                }
            }
            FirebaseInstallations.getInstance().id.addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d(TAG, "Firebase Installations ID: ${it.result}")
                } else {
                    Log.e(TAG, "Unable to retrieve installation ID", it.exception)
                }
            }
        }
    }
}