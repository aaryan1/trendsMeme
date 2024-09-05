package com.tks.trendsmeme.presentation.customComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class CustomComponents {

@Composable
fun ReusableEditText(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            modifier = modifier,
            textStyle = TextStyle(color= Color.White),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType)

        )
    }

    @Composable
    fun RoundedCornerButton(
        onClick: () -> Unit,
        text: String,
        modifier: Modifier = Modifier,
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            ),
            modifier = modifier
                .background(
                    Color.Black,
                    shape = RoundedCornerShape(10.dp)
                ),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(
                text = text,
                color = Color.White

            )
        }
    }

    @Composable
    fun RoundSocialMediaIcon(
        image: Int, // Resource ID of the image
        contentDescription: String,onClick: () -> Unit,
        backgroundColor: Color
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = contentDescription,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .clickable { onClick() }
                .background(backgroundColor, CircleShape),
            //colorFilter = ColorFilter.tint(Color.White) // Assuming white icon on colored background
        )
    }

    @Composable
    fun ReusableLabel(modifier: Modifier,text:String){

        Text(text = text, modifier = modifier, color = Color.White)
    }
//    @Composable
//    fun ReUsableRow(modifier: Modifier) {
//        Row(modifier = modifier) {
//
//        }
//    }

}


