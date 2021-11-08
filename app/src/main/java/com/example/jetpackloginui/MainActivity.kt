package com.example.jetpackloginui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackloginui.ui.theme.JetpackLoginUITheme
import java.security.KeyStore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackLoginUITheme {
               LoginUI()

            }
        }
    }
}
@Composable
fun LoginUI(){
    var username by remember {
     mutableStateOf("")
    }
    var prd by remember{
        mutableStateOf("")
    }
    var isPrd by remember{
        mutableStateOf(false)
    }
    val isvalid by derivedStateOf {
        username.isNotBlank() && prd.length>=10
    }
    Scaffold(backgroundColor = MaterialTheme.colors.primary) {
        Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Top) {
            Image(
                painter = painterResource(id = R.drawable.ic_visa),
                contentDescription = "Logo",
                modifier = Modifier.weight(1f).size(180.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Card(modifier = Modifier
                .weight(2f)
                .padding(8.dp),shape = RoundedCornerShape(32.dp)) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp)) {
                    Text(text = "WELCOME VISA",fontWeight = FontWeight.Bold,fontSize=32.sp)
                    Column(modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
                     Spacer(modifier=Modifier.weight(1f))
                        OutlinedTextField(
                            value = username,
                            onValueChange = {username=it},
                            label={
                              Text(text = "UserName")
                            },
                            trailingIcon = {
                                IconButton(onClick = { username=""}) {
                                    Icon(imageVector = Icons.Default.Face, contentDescription = "UserName")
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            value = prd,
                            onValueChange = {prd=it},
                            label = {
                                Text(text = "Password")
                            },
                            singleLine = true,
                            visualTransformation = if(isPrd) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(onClick = {isPrd=!isPrd}) {
                                    Icon(imageVector = if(isPrd) Icons.Default.Visibility else Icons.Default.VisibilityOff, contentDescription = "Psd")
                                }
                            }
                        )
                        Spacer(modifier=Modifier.height(8.dp))
                        Button(onClick = { /*TODO*/ },modifier=Modifier.fillMaxWidth(),shape= RoundedCornerShape(16.dp),enabled = isvalid) {
                            Text(text="Log In")
                        }
                        Spacer(modifier=Modifier.weight(1f))
                        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween){
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(text = "Sign Up",color=Color.Black)
                            }
                            TextButton(onClick = { /*TODO*/ }) {
                                Text(text = "Forget Password?",color= Color.Gray)
                            }
                        }
                    }
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackLoginUITheme {
        LoginUI()
    }
}