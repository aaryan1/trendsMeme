package com.tks.trendsmeme.presentation.pages
import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tks.trendsmeme.R
import com.tks.trendsmeme.extensions.showToast
import com.tks.trendsmeme.presentation.customComponents.CustomComponents

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreen() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("OTP", color = colorResource(id = R.color.white)) },
                navigationIcon = {
                    IconButton(onClick = { /* Navigate back */ }) {
                        Icon(
                            imageVector = androidx.compose.material.icons.Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = colorResource(id = R.color.white)

                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                )
            )
        },
        
        // here padding values are taken from scaffold and help us to set the content in center just below the top bar
        content = { padding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
                    .padding(padding) //this is padding equal to the padding values from scaffold
                    .padding(50.dp),// to provide more space then the padding from top app bar
                horizontalAlignment = Alignment.CenterHorizontally,
                //verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "verification code sent to +91-8439367525",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    for (i in 1..4) {
                        Surface(
                            modifier = Modifier
                                .size(80.dp)
                                .padding(8.dp),
                            shape = RoundedCornerShape(8.dp),
                            color = colorResource(id = R.color.edittext_back_color)
                        ) {
                            // Add logic for displaying OTP digits here
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Didn't get the OTP?",
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { resendOtp(context) },
                    modifier = Modifier.width(200.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.edittext_back_color)
                    )
                ) {
                    Text(
                        text = "Resend SMS in 18s",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
               AddContinueButton()
            }
        },

    )
}

fun resendOtp(current: Context) {
    "Otp sent again".showToast(current,Toast.LENGTH_LONG)
}

@Composable
fun AddContinueButton() {
    val context= LocalContext.current
    val modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(16.dp)
    CustomComponents().RoundedCornerButton(
        onClick = { "Otp verified".showToast(context, Toast.LENGTH_LONG) },
        text = "Continue",
        modifier
    )
}
@Preview
@Composable
fun OtpScreenPreview() {
    OtpScreen()
}