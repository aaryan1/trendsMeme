package com.tks.trendsmeme.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.tks.trendsmeme.R
import com.tks.trendsmeme.extensions.showToast
import com.tks.trendsmeme.ui.theme.TrendsMemeTheme
import com.tks.trendsmeme.utils.SingleSelectDialog
import androidx.compose.material3.Text as Text1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().setKeepOnScreenCondition(
            condition = { false }
        )
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrendsMemeTheme {
                LoginScreen()
                //MyScreen()
            }
        }
    }
}


@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(painter = painterResource(id = R.drawable.baseline_cloud_done_96), contentDescription = "app icon",Modifier.size(100.dp))

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text1("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text1(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { context.showToast(context.getString(R.string.login_success),Toast.LENGTH_SHORT) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text1("Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

@Composable
fun MyScreen() {

    var showDialog by remember {
        mutableStateOf(
            false
        )
    }
    var selectedFruit by remember {
        mutableStateOf<String?>(
            null
        )
    }
    val fruits = listOf("Apple", "Banana", "Orange", "Grape")

    Column {
        Text("Selected fruit: $selectedFruit")
        Button(onClick = {
             showDialog = true
        }) {
            Text("Show Dialog")
        }
        if (showDialog) {
            SingleSelectDialog(
                options = fruits,
                selectedOption = selectedFruit,
                onOptionSelected = { selectedFruit = it },
                onDismiss = { showDialog = false }
            )
        }
    }
}

