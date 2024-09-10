package com.tks.trendsmeme.presentation.pages

import androidx.compose.ui.tooling.preview.Preview
import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tks.trendsmeme.R
import com.tks.trendsmeme.extensions.showToast
import com.tks.trendsmeme.presentation.customComponents.CustomComponents

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategorySelectionScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Pick things you'd like to see in your home feed",
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1E1E1E)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SectionTitle(text = "Humor & Memes")

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                CategoryCard2(title = "Hello", icon = R.drawable.google_icon)
                CategoryCard2(title = "Hello", icon = R.drawable.google_icon)
                CategoryCard2(title = "Hello", icon = R.drawable.google_icon)


            }
            SectionTitle(text = "Health & fitness")

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CategoryCard2(title = "Hello", icon = R.drawable.google_icon)
                CategoryCard2(title = "Hello", icon = R.drawable.google_icon)
                CategoryCard2(title = "Hello", icon = R.drawable.google_icon)
            }
            SectionTitle(text = "Sports")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CategoryCard2(title = "Hello", icon = R.drawable.google_icon)
                CategoryCard2(title = "Hello", icon = R.drawable.google_icon)
                CategoryCard2(title = "Hello", icon = R.drawable.google_icon)
            }
            Spacer(modifier = Modifier.height(16.dp))

            AddHomeRedirectButton()
        }
    }
}
@Composable
fun AddHomeRedirectButton() {
    val context= LocalContext.current
    val modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(16.dp)
    CustomComponents().RoundedCornerButton(
        onClick = { "Button clicked".showToast(context, Toast.LENGTH_LONG) },
        text = "Go to home",
        modifier
    )
}

@Composable
fun CategoryCard(title: String, icon: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            icon()
            Text(
                text = title,
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun CategoryCard2(title: String, icon:Int ){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(colorResource(id = R.color.edittext_back_color)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = title,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(colorResource(id = R.color.edittext_back_color), CircleShape),

                )



        }

        CustomComponents().ReusableLabel(
            modifier = Modifier
                .padding(1.dp), text = title
        )
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        modifier = Modifier.padding(vertical = 16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CategorySelectionScreen()
}

