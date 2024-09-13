package com.tks.trendsmeme.presentation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.tks.trendsmeme.R
import com.tks.trendsmeme.extensions.showToast
import com.tks.trendsmeme.presentation.appComponents.AppComponents
import com.tks.trendsmeme.ui.theme.TrendsMemeTheme
import com.tks.trendsmeme.utils.GetAppComponents
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
                EnterMobileNumberPage()
                //OtpScreen()

            }
        }
    }
}

@Composable
fun EnterMobileNumberPage() {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        GetAppComponents { appComponents ->

            AddAppLogo(appComponents)
            AddMobileEditText()
            AddContinueButton()
            SeparatorWithOrCircle()
            SocialMediaLogin()
            AddPrivacyText()
        }
    }





}

@Composable
fun AddContinueButton() {

    val context=LocalContext.current
    val modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(16.dp)
    AppComponents().RoundedCornerButton(
        onClick = { sendOtp(context) },
        text = "Continue",
        modifier
    )
}

fun sendOtp(context: Context) {
    "Otp sent to your mobile".showToast(context,Toast.LENGTH_LONG)
}

@Composable
fun AddAppLogo(appComponents: AppComponents) {
    //Image(painter = painterResource(id = R.drawable.app_logo_slogan), contentDescription = "app icon",Modifier.size(150.dp),Alignment.TopStart)
    appComponents.ReusableImage(
        modifier = Modifier.size(150.dp),
        imageResource = R.drawable.app_logo_slogan
    )
}

//@Composable
//fun AddMobileEditText(){
//    var mobileNumber by remember { mutableStateOf("") }
//    val modifier = Modifier
//        .fillMaxWidth()
//        .height(100.dp)
//        .padding(16.dp)
//    CustomComponents().ReusableEditText(
//        modifier = modifier,
//        value = mobileNumber,
//        onValueChange = { mobileNumber = it },
//        label = "Enter Mobile Number",
//        keyboardType = KeyboardType.Phone)
//}
@Composable
fun AddMobileEditText() {
    var mobileNumber by remember {
        mutableStateOf(
            ""
        )
    }
    val modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)

    Box(modifier = Modifier
        .wrapContentSize()
        .clip(CircleShape)
        .padding(16.dp)
        .background(colorResource(id = R.color.edittext_back_color))) {
        OutlinedTextField(
            value = mobileNumber,
            onValueChange = { mobileNumber = it },
            textStyle = TextStyle(color= Color.White),
            leadingIcon = {
                Row(verticalAlignment =Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_flag_24),
                        contentDescription = "India Flag",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(
                        modifier =Modifier.width(
                            8.dp
                        )
                    )
                    Text("+91",color=Color.White)
                }
            },
            label = { Text("Enter Mobile Number", color = Color.White) },
            modifier = modifier,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
    }


}

@Composable
fun SeparatorWithOrCircle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .weight(1f)

        )

        // Circle with "OR" text
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(Color.LightGray, shape = CircleShape)
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Or",
                color = Color.DarkGray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Divider(
            modifier = Modifier
                .weight(1f)
        )
    }
}


@Composable
fun SocialMediaLogin() {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        AppComponents().RoundSocialMediaIcon(
            image = R.drawable.facebook_icon,
            contentDescription = "Login with Facebook",
            onClick ={ "Facebook login".showToast(context,Toast.LENGTH_LONG) },
            backgroundColor = Color(0xFF3b5998)
        )

        Spacer(modifier = Modifier.width(20.dp))

        AppComponents().RoundSocialMediaIcon(
            image = R.drawable.google_icon,
            contentDescription = "Login with Google",
            onClick = { "Google Login".showToast(context,Toast.LENGTH_LONG) },
            backgroundColor = Color(0xFFDB4437)
        )
    }
}

@Composable
fun AddPrivacyText(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp), verticalAlignment = Alignment.Bottom) {
        val modifier= Modifier
            .fillMaxWidth()
            .padding(16.dp)
        AppComponents().ReusableLabel(modifier,text = "By proceeding, you consent to our Terms of Service, Privacy Policy, and Content Policy.")
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
    EnterMobileNumberPage()
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

