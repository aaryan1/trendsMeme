package com.tks.trendsmeme.presentation.appComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tks.trendsmeme.R
import javax.inject.Inject

class AppComponents @Inject constructor() {

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
                containerColor = colorResource(R.color.button_color)
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
        image: Int,
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
            //colorFilter = ColorFilter.tint(Color.White)
        )
    }

    @Composable
    fun ReusableLabel(modifier: Modifier,text:String){

        Text(text = text, modifier = modifier, color = Color.White)
    }
    // by default the fontWeight is Light , color is white and fontSize is 16
    @Composable  fun ReusableText(msg: String,
                                  color: Color=Color.White,
                                  fontWeight: FontWeight = FontWeight.Light,
                                  fontSize: Int=16) {
        Text(
            text = msg,
            color = color,
            fontSize = fontSize.sp
        )
    }

    @Composable
    fun ReusableImage(
        modifier: Modifier = Modifier,
        imageResource: Int? = null,
        onClick: () -> Unit = {}
    ) {
        Image(
            painter = if (imageResource != null) painterResource(id = imageResource)
            else painterResource(id = R.drawable.google_icon),
            contentDescription = null,
            modifier = modifier.clickable { onClick() }
        )
    }


}


